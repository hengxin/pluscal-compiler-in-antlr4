package com.PlusCal.interp.tlaplus;

import com.PlusCal.interp.Require;
import com.PlusCal.interp.symbol.Scope;
import com.PlusCal.interp.symbol.Symbol;
import com.PlusCal.interp.symbol.SymbolTable;
import com.PlusCal.interp.symbol.SymbolType;
import com.PlusCal.parser.PlusCalParserBaseVisitor;
import org.antlr.v4.runtime.ParserRuleContext;
import org.antlr.v4.runtime.tree.ParseTree;
import org.antlr.v4.runtime.tree.TerminalNode;

import java.io.IOException;
import java.util.*;
import java.util.stream.Collectors;

import static com.PlusCal.parser.PlusCalParser.*;
import static com.PlusCal.interp.symbol.SymbolTable.*;
import static com.PlusCal.interp.RuleContextUtils.*;
import static com.PlusCal.interp.tlaplus.Pair.*;
import static com.PlusCal.interp.PlusCalParams.*;

// TODO: Error label
final class ToTlaplusTranslator extends PlusCalParserBaseVisitor<Pair<State, State>> {

    private final List<String> declaredVariables;
    private final List<String> definitions;
    private final MultiMap<Scope, Action> actions;
    private boolean mightOmitPC;
    private boolean omitTerminating;
    private Scope curScope;
    private Init init;
    private boolean hasDefaultInitialization;
    private final Stack<String> context;

    ToTlaplusTranslator() {
        this.actions = new MultiMap<>();
        this.hasDefaultInitialization = false;
        this.mightOmitPC = true;
        this.omitTerminating = true;
        this.context = new Stack<>();
        this.declaredVariables = new ArrayList<>();
        this.definitions = new ArrayList<>();
        this.curScope = GLOBAL;
    }

    @Override
    public Pair<State, State> visitAlgorithm(AlgorithmContext ctx) {
        this.init = new Init();

        if (fairAlgorithm) {
            fairOption = "wf";
        }

        GlobalVardeclsContext vardeclsContext;
        if ((vardeclsContext = ctx.globalVardecls()) != null) {
            visitGlobalVardecls(vardeclsContext);
        }

        if (ctx.definitions() != null) {
            visitDefs(ctx.definitions().defs());
        }

        if (!ctx.procedure().isEmpty()) {
            mightOmitPC = false;
            for (ProcedureContext procedure: ctx.procedure()) {
                curScope = SymbolTable.resolve(procedure.name().getText(), SymbolType.PROCEDURE,
                        procedure.prodVarDecl().size());
                visitProcedure(procedure);
            }
            curScope = GLOBAL;
        }

        if (multi_process) {
            boolean tmpOmitTerm = false, falseAtFirst = false;
            List<Pair<State, State>> psl = new ArrayList<>();
            for (ProcessContext process: ctx.process()) {
                omitTerminating = true;
                curScope = SymbolTable.resolve(process.name().getText(), SymbolType.PROCESS);
                Require.require(!toOriginalText(process.expr()).contains("\n"), ""); // 为方便测试而禁止ProcSet占用多行
                psl.add(visitProcess(process));
                falseAtFirst = falseAtFirst || !omitTerminating; // check if any goto "Done" used, if used, then cannot omit terminating
                checkCompoundStmt(process.compoundStmt());
                tmpOmitTerm = tmpOmitTerm || omitTerminating;
            }
            if (!mightOmitPC) {
                psl.forEach(p -> p.second.backTrack("Done"));
            }
            omitTerminating = !falseAtFirst && tmpOmitTerm;
            curScope = GLOBAL;
        }
        else {
            CompoundStmtContext compoundStmt = ctx.compoundStmt();
            Pair<State, State> ps;
            ps = visitCompoundStmt(compoundStmt);
            Require.require((ps.first instanceof Action) && (ps.second instanceof Action));
            checkCompoundStmt(compoundStmt);
            if (!mightOmitPC) {
                ps.second.backTrack("Done");
            }
        }
        return null;
    }

    /**
     * nothing to return
     */
    @Override
    public Pair<State, State> visitGlobalVardecls(GlobalVardeclsContext ctx) {
        for (VardeclContext vardecl: ctx.vardecl()) {
            if (vardecl.expr() != null) {
                // initialized variables
                init.initGlobalVariable(vardecl.variable().getText(), vardecl.relop.getText(), vardecl.expr());
            }
            else {
                hasDefaultInitialization = true;
            }

        }
        return null;
    }

    @Override
    public Pair<State, State> visitDefs(DefsContext ctx) {
        for (int i = 0; i < ctx.getChildCount(); i++) {
            ParserRuleContext child = (ParserRuleContext) ctx.getChild(i);
            definitions.add(toIndentedString(toOriginalText(child), 0, getStartPos(child)));
        }
        return null;
    }

    @Override
    public Pair<State, State> visitProcedure(ProcedureContext ctx) {
        for (ProdVarDeclContext prodVarDecl: ctx.prodVarDecl()) {
            visitProdVarDecl(prodVarDecl);
        }
        ProdVarDeclsContext prodVarDeclsContext;
        if ((prodVarDeclsContext = ctx.prodVarDecls()) != null) {
            visitProdVarDecls(prodVarDeclsContext);
        }
        visitCompoundStmt(ctx.compoundStmt());
        return null;
    }

    @Override
    public Pair<State, State> visitProdVarDecl(ProdVarDeclContext ctx) {
        if (ctx.expr() != null) {
            init.initProcedureVariable((ProcedureSymbol) curScope, ctx.variable().getText(), ctx.expr());
        }
        else {
            init.initProcedureVariable((ProcedureSymbol) curScope, ctx.variable().getText(), null);
            hasDefaultInitialization = true;
        }
        return null;
    }

    @Override
    public Pair<State, State> visitProdVarDecls(ProdVarDeclsContext ctx) {
        for (ProdVarDeclContext vardecl: ctx.prodVarDecl()) {
            visitProdVarDecl(vardecl);
        }
        return null;
    }

    @Override
    public Pair<State, State> visitProcess(ProcessContext ctx) {
        ProcVardeclsContext vardeclsContext;
        if ((vardeclsContext = ctx.procVardecls()) != null) {
            visitProcVardecls(vardeclsContext);
        }
        return visitCompoundStmt(ctx.compoundStmt());
    }

    @Override
    public Pair<State, State> visitProcVardecls(ProcVardeclsContext ctx) {
        for (VardeclContext vardecl: ctx.vardecl()) {
            if (vardecl.expr() != null) {
                init.initProcessVariable((ProcessSymbol) curScope,
                        vardecl.variable().getText(), vardecl.relop.getText(), vardecl.expr());
            }
            else {
                init.initProcessVariable((ProcessSymbol) curScope, vardecl.variable().getText(), null, null);
                hasDefaultInitialization = true;
            }
        }
        return null;
    }

    private void checkCompoundStmt(CompoundStmtContext ctx) {
        if (!(ctx.stmt().size() == 1 && isStmtType(ctx.stmt(0), WhileContext.class))) {
            mightOmitPC = false;
            omitTerminating = false;
        }
        else {
            WhileContext whileCtx = (WhileContext) ctx.stmt(0).unLabeledStmt();
            if (!whileCtx.expr().getText().equals("TRUE")) {
                mightOmitPC = false;
                omitTerminating = false;
            }
            else {
                if (actions.get(curScope).size() != 1) {
                    mightOmitPC = false;
                }
            }
        }

    }

    @Override
    public Pair<State, State> visitCompoundStmt(CompoundStmtContext ctx) {
        return visitStmtSequence(ctx.stmt());
    }

    private Pair<State, State> visitStmtSequence(List<StmtContext> stmts) {
        StmtContext stmt = stmts.get(0);
        if (stmts.size() == 1 && !labeled(stmt)) {
            return visitStmt(stmt);
        }
        ConjunctionList first = null, cur = null;
        Pair<State, State> s;
        String context = "";
        int i = 0, n = stmts.size();
        boolean afterReturn = false;
        while (i < n) {
            stmt = stmts.get(i);
//            Require.require(!isOneOfStmtType(stmt, CallGotoContext.class), "Not supported");
            if (labeled(stmt)) {
                if (!context.equals("")) exitContext();
                String lbl = stmt.label().Identifier().getText();
                if (i == 0) {
                    first = newAction(lbl);
                    cur = first;
                }
                else {
                    cur.backTrack(lbl);
                    cur = newAction(lbl);
                }
                addNewAction((Action) cur);
                context = lbl;
                enterContext(context);
                s = visitStmt(stmt);
                cur.add(s.first);
                if (afterReturn) {
                    cur.backTrack("Error");
                }
                if (isStmtType(stmt, WhileContext.class)) {
                    i = getElseStateOfWhileStmt(stmts, s, i, n);
                }
                else {
                    i++;
                }
            }
            else {
                s = visitStmt(stmt);
                if (i == 0) {
                    first = new ConjunctionList(getContext(), curScope);
                    cur = first;
                }
                cur.add(s.first);
                i++;
            }
            if (isOneOfStmtType(stmt, CallContext.class, CallReturnContext.class)) {
                CallState callState = (CallState) s.first;
                cur.callProcedure(callState.procedure);
            }
            if (isOneOfStmtType(stmt, ReturnContext.class, CallReturnContext.class)) {
                afterReturn = true;
            }
        }
        if (!context.equals("")) exitContext();
        return makePair(first, cur);
    }

    private int getElseStateOfWhileStmt(List<StmtContext> stmts, Pair<State, State> s, int i, int n) {
        i++;
        if (i < n){
            List<StmtContext> stmtSeq = new ArrayList<>();
            for (; i < n && !labeled(stmts.get(i)); i++) {
                stmtSeq.add(stmts.get(i));
            }
            if (!stmtSeq.isEmpty()) {
                Pair<State, State> whileElse = visitStmtSequence(stmtSeq);
                BranchedState bs = (BranchedState) s.first;
                bs.setFalse(whileElse.first);
            }
        }
        return i;
    }

    @Override
    public Pair<State, State> visitStmt(StmtContext ctx) {
        if (ctx.Plus() != null || ctx.Minus() != null) {
            mightOmitPC = false;
        }
        if (ctx.unLabeledStmt() != null)
            return visit(ctx.unLabeledStmt());
        return visitCompoundStmt(ctx.compoundStmt());
    }

    @Override
    public Pair<State, State> visitAssign(AssignContext ctx) {
        // TODO: may be multi assign in then?
        List<ExprContext> exprs = ctx.expr();
        List<LhsContext> lhss = ctx.lhs();
        if (lhss.size() == 1) {
            ExprContext expr = exprs.get(0);
            LhsContext lhs = lhss.get(0);
            if (isGlobalVar(lhs.variable().getText())) {
                return makePair(new Predicate(getContext(), curScope, lhs, expr, GLOBAL));
            }
            else {
                return makePair(new Predicate(getContext(), curScope, lhs, expr, curScope));
            }
        }
        else {
            ConjunctionList c = new ConjunctionList(getContext(), curScope);
            ExprContext expr; LhsContext lhs;
            for (int i = 0; i < lhss.size(); i++) {
                expr = exprs.get(i); lhs = lhss.get(i);
                State assign;
                if (isGlobalVar(lhs.variable().getText())) {
                    assign = new Predicate(getContext(), curScope, lhs, expr, GLOBAL);
                }
                else {
                    assign = new Predicate(getContext(), curScope, lhs, expr, curScope);
                }
                c.add(assign);
            }
            return makePair(c);
        }
    }

    @Override
    public Pair<State, State> visitIf(IfContext ctx) {

        class IfState extends BranchedState {
            final Pair<State, State> _thenStmtVisited;
            final Pair<State, State> _elseStmtAfterVisited;

            IfState(String context, Scope scope, ExprContext condition,
                    Pair<State, State> _ifSatisfied, Pair<State, State> _else) {
                super(context, scope, condition, _ifSatisfied.first, _else == null? null : _else.first);
                _thenStmtVisited = _ifSatisfied;
                _elseStmtAfterVisited = _else;
            }

            @Override
            public boolean backTrack(String PCNext) {
                boolean b = false;

                if (!_thenStmtVisited.second.context.equals(context)) {
                    b = _thenStmtVisited.second.backTrack(PCNext);
                }
                if (_else != null) {
                    if (!context.equals(_elseStmtAfterVisited.second.context)) {
                        b = _elseStmtAfterVisited.second.backTrack(PCNext) || b;
                        _thenStmtVisited.second.backTrack(PCNext);
                    }
                }

                return super.backTrack(PCNext) || b;
            }
        }

        if (cSyntax) {
            Pair<State, State> _then = visitStmt(ctx.stmt(0)),
            _elssps = ctx.stmt(1) == null ? null : visitStmt(ctx.stmt(1));
            return makePair(new IfState(getContext(), curScope, ctx.expr(0), _then, _elssps));
        }
        else {
            // TODO: pSyntax backtrack
            Pair<State, State> _thenSeq = null, _elseSeq = null;
            State root = null;
            List<StmtContext> stmtSeq = new ArrayList<>();
//            int i = 3; // beginning index of the first statement
//            while (ctx.getChild(i) instanceof StmtContext) {
//                stmtSeq.add((StmtContext) ctx.getChild(i));
//                i++;
//            }
            ExprContext expr = null;

//            for (; i < ctx.getChildCount(); i++) {
//                if (ctx.getChild(i) instanceof TerminalNode) {
//                    TerminalNode terminalNode = (TerminalNode) ctx.getChild(i);
//                    if (terminalNode.getSymbol().getType() == Else
//                            || terminalNode.getSymbol().getType() == ElseIf) {
//                        _then = visitStmtSequence(stmtSeq).first;
//                        BranchedState bs = new BranchedState(getContext(), curScope, expr, _then, null);
//                        if (cur == null) {
//                            root = bs;
//                            cur = root;
//                        }
//                        else {
//                            cur.setFalse(bs);
//                            cur = bs;
//                        }
//                        stmtSeq = new ArrayList<>();
//                    }
//                    else if (terminalNode.getSymbol().getType() == End) {
//                        State s = visitStmtSequence(stmtSeq).first;
//                        if (ctx.Else() == null) {
//                            root = new BranchedState(getContext(), curScope, expr, s, null);
//                        }
//                        else {
//                            Require.require(cur != null, "current branch is null");
//                            cur.setFalse(s);
//                        }
//                        break;
//                    }
//                }
//                else if (ctx.getChild(i) instanceof ExprContext) {
//                    expr = (ExprContext) ctx.getChild(i);
//                }
//                else if (ctx.getChild(i) instanceof StmtContext) {
//                    stmtSeq.add((StmtContext) ctx.getChild(i));
//                }
//            }

            for (int i = ctx.getChildCount() - 3; i >= 0; i--) {
                ParseTree child = ctx.getChild(i);
                if (child instanceof StmtContext) {
                    stmtSeq.add((StmtContext) child);
                }
                else if (child instanceof TerminalNode) {
                    TerminalNode t = (TerminalNode) child;
                    if (t.getSymbol().getType() == Else) {
                        Collections.reverse(stmtSeq);
                        _elseSeq = visitStmtSequence(stmtSeq);
                        stmtSeq.clear();
                    }
                    else if (t.getSymbol().getType() == Then) {
                        Collections.reverse(stmtSeq);
                        _thenSeq = visitStmtSequence(stmtSeq);
                        stmtSeq.clear();
                    }
                    else if (t.getSymbol().getType() == If || t.getSymbol().getType() == ElseIf) {
                        // TODO
                        Require.require(_thenSeq != null);
                        _elseSeq = makePair(new IfState(getContext(), curScope, expr, _thenSeq, _elseSeq));
                        if (t.getSymbol().getType() == If) {
                            root = _elseSeq.first;
                        }
                    }
                }
                else if (child instanceof ExprContext) {
                    expr = (ExprContext) child;
                }
            }

            return makePair(root);
        }

    }

    @Override
    public Pair<State, State> visitWhile(WhileContext ctx) {
        Pair<State, State> ps = visitStmtSequence(ctx.stmt());
        class WhileState extends BranchedState {
            /**
             * permit that the THEN statement and ELSE statement must be a conjunction list
             */
            WhileState(String context) {
                super(context, curScope, ctx.expr(), ps.first, null);
                if (context.equals("ob1")) {
                    new StringBuilder();
                }
                if (ps.first == ps.second) {
                    _ifSatisfied.backTrack(context);
                }
                else {
                    ps.second.backTrack(context);
                }
            }

            @Override
            public String toString(final boolean multi_process,
                                   boolean omitPC, int indent, Collection<String> unchanged, Collection<String> hasChanged) {
                if (ifTrue) {
                    return _ifSatisfied.toString(multi_process, omitPC, indent, unchanged, hasChanged);
                }
                else return super.toString(multi_process, omitPC, indent, unchanged, hasChanged);
            }

            @Override
            public boolean backTrack(String PCNext) {

                return super.backTrack(PCNext);
            }

            @Override
            public void setFalse(State state) {
                super.setFalse(state);
            }
        }
        return makePair(new WhileState(getContext()));
    }

    @Override
    public Pair<State, State> visitEither(EitherContext ctx) {

        class DisjunctionList extends State {
            protected final List<ConjunctionList> states;

            protected DisjunctionList(String context, Scope scope) {
                super(context, scope);
                states = new ArrayList<>();
            }

            @Override
            public Collection<String> getMustChanged() {
                Set<String> l = new HashSet<>(getMayChanged());
                for (State s: states) {
                    l.retainAll(s.getMustChanged());
                }
                return l;
            }

            @Override
            public Collection<String> getMayChanged() {
                Set<String> l = new HashSet<>();
                for (State s: states) {
                    l.addAll(s.getMayChanged());
                }
                return l;
            }

            public void disjunction(State another) {
                if (another instanceof ConjunctionList) {
                    states.add((ConjunctionList) another);
                }
                else states.add(new ConjunctionList(context, scope, another));
            }

            @Override
            public String toString(final boolean multi_process,
                                   boolean omitPC, int indent, Collection<String> unchanged, Collection<String> hasChanged) {
                StringBuilder sb = new StringBuilder();
                Collection<String> c = new ArrayList<>(unchanged);
                if (!states.isEmpty()){
                    sb.append("\\/ ").append(states.get(0).toString(multi_process, omitPC, indent + 3, c, hasChanged));

                    int n = states.size();
                    for (int i = 1; i < n; i++) {
                        c = new ArrayList<>(unchanged);
                        sb.append(newLine("\\/ " + states.get(i).toString(multi_process, omitPC, indent + 3, c, hasChanged), indent));
                    }
                }
                return sb.toString();
            }

            @Override
            public boolean backTrack(String PCNext) {
                boolean anyJumped = states.stream().anyMatch(ConjunctionList::hasJumpedToAnotherAction);
                if (anyJumped) {
                    states.stream().filter(cj -> !cj.hasJumpedToAnotherAction()).forEach(s -> s.backTrack(PCNext));
                }
                return anyJumped;
            }
        }
        DisjunctionList disjunctionList = new DisjunctionList(getContext(), curScope);

        List<StmtContext> stmtSeq = new ArrayList<>();
        for (int i = 0; i < ctx.getChildCount(); i++) {
            if (ctx.getChild(i) instanceof TerminalNode) {
                TerminalNode tNode = (TerminalNode) ctx.getChild(i);
                if (pSyntax && tNode.getSymbol().getType() == End) {
                    break;
                }
                else {
                    if (i > 0) {
                        disjunctionList.disjunction(visitStmtSequence(stmtSeq).first);
                        stmtSeq = new ArrayList<>();
                    }
                }
            }
            else if (ctx.getChild(i) instanceof StmtContext) {
                stmtSeq.add((StmtContext) ctx.getChild(i));

            }
            else {
                Require.require(false, "cannot reach here");
            }
        }

        disjunctionList.disjunction(visitStmtSequence(stmtSeq).first);

        return makePair(disjunctionList);
    }

    @Override
    public Pair<State, State> visitWith(WithContext ctx) {
        Pair<State, State> ps = visitStmtSequence(ctx.stmt());
        List<InWithVarDeclContext> varDecls = ctx.inWithVarDecl();
        List<InWithVarDeclContext> eqs = new ArrayList<>(),
                ins = new ArrayList<>();
        for (int i = varDecls.size() - 1; i >= 0; --i) {
            InWithVarDeclContext varDecl = ctx.inWithVarDecl(i);
            if (varDecl.relop.getType() == Equal) {
                eqs.add(varDecl);
            }
            else {
                ins.add(varDecl);
            }
        }

        if (eqs.isEmpty()) {
            QuantifierState s = existSatisfy(getContext(), ps.first);
            for (InWithVarDeclContext in: ins) {
                s.addQuantifierBound(in.variable().getText(), in.expr());
            }
            return makePair(s);
        }
        else {
            State predicates = ps.first;
            if (!ins.isEmpty()) {
                QuantifierState qs = existSatisfy(getContext(), predicates);
                for (InWithVarDeclContext in: ins) {
                    qs.addQuantifierBound(in.variable().getText(), in.expr());
                }
                predicates = qs;
            }
            LetInState s = letIn(getContext(), predicates);
            for (InWithVarDeclContext eq: eqs) {
                s.define(eq.variable().getText(), eq.expr());
            }

            return makePair(s);
        }

    }

    @Override
    public Pair<State, State> visitAwait(AwaitContext ctx) {

        return makePair(new State(getContext(), curScope) {
            @Override
            public String toString(final boolean multi_process,
                                   boolean omitPC, int indent, Collection<String> unchanged, Collection<String> hasChanged) {
                return indentedExpr(ctx.expr(), indent, multi_process, hasChanged, scope);
            }
        });
    }

    @Override
    public Pair<State, State> visitPrint(PrintContext ctx) {
        class PrintState extends State {
            private final ExprContext expr;

            PrintState(String context) {
                super(context, curScope);
                this.expr = ctx.expr();
            }

            @Override
            public String toString(final boolean multi_process,
                                   boolean omitPC, int indent, Collection<String> unchanged, Collection<String> hasChanged) {
                final int defaultIndent = indent + 7;
                return "PrintT(" + indentedExpr(expr, defaultIndent, multi_process, hasChanged, scope) + ")";
            }
        }

        return makePair(new PrintState(getContext()));
    }

    @Override
    public Pair<State, State> visitAssert(AssertContext ctx) {
        class AssertionState extends State {
            private final ExprContext expr;
            private final int line;
            private final int positionInLine;

            AssertionState(String context, ExprContext expr) {
                super(context, curScope);
                this.expr = expr;
                this.line = getLine(ctx);
                this.positionInLine = getStartPos(ctx);
            }

            @Override
            public String toString(final boolean multi_process,
                                   boolean omitPC, int indent, Collection<String> unchanged, Collection<String> hasChanged) {
                final int defaultIndent = indent + "Assert(".length();
                return "Assert(" + indentedExpr(expr, defaultIndent, multi_process, hasChanged, scope)
                        + ", " + newLine(assertionFailMsg(), defaultIndent) + ")";
            }

            private String assertionFailMsg() {
                return "\"Failure of assertion at line " +
                        line + ", column " + (positionInLine + 1) + ".\"";
            }
        }

        return makePair(new AssertionState(getContext(), ctx.expr()));
    }

    @Override
    public Pair<State, State> visitSkip(SkipContext ctx) {
        return makePair(BoolState.ALWAYS_TRUE);
    }

    @Override
    public Pair<State, State> visitReturn(ReturnContext ctx) {
        return makePair(new State(getContext(), curScope) {

            @Override
            public Collection<String> getMayChanged() {
                return getMustChanged();
            }

            @Override
            public Collection<String> getMustChanged() {
                Require.require(scope instanceof ProcedureSymbol);
                Collection<String> c = getNamesOfLocalElements(scope);
                c.add("stack");
                return c;
            }

            @Override
            public String toString(boolean multi_process, boolean omitPC, int indent,
                                   Collection<String> unchanged, Collection<String> hasChanged) {

                StringBuilder sb = new StringBuilder();
                Collection<String> c = new ArrayList<>();
                c.add("pc");
                c.addAll(getMustChanged());
                unchanged.removeAll(c);
                hasChanged.removeAll(c);
                int i = 0;
                for (String var: c) {
                    if (i > 0) {
                        sb.append(newLine("", indent));
                    }
                    sb.append("/\\ ").append(var).append("' = ");

                    if (var.equals("stack")) {
                        if (multi_process) {
                            sb.append("[stack EXCEPT ![self] = Tail(stack[self])]");
                        }
                        else {
                            sb.append("Tail(stack)");
                        }
                    }
                    else {
                        if (multi_process) {
                            sb.append("[").append(var).append(" EXCEPT ![self] = Head(stack[self]).")
                                    .append(var).append("]");
                        }
                        else {
                            sb.append("Head(stack).").append(var);
                        }
                    }
                    i++;
                }
                return sb.toString();
            }

        });
    }

    @Override
    public Pair<State, State> visitGoto(GotoContext ctx) {
        mightOmitPC = false;
        if (ctx.label().getText().equals("Done")) {
            omitTerminating = false;
        }
        ConjunctionList cj = new ConjunctionList(getContext(), curScope);
        cj.PCNext = ctx.label().getText();
        return makePair(cj);
    }

    @Override
    public Pair<State, State> visitCall(CallContext ctx) {
        return makePair(new CallState(getContext(), curScope,
                ctx.name().getText(), ctx.expr()));
    }

    @Override
    public Pair<State, State> visitCallGoto(CallGotoContext ctx) {
        mightOmitPC = false;
        // TODO:
        CallState callState = new CallState(getContext(), curScope,
                ctx.name().getText(), ctx.expr());
        callState.backTrack(resolve(ctx.label().getText(), SymbolType.LABEL).name());
        return makePair(callState);
    }

    @Override
    public Pair<State, State> visitCallReturn(CallReturnContext ctx) {
        // TODO:
        return makePair(new CallState(getContext(), curScope,
                ctx.name().getText(), ctx.expr()) {
            @Override
            public Collection<String> getMustChanged() {
                Collection<String> c = super.getMustChanged();
                ProcedureContext p = ((ProcedureSymbol) scope).defContext;
                if (p.prodVarDecls() != null) {
                    for (ProdVarDeclContext vardecl: p.prodVarDecls().prodVarDecl()) {
                        c.add(scope.getLocal(vardecl.variable().getText()).name());
                    }
                }
                return c;
            }

            @Override
            public String toString(boolean multi_process, boolean omitPC, int indent,
                                   Collection<String> unchanged, Collection<String> hasChanged) {
                this.PCNext = multi_process ? "Head(stack[self]).pc" : "Head(stack).pc";
                StringBuilder sb = new StringBuilder(
                        super.toString(multi_process, omitPC, indent, unchanged, hasChanged));
                Collection<String> c = new ArrayList<>();
                ProcedureContext p = ((ProcedureSymbol) scope).defContext;
                if (p.prodVarDecls() != null) {
                    for (ProdVarDeclContext vardecl: p.prodVarDecls().prodVarDecl()) {
                        c.add(scope.getLocal(vardecl.variable().getText()).name());
                    }
                }
                unchanged.removeAll(c);
                hasChanged.removeAll(c);
                for (String var: c) {
                    if (sb.length() == 0) {
                        sb.append("/\\ ");
                    }
                    else {
                        sb.append(newLine("/\\ ", indent));
                    }
                    sb.append(var).append("' = ");
                    if (multi_process) {
                        sb.append("[").append(var).append(" EXCEPT ![self] = Head(stack[self]).")
                                .append(var).append("]");
                    }
                    else {
                        sb.append("Head(stack).").append(var);
                    }
                }
                return sb.toString();
            }
        });
    }

    @Override
    public Pair<State, State> visitMacroCall(MacroCallContext ctx) {
        throw new IllegalStateException("No macro-calls");
    }

    private String getContext() {
        return context.peek();
    }

    private void enterContext(String context) {
        this.context.push(context);
    }

    private void exitContext() {
        context.pop();
    }

    private boolean isGlobalVar(String variable) {
        // 不涉及表达式的分析时，只可能有两层作用域，且最底层一定是GLOBAL
        if (variable.equals("pc") || variable.equals("stack")) {
            return false;
        }
        return curScope == GLOBAL || curScope.getLocal(variable) == null;
    }

    private QuantifierState anySatisfy(String context, State predicates) {
        return new QuantifierState(context, curScope, QuantifierState.QuantifierKind.ANY, predicates);
    }

    private QuantifierState existSatisfy(String context, State predicates) {
        return new QuantifierState(context, curScope, QuantifierState.QuantifierKind.EXIST, predicates);
    }

    private LetInState letIn(String context, State predicates) {
        return new LetInState(context, curScope, predicates);
    }

    private static String getVariable(String var) {
        return var;
    }

    /**
     * state with only TRUE or FALSE in a conjunction list or a disjunction list
     */
    private static class BoolState extends State {
        static final BoolState ALWAYS_TRUE = new BoolState(true);
        static final BoolState ALWAYS_FALSE = new BoolState(false);

        private final String value;

        BoolState(boolean b) {
            super("", null);
            this.value = b? "TRUE" : "FALSE";
        }

        @Override
        public String toString(final boolean multi_process,
                               boolean omitPC, int indent, Collection<String> unchanged, Collection<String> hasChanged) {
            return value;
        }
    }

    private static class ConjunctionList extends State {
        protected final List<State> states;
        protected ProcedureSymbol procedureCalled;

        protected ConjunctionList(String context, Scope scope) {
            super(context, scope);
            states = new ArrayList<>();
            procedureCalled = null;
        }

        protected ConjunctionList(String context, Scope scope, State...state) {
            super(context, scope);
            states = new ArrayList<>(Arrays.asList(state));
            procedureCalled = null;
        }

        @Override
        public Collection<String> getMustChanged() {
            List<String> l = new ArrayList<>();
            for (State s: states) {
                l.addAll(s.getMustChanged());
            }
            return l;
        }

        @Override
        public Collection<String> getMayChanged() {
            List<String> l = new ArrayList<>();
            for (State s: states) {
                l.addAll(s.getMayChanged());
            }
            return l;
        }

        public void add(State another) {
            if (another instanceof ConjunctionList && ((ConjunctionList) another).onlyJump()) {
                this.PCNext = another.PCNext;
            }
            else states.add(another);
        }

        @Override
        public String toString(final boolean multi_process, boolean omitPC,
                               int indent, Collection<String> unchanged, Collection<String> hasChanged) {
            StringBuilder sb = new StringBuilder();
            Collection<String> mayChange = getMayChanged();
            unchanged.removeAll(mayChange);
            mayChange.removeAll(getMustChanged());

            if (!states.isEmpty()) {
                sb.append("/\\ ")
                        .append(states.get(0).toString(multi_process, omitPC, indent + 3, mayChange, hasChanged));
                for (int i = 1; i < states.size(); i++) {
                    sb.append(newLine("/\\ " +
                            states.get(i).toString(multi_process, omitPC, indent + 3, mayChange, hasChanged), indent));
                }
            }

            if (PCNext != null && !PCNext.equals("")) {
                sb.append(initCalledProcedureVariables(indent));
                if (!omitPC) {
                    if (!onlyJump()) {
                        sb.append(newLine("", indent));
                    }
                    sb.append(jump(PCNext, scope, multi_process, hasChanged));
                }
            }

            if (unchanged.size() > 0) {
                sb.append(newLine("/\\ " + unchanged(unchanged), indent));
            }
            return sb.toString();
        }

        final String initCalledProcedureVariables(int indent) {
            StringBuilder sb = new StringBuilder();
            if (procedureCalled != null) {
                ProcedureContext p = procedureCalled.defContext;
                if (p.prodVarDecls() != null) {
                    StringBuilder forEachDeclared;
                    for (ProdVarDeclContext pvardecl: p.prodVarDecls().prodVarDecl()) {
                        forEachDeclared = new StringBuilder("/\\ ");
                        String variable = procedureCalled.getLocal(pvardecl.variable().getText()).name();
                        if (multi_process) {
                            forEachDeclared.append(variable).append("' = [")
                                    .append(variable).append(" EXCEPT ![");
                            String self;
                            if (scope instanceof ProcessSymbol && ((ProcessSymbol) scope).isEqual) {
                                self = indentedExpr(((ProcessSymbol) scope).expr, indent + forEachDeclared.length());
                            }
                            else {
                                self = "self";
                            }
                            forEachDeclared.append(self).append("] = ");
                        }
                        else {
                            forEachDeclared.append(variable).append("' = ");
                        }
                        String value = pvardecl.expr() == null ?
                                "defaultInitValue" : indentedExpr(pvardecl.expr(), forEachDeclared.length());
                        forEachDeclared.append(value);
                        if (multi_process) {
                            forEachDeclared.append("]");
                        }
                        sb.append(newLine(forEachDeclared.toString(), indent));
                    }
                }
            }
            return sb.toString();
        }

        protected boolean onlyJump() {
            return states.isEmpty() && PCNext != null && !PCNext.equals("");
        }

        public void callProcedure(ProcedureSymbol procedure) {
            this.procedureCalled = procedure;
            this.PCNext = procedure.getLocalLabels().get(0).name();
        }

        protected static String jump(final String PCNext, final Scope scope,
                                     final boolean multi_process, final Collection<String> hasChanged) {
            StringBuilder sb = new StringBuilder();
            sb.append("/\\ pc' = ");
            if (!multi_process || scope == GLOBAL) {
                sb.append("\"").append(PCNext).append("\"");
            }
            else if (scope instanceof ProcedureSymbol) {
                sb.append("[pc EXCEPT ![self] = \"").append(PCNext).append("\"]");
            }
            else {
                ProcessSymbol p = (ProcessSymbol) scope;
                if (p.isEqual) {
                    sb.append("[pc EXCEPT ![");
                    sb.append(indentedExpr(p.expr, sb.length(), true, hasChanged, scope))
                            .append("] = \"").append(PCNext).append("\"]");
                }
                else {
                    sb.append("[pc EXCEPT ![self] = \"").append(PCNext).append("\"]");
                }

            }
            return sb.toString();
        }

        protected boolean hasJumpedToAnotherAction() {
            if (PCNext != null && !PCNext.equals("")) {
                return true;
            }
            if (!states.isEmpty()) {
                State s = states.get(states.size() - 1);
                if (s instanceof BranchedState) {
                    return ((BranchedState) s).hasJumpedToAnotherAction();
                }
            }
            return false;
        }

        @Override
        public boolean backTrack(String PCNext) {
            if (context.equals("bela")) {
                new String();
            }
            boolean b = false;
            if (!states.isEmpty()){
                b = states.get(states.size() - 1).backTrack(PCNext);
            }
            if (!b && !this.hasJumpedToAnotherAction()) {
                Require.require(!this.hasJumpedToAnotherAction(),
                        "PCNext of "+ context + " has been set " + this.PCNext);
                this.PCNext = PCNext;
            }
            return true;
        }
    }

    private Action newAction(String label) {
        return new Action(label, curScope);
    }

    /**
     * Represent a TLA+ action which is a formula describing
     * a pair of states——the state before executing the action
     * and the state after executing it
     */
    private static class Action extends ConjunctionList {

        Action(String name, Scope scope) {
            super(name, scope);
        }

        public String getName() {
            return context;
        }


        public String toString(final boolean multi_process, final boolean omitPC,
                               int indent, Collection<String> unchanged) {
            StringBuilder sb = new StringBuilder();

            if (omitPC) {
                Require.require(states.size() == 1);
                sb.append(states.get(0).toString(multi_process, true, indent, unchanged, new ArrayList<>()));
            }
            else {
                if (!multi_process || scope == GLOBAL) {
                    sb.append("/\\ pc = \"").append(getName()).append("\"");
                }
                else if (scope instanceof ProcessSymbol && ((ProcessSymbol) scope).isEqual) {
                    ProcessSymbol p = (ProcessSymbol) scope;
                    String self = toIndentedString(toOriginalText(p.expr), "/\\ pc[".length(), getStartPos(p.expr));
                    sb.append("/\\ pc[").append(self).append("] = \"").append(getName()).append("\"");
                }
                else {
                    sb.append("/\\ pc[self] = \"").append(getName()).append("\"");
                }
                sb.append(newLine("", indent));
                List<String> hasChanged = new ArrayList<>();

                sb.append(toString(multi_process, false, indent, unchanged, hasChanged));

            }

            sb.append("\n");
            return sb.toString();
        }

        @Override
        public String toString(final boolean multi_process, boolean omitPC,
                               int indent, Collection<String> unchanged, Collection<String> hasChanged) {
            StringBuilder sb = new StringBuilder();
            Collection<String> mayChange = getMayChanged();
            unchanged.removeAll(mayChange);

            boolean outConjunct = true;

            if (states.size() == 1) {
                if (states.get(0) instanceof ConjunctionList) {
                    ConjunctionList cj = (ConjunctionList) states.get(0);
                    if (cj.onlyJump()) {
                        sb.append(cj.toString(multi_process, omitPC, indent, mayChange, hasChanged));
                        outConjunct = false;
                    }
                }
                else if (states.get(0) instanceof BranchedState) {
                    BranchedState bs = (BranchedState) states.get(0);
                    if (bs.ifTrue) {
                        sb.append(bs.toString(multi_process, omitPC, indent, unchanged, hasChanged));
                        outConjunct = false;
                    }
                }
            }
            if (outConjunct) {
                for (int i = 0; i < states.size(); i++) {
                    if (i > 0) {
                        sb.append(newLine("/\\ ", indent));
                    }
                    else {
                        sb.append("/\\ ");
                    }
                    sb.append(states.get(i).toString(multi_process, omitPC, indent + 3, mayChange, hasChanged));
                }
                if (PCNext != null && !PCNext.equals("")) {
                    sb.append(initCalledProcedureVariables(indent));
                    if (!omitPC) {
                        sb.append(newLine(jump(PCNext, scope, multi_process, hasChanged), indent));
                    }
                }
                if (unchanged.size() > 0) {
                    sb.append(newLine("/\\ " + unchanged(unchanged), indent));
                }
            }

            return sb.toString();
        }
    }

    private static class CallState extends State {
        private final List<ExprContext> params;
        private final ProcedureSymbol procedure;

        CallState(String context, Scope scope,
                         String calledProcedure, List<ExprContext> procedureParams) {
            super(context, scope);
            this.params = procedureParams;
            this.procedure = resolve(calledProcedure, SymbolType.PROCEDURE, params.size());
        }

        @Override
        public Collection<String> getMayChanged() {
            return getMustChanged();
        }

        @Override
        public Collection<String> getMustChanged() {
            Collection<String> c = getNamesOfLocalElements(procedure);
            c.add("stack");
            return c;
        }

        @Override
        public String toString(boolean multi_process, boolean omitPC, int indent,
                               Collection<String> unchanged, Collection<String> hasChanged) {
            StringBuilder sb = new StringBuilder();
            sb.append("/\\ stack' = ");
            if (multi_process) {
                sb.append("[stack EXCEPT ![self] = << [ ");
            }
            else {
                sb.append("<< [ ");
            }
            final int stackValueBeginIndent = indent + sb.length();
            sb.append("procedure |-> \"").append(procedure.name()).append("\"");
            if (!omitPC) {
                sb.append(",");
                sb.append(newLine("pc |-> " + PCNext + "", stackValueBeginIndent));
            }
            for (String var: getNamesOfLocalElements(procedure)) {
                sb.append(",");
                String map = var + " |-> " + var;
                sb.append(newLine(map, stackValueBeginIndent));
                if (multi_process) {
                    String self;
                    if (scope instanceof ProcessSymbol && ((ProcessSymbol) scope).isEqual) {
                        self = indentedExpr(((ProcessSymbol) scope).expr, stackValueBeginIndent + map.length() + 1);
                    }
                    else {
                        self = "self";
                    }
                    sb.append("[").append(self).append("]");
                }
            }
            sb.append(" ] >>");
            sb.append(newLine("\\o stack", stackValueBeginIndent - 4));
            if (multi_process) {
                String self;
                if (scope instanceof ProcessSymbol && ((ProcessSymbol) scope).isEqual) {
                    self = indentedExpr(((ProcessSymbol) scope).expr, stackValueBeginIndent + 5);
                }
                else {
                    self = "self";
                }
                sb.append("[").append(self).append("]");
            }
            sb.append("]");
            StringBuilder forEachParam;
            for (int i = 0; i < procedure.getParameterCount(); i++) {
                NormalVariableSymbol v = procedure.getParameter(i);
                forEachParam = new StringBuilder();
                forEachParam.append("/\\ ").append(v.name()).append("' = ");
                if (multi_process) {
                    forEachParam.append("[").append(v.name()).append(" EXCEPT ![");
                    String self;
                    if (scope instanceof ProcessSymbol && ((ProcessSymbol) scope).isEqual) {
                        self = indentedExpr(((ProcessSymbol) scope).expr, forEachParam.length());
                    }
                    else {
                        self = "self";
                    }
                    forEachParam.append(self).append("] = ");
                    forEachParam.append(indentedExpr(params.get(i), forEachParam.length())).append("]");
                }
                else {
                    forEachParam.append(indentedExpr(params.get(i), forEachParam.length()));
                }
                sb.append(newLine(forEachParam.toString(), indent));
            }
            return sb.toString();
        }

        @Override
        public boolean backTrack(String PCNext) {
            if (this.PCNext == null || this.PCNext.equals("")) {
                this.PCNext = "\"" + PCNext + "\"";
            }
            return true;
        }
    }

    private static class Init {

        private final List<InitPredicate> globalVariables;
        private final MultiMap<String, InitPredicate> processVariables;
        private final MultiMap<String, InitPredicate> procedureVariables;
        private String PCNext;
        private String stack;

        private Init() {
            globalVariables = new ArrayList<>();
            processVariables = new MultiMap<>();
            procedureVariables = new MultiMap<>();
            PCNext = "";
            stack = "";
        }

        public void initGlobalVariable(String variable, String relop, ExprContext value) {
            Require.require(relop.equals("=") || relop.equals("\\in"), "for relop: " + relop);
            globalVariables.add(new InitPredicate(GLOBAL, variable, relop, value));
        }

        public void initProcedureVariable(ProcedureSymbol procedure, String variable, ExprContext value) {
            procedureVariables.map(procedure.name(), new InitPredicate(procedure, variable, "=", value));
        }

        public void initProcessVariable(ProcessSymbol process, String variable, String relop, ExprContext value) {
            Require.require(relop == null || relop.equals("=") || relop.equals("\\in"), "for relop: " + relop);
            processVariables.map(process.name(), new InitPredicate(process, variable, relop, value));
        }

        /**
         * Init PCNext string from given next list
         * @param multiProcess true if is multiprocess
         * @param PCNext should in the same order of resolving from the symbol table
         */
        public void initPC(boolean multiProcess, String...PCNext) {
            if (multiProcess) {
                if (PCNext.length > 0) {
                    StringBuilder sb = new StringBuilder("pc = [self \\in ProcSet |-> ");

                    if (PCNext.length == 1) {
                        sb.append("\"").append(PCNext[0]).append("\"");
                    }
                    else {
                        Collection<ProcessSymbol> processes = SymbolTable.getElementsOfType(SymbolType.PROCESS);
                        int base = sb.length(), i = 0;
                        StringBuilder eachCase;
                        for (ProcessSymbol p : processes) {
                            eachCase = new StringBuilder();
                            if (i == 0) {
                                eachCase.append("CASE ");
                            } else {
                                sb.append("\n");
                                addSpaces(eachCase, base);
                                eachCase.append("  [] ");
                            }
                            int indent;
                            if (p.isEqual) {
                                eachCase.append("self = ");
                            } else {
                                eachCase.append("self \\in ");
                            }
                            indent = eachCase.length();
                            eachCase.append(indentedExpr(p.expr, indent, true, new ArrayList<>(), p))
                                    .append(" -> \"").append(PCNext[i]).append("\"");
                            i++;
                            sb.append(eachCase);
                        }
                    }
                    sb.append("]");
                    this.PCNext = sb.toString();
                }
            }
            else {
                Require.require(PCNext.length == 1, PCNext.length + " uniprocess pc values" );
                this.PCNext = "pc = \"" + PCNext[0] + "\"";
            }
        }

        public void initStack(boolean multi_process) {
            if (multi_process) {
                stack = "stack = [self \\in ProcSet |-> << >>]";
            }
            else {
                stack = "stack = << >>";
            }

        }

        private static class InitPredicate {
            final Scope scope;
            final String variable;
            final ExprContext value;
            final String relop;

            private InitPredicate(Scope scope, String variable, String relop, ExprContext value) {
                Require.require((value == null && relop == null) || relop.equals("=") || relop.equals("\\in"));
                this.scope = scope;
                this.variable = variable;
                this.relop = relop;
                this.value = value;
            }

            @Override
            public String toString() {
                StringBuilder sb = new StringBuilder();
                sb.append(variable);
                if (scope == GLOBAL) {
                    if (value != null) {
                        sb.append(" ").append(relop).append(" ");
                        sb.append(toIndentedString(toOriginalText(value), sb.length(), getStartPos(value)));
                    }
                    else {
                        sb.append(" = defaultInitValue");
                    }
                }
                else if (scope instanceof ProcedureSymbol) {
                    sb.append(" = [ self in ProcSet |-> ");
                    if (value != null) {
                        sb.append(toIndentedString(toOriginalText(value), sb.length(), getStartPos(value))).append("]");
                    }
                    else {
                        sb.append("defaultInitValue]");
                    }
                }
                else {
                    ProcessSymbol p = (ProcessSymbol) scope;
                    if (p.isEqual) {
                        if (value != null) {
                            sb.append(" ").append(relop).append(" ");
                            sb.append(toIndentedString(toOriginalText(value), sb.length(), getStartPos(value)));
                        }
                        else {
                            sb.append(" = defaultInitValue");
                        }
                    }
                    else {
                        if (relop == null) {
                            sb.append(" = [self \\in ");
                            sb.append(toIndentedString(toOriginalText(p.expr), sb.length(), getStartPos(p.expr)));
                            sb.append(" |-> defaultInitValue]");
                        }
                        else if (relop.equals("=")) {
                            sb.append(" = [self \\in ");
                            sb.append(toIndentedString(toOriginalText(p.expr), sb.length(), getStartPos(p.expr)));
                            sb.append(" |-> ");
                            int newlineIndent = sb.length() - sb.lastIndexOf("\n") - 1;
                            sb.append(toIndentedString(toOriginalText(value), newlineIndent, getStartPos(value)))
                                    .append("]");
                        }
                        else {
                            sb.append(" \\in [");
                            sb.append(toIndentedString(toOriginalText(p.expr), sb.length(), getStartPos(p.expr)));
                            sb.append(" -> ");
                            int newlineIndent = sb.length() - sb.lastIndexOf("\n") - 1;
                            sb.append(toIndentedString(toOriginalText(value), newlineIndent, getStartPos(value)))
                                    .append("]");
                        }
                    }
                }
                return sb.toString();
            }
        }

        public String toString() {
            StringBuilder sb = new StringBuilder();
            Require.require(globalVariables.size() > 0, "no global variables");
            sb.append("Init == ");
            int indent = sb.length();
            sb.append("(* Global variables *)");
            for (InitPredicate i: globalVariables) {
                sb.append(newLine("/\\ " + toIndentedString(i.toString(), indent + 3, 0), indent));
            }
            if (!procedureVariables.isEmpty()) {
                for (String p: procedureVariables.keySet()) {
                    sb.append(newLine("(* Procedure " + p + " *)", indent));
                    procedureVariables.get(p).forEach(i ->
                            sb.append(newLine("/\\ " + toIndentedString(i.toString(), indent + 3, 0), indent)));
                }
            }
            if (!processVariables.isEmpty()) {
                for (String p: processVariables.keySet()) {
                    sb.append(newLine("(* Process " + p + " *)", indent));
                    processVariables.get(p).forEach(i ->
                            sb.append(newLine("/\\ " + toIndentedString(i.toString(), indent + 3, 0), indent)));
                }
            }
            if (!stack.equals("")) {
                sb.append(newLine("/\\ " + stack, indent));
            }
            if (this.PCNext != null && !this.PCNext.equals("")) {
                sb.append(newLine("/\\ " + toIndentedString(this.PCNext, indent + 3, 0), indent));
            }
            sb.append("\n");
            return sb.toString();
        }
    }

    private static class Predicate extends State {
        final LhsContext lhs;
        final String variable;
        final ExprContext value;
        final Scope varScope;

        Predicate(String context, Scope scope, LhsContext lhs, ExprContext value, Scope varScope) {
            super(context, scope);
            this.lhs = lhs;
            this.variable = lhs.variable().getText();
            this.value = value;
            this.varScope = varScope;
        }

        @Override
        public Collection<String> getMustChanged() {
            return Collections.singleton(variable);
        }

        @Override
        public Collection<String> getMayChanged() {
            return Collections.singleton(variable);
        }

        @Override
        public String toString(final boolean multi_process, boolean omitPC, int indent,
                               Collection<String> unchanged, Collection<String> hasChanged) {
            unchanged.remove(variable);
            // TODO: 等号右边智能加括号（现在还是无脑加）
            StringBuilder sb = new StringBuilder(variable + "' = ");
            if (!multi_process || varScope == GLOBAL ||
                    (varScope instanceof ProcessSymbol && ((ProcessSymbol) varScope).isEqual)) {
                if (this.lhs != null && this.lhs.children.size() > 1) {
                    sb.append("[").append(variable).append(" EXCEPT !");
                    int nowIndent = sb.length() + indent;
                    sb.append(toIndentedString(toOriginalText(this.lhs, 1, this.lhs.getChildCount()), nowIndent,
                            ((TerminalNode) lhs.getChild(1)).getSymbol().getCharPositionInLine()))
                            .append(" = ").append(possibleParenthesis(multi_process, this.value)).append("]");
                }
                else {
                    sb.append(possibleParenthesis(multi_process, this.value));
                }
            }
            else {
                sb.append("[").append(variable).append(" EXCEPT ![");
                int nowIndent = sb.length() + indent;
                String self;
                if (varScope instanceof ProcedureSymbol) {
                    ProcedureSymbol p = (ProcedureSymbol) varScope;
                    self = "self";
                }
                else {
                    Require.require(varScope instanceof ProcessSymbol);
                    ProcessSymbol p = (ProcessSymbol) varScope;
                    if (p.isEqual) {
                        self = indentedExpr(p.expr, nowIndent, true, hasChanged, p);
                    }
                    else {
                        self = "self";
                    }
                }
                sb.append(self).append("]");
                if (this.lhs != null && this.lhs.children.size() > 1) {
                    String sub = toIndentedString(toOriginalText(this.lhs, 1, this.lhs.getChildCount()),
                            sb.length(), ((TerminalNode)lhs.getChild(1)).getSymbol().getCharPositionInLine());
                    sb.append(sub);
                }
                sb.append(" = ");
                sb.append(indentedExpr(value, sb.length(), multi_process, hasChanged, scope));
                sb.append("]");
            }
            hasChanged.add(variable);
            return sb.toString();
        }


        private String possibleParenthesis(final boolean multi_process, ExprContext rhsValue) {
            // TODO: maybe for more
            return toOriginalText(rhsValue,
                    t -> {
                        if (scope != GLOBAL && scope.getLocal(t) != null) {
                            if (scope instanceof ProcessSymbol) {
                                if (((ProcessSymbol) scope).isEqual) {
                                    return t;
                                }
                                else {
                                    return t + "[self]";
                                }
                            }
                            if (multi_process) {
                                return t + "[self]";
                            }
                        }
                        return t;
                    });
        }

        public boolean equals(Predicate p) {
            return variable.equals(p.variable);
        }

        @Override
        public boolean equals(Object o) {
            if (this == o) return true;
            if (o == null || getClass() != o.getClass()) return false;
            return equals((Predicate) o);
        }

        @Override
        public int hashCode() {
            return Objects.hash(variable, value);
        }
    }

    private static class BranchedState extends State {
        protected final boolean ifTrue;
        protected final ExprContext condition;
        protected final ConjunctionList _ifSatisfied;
        protected ConjunctionList _else;

        /**
         * permit that the THEN statement and ELSE statement must be a conjunction list
         */
        BranchedState(String context, Scope scope, ExprContext condition, State _ifSatisfied, State _else) {
            super(context, scope);
            this.condition = condition;
            this.ifTrue = condition.getText().equals("TRUE");
            this._else = null;
            if (_ifSatisfied instanceof Action) {
                this._ifSatisfied = new ConjunctionList(context, scope);
                this._ifSatisfied.PCNext = ((Action) _ifSatisfied).getName();
            }
            else if (_ifSatisfied instanceof ConjunctionList) {
                this._ifSatisfied = (ConjunctionList) _ifSatisfied;
            }
            else {
                this._ifSatisfied = new ConjunctionList(context, scope, _ifSatisfied);
            }
            setFalse(_else);
        }

        @Override
        public Collection<String> getMayChanged() {
            List<String> l = new ArrayList<>(_ifSatisfied.getMayChanged());
            if (_else != null) {
                l.addAll(_else.getMayChanged());
            }
            return l;
        }

        @Override
        public String toString(final boolean multi_process,
                               boolean omitPC, int indent, Collection<String> unchanged, Collection<String> hasChanged) {

            StringBuilder sb = new StringBuilder();
            Collection<String> cthen = new ArrayList<>(unchanged);
            Collection<String> celse = new ArrayList<>(unchanged);
            sb.append("IF ");
            sb.append(indentedExpr(condition, sb.length(), multi_process, hasChanged, scope));
            sb.append(newLine("THEN " + _ifSatisfied.toString(multi_process,
                    omitPC, indent + "  THEN ".length(), cthen, new ArrayList<>(hasChanged)), indent + 2));
            if (_else != null) {
                sb.append(newLine("ELSE " + _else.toString(multi_process,
                        omitPC, indent + "  ELSE ".length(), celse, new ArrayList<>(hasChanged)), indent + 2));
            }
            else {
                sb.append(newLine("ELSE /\\ TRUE", indent + 2));
                if (unchanged.size() > 0) {
                    sb.append(newLine("/\\ " + unchanged(unchanged), indent + 7));
                }
            }
            unchanged.retainAll(cthen);
            unchanged.retainAll(celse);
            return sb.toString();
        }

        @Override
        public boolean backTrack(String PCNext) {
            if (PCNext.equals("Error")) {
                if (_ifSatisfied.hasJumpedToAnotherAction() || _else.hasJumpedToAnotherAction()) {
                    _ifSatisfied.backTrack("Error");
                    _else.backTrack("Error");
                    return true;
                }
            }
            else if (_ifSatisfied.hasJumpedToAnotherAction()) {
                if (_else == null) {
                    _else = new ConjunctionList(context, scope);
                    _else.PCNext = PCNext;
                    return true;
                }
//                if (!(_else.PCNext == null || _else.PCNext.equals(""))) {
//                    return true;
//                }
                return _else.backTrack(PCNext);
            }
            return false;
        }

        public void setFalse(State state) {
            if (this._else == null && state != null) {
                if (state instanceof Action) {
                    this._else = new ConjunctionList(context, scope);
                    this._else.PCNext = ((Action) state).getName();
                }
                else if (state instanceof ConjunctionList) {
                    this._else = (ConjunctionList) state;
                }
                else {
                    this._else = new ConjunctionList(context, scope, state);
                }
            }
        }

        final boolean hasJumpedToAnotherAction() {
            if (_ifSatisfied.hasJumpedToAnotherAction()) {
                return true;
            }
            if (_else != null) {
                return _else.hasJumpedToAnotherAction();
            }
            return false;
        }
    }

    /**
     * state with quantifiers (\\A or \\E)
     */
    private static class QuantifierState extends State {
        private final QuantifierKind kind;
        private final List<Pair<String, ExprContext>> quantifierBound;
        private final State predicates;

        QuantifierState(String context, Scope scope, QuantifierKind kind, State predicates) {
            super(context, scope);
            this.kind = kind;
            this.predicates = predicates;
            this.quantifierBound = new ArrayList<>();
        }

        public void addQuantifierBound(String variable, ExprContext expr) {
            quantifierBound.add(makePair(variable, expr));
        }

        @Override
        public Collection<String> getMayChanged() {
            return predicates.getMayChanged();
        }

        @Override
        public Collection<String> getMustChanged() {
            return predicates.getMustChanged();
        }

        @Override
        public String toString(final boolean multi_process, boolean omitPC,
                               int indent, Collection<String> unchanged, Collection<String> hasChanged) {
            StringBuffer sb = new StringBuffer();
            sb.append(kind.text).append(" ").append(quantifierBound.get(0).first).append(" \\in ");
            int lineIndent = indent + sb.length();
            sb.append(indentedExpr(quantifierBound.get(0).second, lineIndent, multi_process, hasChanged, scope));
            for (int i = 1; i < quantifierBound.size(); i++) {
                indent += 2;
                sb.append(newLine(kind.text + " ", indent)).append(quantifierBound.get(i).first).append(" \\in ");
                lineIndent += 2;
                sb.append(indentedExpr(quantifierBound.get(i).second, lineIndent, multi_process, hasChanged, scope));
            }
            sb.append(":");
            sb.append(newLine(predicates.toString(multi_process, omitPC, indent + 2, unchanged, hasChanged),
                    indent + 2));
            return sb.toString();
        }


        enum QuantifierKind {
            ANY(false, "\\A"),
            EXIST(true, "\\E");
            private final boolean stopOnPredicateMatches;
            private final String text;
            QuantifierKind(boolean stopOnPredicateMatches, String text) {
                this.stopOnPredicateMatches = stopOnPredicateMatches;
                this.text = text;
            }
        }
    }

    private static class LetInState extends State {
        private final Map<String, ExprContext> definitions;
        private final State _do;

        LetInState(String context, Scope scope, State _do) {
            super(context, scope);
            definitions = new LinkedHashMap<>();
            this._do = _do;
        }

        void define(String variable, ExprContext value) {
            definitions.put(variable, value);
        }

        @Override
        public String toString(final boolean multi_process, boolean omitPC, int indent, Collection<String> unchanged, Collection<String> hasChanged) {
            StringBuffer sb = new StringBuffer();
            sb.append("LET ");
            for (Map.Entry<String, ExprContext> e: definitions.entrySet()) {
                sb.append(e.getKey()).append(" == ");
                ExprContext expr = e.getValue();
                String origExpr = toOriginalText(expr);

            }
            addSpaces(sb, indent + 2);
            sb.append(_do.toString());
            return sb.toString();
        }
    }

    private static String newLine(String context) {
        return newLine(context, 0);
    }

    /**
     * line with indent
     */
    private static String newLine(String context, int indent) {
        StringBuffer sb = new StringBuffer();
        sb.append("\n");
        addSpaces(sb, indent);
        sb.append(context);
        return sb.toString();
    }

    private static String nSpaces(int n) {
        StringBuffer sb = new StringBuffer();
        addSpaces(sb, n);
        return sb.toString();
    }

    private static void addSpaces(StringBuffer sb, int n) {
        while (n-- > 0) {
            sb.append(" ");
        }
    }

    private static void addSpaces(StringBuilder sb, int n) {
        while (n-- > 0) {
            sb.append(" ");
        }
    }

    /**
     * left shift {@code indent} columns each line except the first line
     */
    private static String toIndentedString(String s, int indent, int firstLineIndent) {
        if (indent <= 0) return s;
        String[] lines = s.split("\n");
        for (int i = 1; i < lines.length; i++) {
            int prefixSpaces = lines[i].length() - lines[i].trim().length();
            Require.require(prefixSpaces >= 0);
            lines[i] = "\n" + nSpaces(prefixSpaces + indent - firstLineIndent) + lines[i].trim();
        }
        return Arrays.stream(lines).reduce("", String::concat);
    }

    private static String indentedExpr(ExprContext expr, int indent) {
        return toIndentedString(toOriginalText(expr), indent, getStartPos(expr));
    }

    private static String indentedExpr(ExprContext expr, int indent, boolean multi_process,
                                       Collection<String> hasChanged, Scope curScope) {
        return toIndentedString(
                toOriginalText(expr, s -> {
                    String result = getVariable(s);
                    if (hasChanged != null && hasChanged.contains(result)) {
                        result += "'";
                    }
                    if (curScope != GLOBAL) {
                        if (curScope.getLocal(s) != null) {
                            if (curScope instanceof ProcessSymbol) {
                                if (!((ProcessSymbol) curScope).isEqual) {
                                    result += "[self]";
                                }
                            }
                            else {
                                if (multi_process) {
                                    result += "[self]";
                                }
                            }
                        }
                    }
                    return result;
                }), indent, getStartPos(expr));
    }

    private static String toListedString(Collection<String> c) {
        if (c.size() == 0) return "";
        StringBuilder sb = new StringBuilder();
        for (String s: c) {
            sb.append(s).append(", ");
        }
        return sb.delete(sb.length() - 2, sb.length()).toString();
    }

    private static String unchanged(Collection<String> unchanged) {
        Require.require(unchanged.size() > 0);
        StringBuilder sb = new StringBuilder();
        String unchangedVars = toListedString(unchanged);
        if (unchanged.size() == 1) {
            if (unchangedVars.length() > 5) {
                sb.append("UNCHANGED ").append(unchangedVars);
            }
            else {
                sb.append(unchangedVars).append("' = ").append(unchangedVars);
            }
        }
        else {
            sb.append("UNCHANGED << ").append(unchangedVars).append(" >>");
        }
        return sb.toString();
    }

    private void addNewAction(Action action) {
        Require.require(!hasAction(action.getName()), "has action " + action.getName());
        actions.map(curScope, action);
    }

    private boolean hasAction(String action) {
        return actions.containsKey(action);
    }

    void writeTo(Appendable out) throws IOException {
        out.append("--------------------------------------BEGIN TRANSLATION--------------------------------------\n")
                .append(genVarDeclAndDefs()).append("\n");

        if (multi_process){
            out.append(genProcSet()).append("\n");
        }

        out.append(genInit()).append("\n")
                .append(genActionsAndNext()).append("\n")
                .append(genSpec()).append("\n");

        if (!mightOmitPC && !omitTerminating) {
            out.append(genTermination()).append("\n");
        }

        out.append("--------------------------------------END TRANSLATION--------------------------------------\n");
    }

    private String genVarDeclAndDefs() {
        StringBuilder sb = new StringBuilder();
        Collection<NormalVariableSymbol> variables = SymbolTable.getElementsOfType(SymbolType.VARIABLE);
        Collection<ProcessSymbol> processes = SymbolTable.getElementsOfType(SymbolType.PROCESS);
        List<String> globalVariables = new ArrayList<>(),
                localVariables = new ArrayList<>();
        variables.forEach(v -> globalVariables.add(v.name()));

        processes.forEach(p -> localVariables.addAll(getNamesOfLocalElements(p)));
        if (!mightOmitPC) {
            globalVariables.add("pc");
        }

        Collection<ProcedureSymbol> procedures = SymbolTable.getElementsOfType(SymbolType.PROCEDURE);

        if (!procedures.isEmpty()) {
            globalVariables.add("stack");
            procedures.forEach(p -> localVariables.addAll(getNamesOfLocalElements(p)));
        }

        if (hasDefaultInitialization) {
            sb.append("CONSTANT defaultInitValue").append("\n");
        }

        // TODO: definitions
        if (definitions.isEmpty()) {
            globalVariables.addAll(localVariables);
            sb.append(genVarDeclsFrom(globalVariables));
        }
        else {
            sb.append(genVarDeclsFrom(globalVariables)).append("\n");
            sb.append("(* define statement *)\n");
            for (String s: definitions) {
                sb.append(s).append("\n");
            }
            if (!localVariables.isEmpty()) {
                sb.append("\n");
                sb.append(genVarDeclsFrom(localVariables)).append('\n');
                globalVariables.addAll(localVariables);
            }
        }

        declaredVariables.addAll(globalVariables);

        if (declaredVariables.size() > 0) {
            sb.append("\n");
            sb.append("vars == << ");
            for (int i = 0; i < declaredVariables.size(); i++) {
                if (i > 0) sb.append(", ");
                sb.append(declaredVariables.get(i));
            }
            sb.append(" >>\n");
        }
        else {
            // TODO: ?
            throw new RuntimeException("No variables");
        }
        return sb.toString();
    }

    private String genVarDeclsFrom(List<String> variables) {
        StringBuilder sb = new StringBuilder();
        if (variables.size() > 0) {
            if (variables.size() > 1) {
                sb.append("VARIABLES ");
            }
            else {
                sb.append("VARIABLE ");
            }
            sb.append(variables.get(0));
            for (int i = 1; i < variables.size(); i++) {
                sb.append(", ").append(variables.get(i));
            }
            sb.append("\n");
        }
        return sb.toString();
    }

    private String genInit() {
        if (declaredVariables.contains("stack")) {
            init.initStack(multi_process);
        }
        if (!mightOmitPC) {
            if (multi_process) {
                init.initPC(true, actions.entrySet().stream()
                        .filter(e -> !(e.getKey() instanceof ProcedureSymbol))
                        .map(e -> e.getValue().get(0).getName())
                        .toArray(String[]::new));
            }
            else {
                init.initPC(false, actions.get(GLOBAL).get(0).getName());
            }
        }
        return init.toString();
    }

    private String genActionsAndNext() {
        StringBuffer sb = new StringBuffer();
        // TODO: mayUnchanged
        Set<String> mayUnchanged = new HashSet<>(declaredVariables);
        mayUnchanged.remove("pc");
        if (!mightOmitPC || multi_process) {
            for (Scope s: actions.keySet()) {
                StringBuilder forEachAction;
                List<Action> l = actions.get(s);
                String self;
                if (!multi_process || s == GLOBAL || (s instanceof ProcessSymbol && ((ProcessSymbol) s).isEqual)) {
                    self = "";
                }
                else {
                    self = "(self)";
                }
                for (Action a: l) {
                    forEachAction = new StringBuilder();
                    forEachAction.append(a.getName()).append(self).append(" == ");
                    forEachAction.append(a.toString(multi_process, mightOmitPC,
                            forEachAction.length(), new ArrayList<>(mayUnchanged))).append("\n");
                    sb.append(forEachAction);
                }
                if (s != GLOBAL) {
                    forEachAction = new StringBuilder();
                    if (s instanceof ProcessSymbol) {
                        sb.append(((ProcessSymbol) s).name()).append(self).append(" == ");
                    }
                    else {
                        sb.append(((ProcedureSymbol) s).name()).append(self).append(" == ");
                    }
                    for (int i = 0; i < l.size(); i++) {
                        if (i > 0) {
                            forEachAction.append(" \\/ ");
                        }
                        forEachAction.append(l.get(i).getName()).append(self);
                    }
                    sb.append(forEachAction).append("\n");
                    sb.append("\n");
                }
            }

            if (!noDoneDisjunction && !omitTerminating) {
                sb.append("(* Allow infinite stuttering to prevent deadlock on termination *)\n");
                sb.append("Terminating == ");
                if (multi_process) {
                    sb.append("(\\A self \\in ProcSet: pc[self] = \"Done\") /\\ UNCHANGED vars\n");
                }
               else {
                   sb.append("pc = \"Done\" /\\ UNCHANGED vars\n");
               }
               sb.append("\n");
            }

            StringBuffer forNext = new StringBuffer("Next == ");

            int indent = forNext.length();
            StringBuilder nextStep = new StringBuilder();
            for (Scope s: actions.keySet()) {
                // TODO: process with no self
                if (s == GLOBAL) {
                    for (Action action: actions.get(s)) {
                        if (nextStep.length() > 0) {
                            nextStep.append(" \\/ ");
                        }
                        nextStep.append(action.getName());
                    }
                }
                else if (s instanceof ProcessSymbol && ((ProcessSymbol) s).isEqual) {
                    if (nextStep.length() > 0) {
                        nextStep.append(" \\/ ");
                    }
                    nextStep.append(((ProcessSymbol) s).name());
                }
                else if (!multi_process) {
                    Require.require(s instanceof ProcedureSymbol);
                    ProcedureSymbol p = (ProcedureSymbol) s;
                    if (nextStep.length() > 0) {
                        nextStep.append(" \\/ ");
                    }
                    nextStep.append(p.name());
                }

            }
            forNext.append(nextStep);

            Collection<ProcedureSymbol> procedures = SymbolTable.getElementsOfType(SymbolType.PROCEDURE);
            Collection<ProcessSymbol> processes = SymbolTable.getElementsOfType(SymbolType.PROCESS);
            nextStep = new StringBuilder();
            for (ProcedureSymbol p: procedures) {
                if (nextStep.length() > 0) {
                    nextStep.append(" \\/ ");
                }
                nextStep.append(p.name()).append("(self)");
            }
            int procIndent = indent + 2;
            if (nextStep.length() > 0) {
                forNext.append(newLine("\\/ (\\E self \\in ProcSet: " + nextStep + ")", procIndent));
            }

            nextStep = new StringBuilder();
            procIndent = indent + "\\/ (\\E self \\in ".length();
            for (ProcessSymbol p: processes) {
                if (!p.isEqual) {
                    if (forNext.length() > indent) {
                        nextStep.append(newLine("\\/ ", indent + 2));
                    }
                    nextStep.append("(\\E self \\in ")
                            .append(toIndentedString(toOriginalText(p.expr), procIndent, getStartPos(p.expr)))
                            .append(": ").append(p.name()).append("(self))");
                    forNext.append(nextStep);
                }

            }

            if (!noDoneDisjunction && !omitTerminating) {
                forNext.append(newLine("\\/ Terminating", indent + 2));
            }
            sb.append(forNext);
        }
        else {
            sb.append("Next == ");
            int indent = "Next == ".length();
            Require.require(actions.size() == 1 && actions.get(GLOBAL).size() == 1);
            sb.append(actions.get(GLOBAL).get(0).toString(false, true, indent, mayUnchanged));
        }
        sb.append("\n");
        return sb.toString();
    }

    // TODO: Plus/Minus labels and fair option related
    private String genSpec() {
        String safetyFormula = "Init /\\ [][Next]_vars";
        StringBuilder sb = new StringBuilder("Spec == ");
        // TODO: if test optimization
        if (fairOption.equals("nof") || !multi_process && fairOption.equals("")) {
            sb.append(safetyFormula).append("\n");
        }
        else {
            String wfVarsNext = null;
            if (fairOption.equals("wfNext") || fairAlgorithm ||
                    !multi_process && (fairOption.equals("wf") || fairOption.equals("sf"))) {
                wfVarsNext = " /\\ WF_vars(Next)";
            }
            StringBuilder procFairFormulas = new StringBuilder();
            if (multi_process) {
                Collection<ProcessSymbol> processes = getElementsOfType(SymbolType.PROCESS);
                for (ProcessSymbol p: processes) {
                    String fairStr = null;
                    if ((p.fair && p.plus) || fairOption.equals("sf")) {
                        fairStr = "SF";
                    }
                    else if (p.fair || fairOption.equals("wf")) {
                        fairStr = "WF";
                    }
                    if (fairStr != null) {
                        String begin, end;
                        String self = "self";
                        if (p.isEqual) {
                            self = toOriginalText(p.expr);
                        }
                        if (!p.isEqual) {
                            begin = "\\A self \\in ";
                            end = " : ";
                        }
                        else {
                            // TODO
                            begin = "LET ";
                            end = "IN";
                        }

                        StringBuilder fVars = new StringBuilder(fairStr + "_vars(");
                        List<LabelSymbol> minusLabels = p.getLocalLabels().stream().filter(l -> l.minus)
                                .collect(Collectors.toList());
                        if (!minusLabels.isEmpty()) {
                            fVars.append("(pc[");
                            fVars.append(self);
                            if (minusLabels.size() == 1) {
                                fVars.append("] # \"").append(minusLabels.get(0).name()).append("\"");
                            }
                            else {
                                fVars.append("] \\notin {\"");
                                for (int i = 0; i < minusLabels.size(); i++) {
                                    fVars.append(minusLabels.get(i).name());
                                    if (i == minusLabels.size() - 1) {
                                        fVars.append("\"}");
                                    }
                                    else {
                                        fVars.append("\", \"");
                                    }
                                }
                            }

                            fVars.append(") /\\ ");
                        }

                        String name = p.name();
                        if (!p.isEqual) {
                            name = p.name() + "(self)";
                        }

                        fVars.append(name).append(")");

                        StringBuilder forSF;
                        List<LabelSymbol> plusLabels = p.getLocalLabels().stream().filter(l -> l.plus)
                                .collect(Collectors.toList());
                        if (fairStr.equals("WF") && plusLabels.size() > 0) {
                            forSF = new StringBuilder();
                            for (int i = 0; i < plusLabels.size(); i++) {
                                if (i != 0) {
                                    forSF.append(" /\\ ");
                                }
                                forSF.append("SF_vars(").append(plusLabels.get(i));
                                if (!p.isEqual) {
                                    forSF.append("(self)");
                                }
                                forSF.append(")");
                            }
                        }
                        // TODO: more for procFairFormulas

                        // TODO: for procedures called

                        // TODO: (only very simplified version)
                        //    just want to escape from LET expr
                        if (begin.length() > 0) {
                            if (procFairFormulas.length() > 0) {
                                procFairFormulas.append("\n");
                            }
                            procFairFormulas.append("/\\ ").append(begin);
                            procFairFormulas.append(toIndentedString(toOriginalText(p.expr), sb.length(), getStartPos(p.expr)));
                            procFairFormulas.append(end).append(fVars);
                        }

                    }
                }
            }
            if (wfVarsNext == null && procFairFormulas.length() == 0) {
                sb.append(safetyFormula).append("\n");
            }
            else {
                // TODO: more
                sb.append("/\\ ").append(safetyFormula).append("\n");
                int indent = "Spec == ".length();
                if (wfVarsNext != null) {
                    sb.append("        /\\ WF_vars(Next)");
                }
                sb.append(nSpaces(indent))
                        .append(toIndentedString(procFairFormulas.toString(), indent, 0));
                sb.append("\n");
            }
        }
        return sb.toString();
    }

    private String genTermination() {
        StringBuilder sb = new StringBuilder();
        sb.append("Termination == <>(");
        if (multi_process) {
            sb.append("\\A self \\in ProcSet: pc[self]");
        }
        else {
            sb.append("pc");
        }
        sb.append(" = \"Done\")\n");
        return sb.toString();
    }

    private String genProcSet() {
        if (!multi_process) return "";

        StringBuilder sb = new StringBuilder("ProcSet == ");
        Collection<ProcessSymbol> processes = SymbolTable.getElementsOfType(SymbolType.PROCESS);
        int i = 0;
        for (ProcessSymbol process: processes) {
            if (i > 0) sb.append(" \\cup ");
            if (process.isEqual) {
                sb.append("{");
            }
            else {
                sb.append("(");
            }
            sb.append(toIndentedString(toOriginalText(process.expr), sb.length(), getStartPos(process.expr)));
            if (process.isEqual) {
                sb.append("}");
            }
            else {
                sb.append(")");
            }
            i++;
        }
        sb.append("\n");
        return sb.toString();
    }


}
