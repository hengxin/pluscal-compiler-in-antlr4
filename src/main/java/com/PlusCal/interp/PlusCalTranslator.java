package com.PlusCal.interp;

import com.PlusCal.interp.symbol.*;
import com.PlusCal.interp.tlaplus.*;
import com.PlusCal.parser.PlusCalParser;
import com.PlusCal.parser.PlusCalParserBaseVisitor;
import org.antlr.v4.runtime.CommonToken;
import org.antlr.v4.runtime.Token;
import org.antlr.v4.runtime.tree.ParseTree;
import org.antlr.v4.runtime.tree.TerminalNode;
import org.antlr.v4.runtime.tree.TerminalNodeImpl;

import static com.PlusCal.parser.PlusCalParser.*;
import static com.PlusCal.interp.symbol.SymbolTable.*;
import static com.PlusCal.interp.RuleContextUtils.*;
import static com.PlusCal.interp.PlusCalParams.*;

import java.util.*;
import java.util.stream.Collectors;

public class PlusCalTranslator extends PlusCalParserBaseVisitor<Void> {
    /**
     * meaningless if multi-process
     */
    private boolean checkOnly;

    /**
     * only for auto adding labels
     */
    private int labelCount;

    private String currentProcedure;


    private PlusCalTranslator() {
//        _sInterp = new SymbolInterpreter(this);
        checkOnly = false;
        labelCount = 0;
        currentProcedure = "";
    }

    public static void translate(AlgorithmContext ctx) {
        new PlusCalTranslator().visitAlgorithm(ctx);
        TlaPlusSpec.translateFrom(ctx).print();
    }

    @Override
    public Void visitAlgorithm(AlgorithmContext ctx) {
        fairAlgorithm = ctx.Fair() != null;
        init();
        multi_process = !ctx.process().isEmpty();
        checkOnly = multi_process;
        if (ctx.globalVardecls() != null) {
            visitGlobalVardecls(ctx.globalVardecls());
        }

        if (ctx.definitions() != null) {
            visitDefs(ctx.definitions().defs());
        }

        ctx.procedure().forEach(p -> {
            define(new ProcedureSymbol(p.name().getText(), p));
        });

        ctx.process().forEach(p -> {
            define(new ProcessSymbol(p.name().getText(), p));
        });

        if (!ctx.procedure().isEmpty()) {
            Logger.logInfo("Spec should EXTENDS Sequences");
            for (ProcedureContext procedure: ctx.procedure()) {
                currentProcedure = procedure.name().getText();
                visitProcedure(procedure);
                if (cSyntax) {
                    addAndCheckLabel(procedure.compoundStmt().stmt());
                }
                if (pSyntax) {
                    addAndCheckLabel(procedure.body().stmt());
                }
            }
            currentProcedure = "";
        }
        if (multi_process) {
            for (ProcessContext proc: ctx.process()) {
                visitProcess(proc);
                if (cSyntax) {
                    addAndCheckLabel(proc.compoundStmt().stmt());
                }
                if (pSyntax) {
                    addAndCheckLabel(proc.body().stmt());
                }
            }
        }
        else {
            if (cSyntax) {
                visitCompoundStmt(ctx.compoundStmt());
                addAndCheckLabel(ctx.compoundStmt().stmt());
            }
            if (pSyntax) {
                visitBody(ctx.body());
                addAndCheckLabel(ctx.body().stmt());
            }
        }


        return null;
    }

    @Override
    public Void visitVardecl(VardeclContext ctx) {
        define(new NormalVariableSymbol(ctx.variable().getText(), getLine(ctx.variable())));
        return null;
    }

    @Override
    public Void visitProdVarDecls(ProdVarDeclsContext ctx) {
        for (ProdVarDeclContext decl: ctx.prodVarDecl()) {
            define(new NormalVariableSymbol(decl.variable().getText(), getLine(decl.variable())));
        }
        return null;
    }

    @Override
    public Void visitNonFixLhsDefinition(NonFixLhsDefinitionContext ctx) {
        OperatorSymbol ops = new OperatorSymbol(ctx.nonFixLhs().generalIdentifier().getText(),
                ctx.nonFixLhs().nonFixLhsParameter().size(), ctx.expr());
        define(ops);
        enterScope(ops);
        super.visitNonFixLhsDefinition(ctx);
        exitScope();
        return null;
    }

    @Override
    public Void visitInfixOpDefinition(InfixOpDefinitionContext ctx) {
        assert ctx.infixOp().getChild(0) instanceof TerminalNode;
        Token op = ((TerminalNode) ctx.infixOp().getChild(0)).getSymbol();
        return null;
    }

    @Override
    public Void visitNonFixLhsParameter(NonFixLhsParameterContext ctx) {
        if (ctx.getChild(0) instanceof GeneralIdentifierContext)
            defineParameter(new NormalVariableSymbol(ctx.getText(), getLine(ctx)));
        else super.visitNonFixLhsParameter(ctx);
        return null;
    }

    @Override
    public Void visitOperatorParameter(OperatorParameterContext ctx) {
        defineParameter(OperatorSymbol.formalParameter(ctx.generalIdentifier().getText(),
                getLine(ctx.generalIdentifier()), ctx.Subscript().size()));
        return null;
    }

    @Override
    public Void visitInfixOpParameter(InfixOpParameterContext ctx) {
        define(OperatorSymbol.formalInfixOp(
                (BuiltInOperator.InfixOperator) BuiltInOperator.getOperator(ctx.infixOp().start.getType(),
                        BuiltInOperator.OpType.infix),
                getLine(ctx)));
        return null;
    }

    @Override
    public Void visitProcedure(ProcedureContext ctx) {
        enterScope(resolve(ctx.name().getText(), SymbolType.PROCEDURE, ctx.prodVarDecl().size()));
        visitChildren(ctx);
        exitScope();
        return null;
    }

    @Override
    public Void visitProcess(ProcessContext ctx) {
        enterScope(resolve(ctx.name().getText(), SymbolType.PROCESS));
        visitChildren(ctx);
        exitScope();
        return null;
    }

    @Override
    public Void visitCompoundStmt(CompoundStmtContext ctx) {
        for (StmtContext stmt: ctx.stmt()) {
            visitStmt(stmt);
        }
        return null;
    }

    @Override
    public Void visitStmt(StmtContext ctx) {
        if (labeled(ctx)) {
            define(new LabelSymbol(ctx.label().getText(), ctx.label(), ctx.Plus() != null, ctx.Minus() != null));
        }
        visitChildren(ctx);
        return null;
    }

    @Override
    public Void visitAssign(AssignContext ctx) {
        List<LhsContext> lhsContexts = ctx.lhs();
        List<ExprContext> exprContexts = ctx.expr();
        assert lhsContexts.size() == exprContexts.size();

        NormalVariableSymbol variable;
        Set<String> values = new HashSet<>();
        for (LhsContext lhsContext : lhsContexts) {
            try {
                values.add(lhsContext.getText());
                variable = resolve(lhsContext.variable().getText(), SymbolType.VARIABLE);
            } catch (SemanticException e) {
                Logger.reportError(e.getMessage(), ctx);
                semanticError = true;
            }
        }
        if (values.size() < lhsContexts.size()) {
            Logger.reportError("cannot assign to the same variable within one step", ctx);
        }
        return null;
    }

    @Override
    public Void visitWith(PlusCalParser.WithContext ctx) {
        createScope();
        List<InWithVarDeclContext> varDecls = ctx.inWithVarDecl();
        for (InWithVarDeclContext context: varDecls) {
            visitInWithVarDecl(context);
        }
        exitScope();
        return null;
    }

    @Override
    public Void visitInWithVarDecl(InWithVarDeclContext ctx) {
        try {
            define(new NormalVariableSymbol(ctx.variable().getText(), getLine(ctx)));
        }
        catch (DefinitionException e) {
            Logger.reportError(e.getMessage(), getLine(ctx));
            semanticError = true;
        }
        return null;
    }

    @Override
    public Void visitAwait(PlusCalParser.AwaitContext ctx) {
        return super.visitAwait(ctx);
    }

    @Override
    public Void visitAssert(PlusCalParser.AssertContext ctx) {
        return super.visitAssert(ctx);
    }

    @Override
    public Void visitGoto(PlusCalParser.GotoContext ctx) {
        try {
            resolve(ctx.label().getText(), SymbolType.LABEL);
        } catch (SymbolResolveException e) {
            Logger.reportError(e.getMessage(), ctx);
            semanticError = true;
        }
        return null;
    }

    @Override
    public Void visitCallGoto(CallGotoContext ctx) {
        try {
            resolve(ctx.name().getText(), SymbolType.PROCEDURE, ctx.expr().size());
        } catch (SymbolResolveException e) {
            Logger.reportError(e.getMessage(), ctx);
            semanticError = true;
        }
        try {
            resolve(ctx.label().getText(), SymbolType.LABEL);
        }
        catch (SymbolResolveException e) {
            Logger.reportError(e.getMessage(), ctx);
            semanticError = true;
        }
        return null;
    }

    @Override
    public Void visitCall(CallContext ctx) {
        try {
            resolve(ctx.name().getText(), SymbolType.PROCEDURE, ctx.expr().size());
        } catch (SymbolResolveException e) {
            Logger.reportError(e.getMessage(), ctx);
            semanticError = true;
        }
        return null;
    }

    @Override
    public Void visitCallReturn(CallReturnContext ctx) {
        try {
            resolve(ctx.name().getText(), SymbolType.PROCEDURE, ctx.expr().size());
        } catch (SymbolResolveException e) {
            Logger.reportError(e.getMessage(), ctx);
            semanticError = true;
        }
        if (currentProcedure.equals("")) {
            throw new SemanticException("return statement not in a procedure");
        }
        return null;
    }

    @Override
    public Void visitReturn(ReturnContext ctx) {
        if (currentProcedure.equals("")) {
            throw new SemanticException("return statement not in a procedure");
        }
        return null;
    }

    @Override
    public Void visitWhile(WhileContext ctx) {
        return super.visitWhile(ctx);
    }

    @Override
    public Void visitPrint(PlusCalParser.PrintContext ctx) {
        return super.visitPrint(ctx);
    }

    @Override
    public Void visitMacroCall(PlusCalParser.MacroCallContext ctx) {
        throw new IllegalStateException("No macro calls");
    }

    @Override
    public Void visitExpr(PlusCalParser.ExprContext ctx) {
        return super.visitExpr(ctx);
    }
    
    @Override
    public Void visitOperatorCall(OperatorCallContext ctx) {
        String opName = ctx.generalIdentifier().Identifier().getText();
        try {
            resolve(opName, SymbolType.OPERATOR, ctx.argument().size());
//            System.out.println("find operator " + postfixExpr.getText());
        } catch (SemanticException e) {
            Logger.reportError(e.getMessage(), ctx);
            semanticError = true;
        }
        return super.visitOperatorCall(ctx);
    }

    @Override
    public Void visitTlaLet(TlaLetContext ctx) {
        createScope();
        visitChildren(ctx);
        exitScope();
        return null;
    }

    private void addAndCheckLabel(List<StmtContext> stmtSequence) {
        addLabelTo(stmtSequence.get(0));
        addLabelTo(stmtSequence, false, new HashSet<>(), new HashSet<>());
    }

    private boolean addLabelTo(StmtContext stmt, boolean inWith, Set<String> assignedBefore, Set<String> assignedAfter) {
        if (stmt == null) return false;
        if (stmt.compoundStmt() != null) {
            CompoundStmtContext cstmt = stmt.compoundStmt();
            if (labeled(stmt) && labeled(cstmt.stmt(0))){
                throw new LabelException("Duplicate labeling of statement");
            }

            return addLabelTo(cstmt.stmt(), inWith, assignedBefore, assignedAfter);
        }
        return addLabelTo(Collections.singletonList(stmt), inWith, assignedBefore, assignedAfter);
    }

    /**
     * Add label to the list of statements if possible
     * @param stmts statement sequence to be added labels
     * @param inWith whether the statement is in a with statement
     * @param before assigned variables starting from
     *               the nearest label before this statement list
     * @param after assigned variables starting from
     *              the last label in this statement list. Will be cleared at first
     * @return {@code true} iff the statements contains at least a
     *         call, return or goto statement or a label.
     */
    private boolean addLabelTo(List<StmtContext> stmts, boolean inWith, Set<String> before, Set<String> after) {
        int n = stmts.size();
        copyInto(before, after);
        boolean needLabel = false, labeled = false;
        for (int i = 0; i < n; i++) {
            StmtContext stmt = stmts.get(i);
            if (labeled(stmt)) {
                labeled = true;
                after.clear();
                if (inWith) {
                    throw new LabelException("Label in \"with\" statement");
                }

            }
            if (needLabel) {
                if (inWith) {
                    throw new LabelException("Statement follows \"call\" or \"return\" inside a \"with\" statement");
                }
                addLabelTo(stmt);
                needLabel = false;
                labeled = true;
                after.clear();
            }

            Set<String> newAssigned, nowAssigned;

            if (isStmtType(stmt, IfContext.class)) {
                IfContext ifctx = (IfContext) stmt.unLabeledStmt();
                nowAssigned = new HashSet<>();
                newAssigned = new HashSet<>();
                if (cSyntax) {
                    needLabel = addLabelTo(ifctx.stmt(0), inWith, after, nowAssigned);
                    needLabel = addLabelTo(ifctx.stmt(1), inWith, after, newAssigned) || needLabel;
                }
                else {
                    List<StmtContext> stmtSeq = new ArrayList<>();
                    for (int j = 0; j < ifctx.getChildCount(); j++) {
                        ParseTree p = ifctx.getChild(i);
                        if (p instanceof TerminalNode) {
                            TerminalNode t = (TerminalNode) p;
                            if (t.getSymbol().getType() == Else ||
                                    t.getSymbol().getType() == ElseIf ||
                                    t.getSymbol().getType() == End) {
                                needLabel = addLabelTo(stmtSeq, inWith, after, nowAssigned) || needLabel;
                                stmtSeq.clear();
                            }
                        }
                        else if (p instanceof StmtContext) {
                            stmtSeq.add((StmtContext) p);
                        }
                    }
                }
                copyInto(union(nowAssigned, newAssigned), after);
            }
            else if (isStmtType(stmt, EitherContext.class)) {
                EitherContext eitherctx = (EitherContext) stmt.unLabeledStmt();
                newAssigned = new HashSet<>();
                if (pSyntax) {
                    List<StmtContext> stmtSeq = new ArrayList<>();
                    for (int j = 0; j < eitherctx.getChildCount(); i++) {
                        ParseTree p = eitherctx.getChild(i);
                        if (p instanceof TerminalNode) {
                            TerminalNode t = (TerminalNode) p;
                            if (t.getSymbol().getType() == Or || t.getSymbol().getType() == End) {
                                Set<String> cluaseAssigned = new HashSet<>();
                                needLabel = addLabelTo(stmtSeq, inWith, after, cluaseAssigned) || needLabel;
                                newAssigned.addAll(cluaseAssigned);
                                stmtSeq.clear();
                            }
                        }
                        else if (p instanceof StmtContext) {
                            stmtSeq.add((StmtContext) p);
                        }
                    }
                }
                if(cSyntax) {
                    for (StmtContext clause: eitherctx.stmt()) {
                        Set<String> clauseAssigned = new HashSet<>();
                        needLabel = addLabelTo(clause, inWith, after, clauseAssigned) || needLabel;
                        newAssigned.addAll(clauseAssigned);
                    }
                }
                copyInto(newAssigned, after);
            }
            else if (isStmtType(stmt, WhileContext.class)) {
                if (inWith) {
                    throw new LabelException("\"while\" statement inside a \"with\" statement");
                }
                WhileContext whilectx = (WhileContext) stmt.unLabeledStmt();
                addLabelTo(stmt);
                labeled = true;
                after.clear();
                nowAssigned = new HashSet<>();
                if (cSyntax) {
                    addLabelTo(whilectx.stmt(0), false, after, nowAssigned);
                }
                if (pSyntax) {
                    addLabelTo(whilectx.stmt(), false, after, nowAssigned);
                }
                needLabel = false;
            }
            else if (isStmtType(stmt, WithContext.class)) {
                nowAssigned = new HashSet<>();
                if (inWith) {
                    copyInto(before, nowAssigned);
                }
                WithContext withctx = (WithContext) stmt.unLabeledStmt();
                newAssigned = new HashSet<>();
                if (cSyntax) {
                    needLabel = addLabelTo(withctx.stmt(0), true, nowAssigned, newAssigned);
                }
                if (pSyntax) {
                    needLabel = addLabelTo(withctx.stmt(), true, nowAssigned, newAssigned);
                }
                copyInto(newAssigned, after);
                if (!inWith && containsOneOf(before, after)) {
                    addLabelTo(stmt);
                    labeled = true;
                    after.clear();
                }
            }
            else if (isStmtType(stmt, AssignContext.class)) {
                AssignContext assignctx = (AssignContext) stmt.unLabeledStmt();
                nowAssigned = assignctx.lhs().stream()
                        .map(lhsContext -> lhsContext.variable().getText()).collect(Collectors.toSet());

                if (containsOneOf(after, nowAssigned)) {
                    if (inWith) {
                        throw new LabelException("Second assignment to variable " + toListedString(nowAssigned));
                    }
                    addLabelTo(stmt);
                    labeled = true;
                    copyInto(nowAssigned, after);
                }
                else {
                    after.addAll(nowAssigned);
                }
            }
            else {
                nowAssigned = new HashSet<>();
                if (isOneOfStmtType(stmt, CallContext.class, ReturnContext.class,
                        CallReturnContext.class, CallGotoContext.class)) {
                    boolean setProcedureVariables = false;
                    needLabel = true;
                    nowAssigned.add("stack");

                    if (isOneOfStmtType(stmt, ReturnContext.class, CallReturnContext.class)) {
                        setProcedureVariables = true;
                    }
                    else if (isStmtType(stmt, CallContext.class)) {
                        if (((CallContext) stmt.unLabeledStmt()).name().getText().equals(currentProcedure)) {
                            setProcedureVariables = true;
                        }
                    }
                    else {
                        if (((CallGotoContext)stmt.unLabeledStmt()).name().getText().equals(currentProcedure)) {
                            setProcedureVariables = true;
                        }
                    }
                    if (setProcedureVariables) {
                        Collection<ProcedureSymbol> procedures = SymbolTable.getElementsOfType(SymbolType.PROCEDURE);
                        for (ProcedureSymbol p: procedures) {
                            p.getLocalElementsOf(SymbolType.VARIABLE).stream()
                                    .map(NormalVariableSymbol::name).forEach(nowAssigned::add);

                        }
                    }
                }

                else if (isStmtType(stmt, GotoContext.class)) {
                    needLabel = true;
                }

                if (!containsOneOf(after, nowAssigned)) {
                    after.addAll(nowAssigned);
                }
                else {
                    if (inWith) {
                        // 考虑到只有call和return才可能会向nowAssigned中添加元素
                        throw new LabelException("\"call\" or \"return\" statement makes second assignment to a variable inside \"with\" statement");
                    }
                    addLabelTo(stmt);
                    labeled = true;
                    copyInto(nowAssigned, after);
                }
            }
        }

        return needLabel || labeled;
    }

    private void addLabelTo(StmtContext stmt) {
        if (!labeled(stmt)) {
            if (checkOnly) {
                throw new LabelException("Missing label at row " + getLine(stmt) + " colomn " + getStartPos(stmt));
            }
            LabelContext lbl = new LabelContext(stmt, -1);
            stmt.children.add(0, lbl);
            CommonToken vLbl = new CommonToken(stmt.start);
            vLbl.setType(Identifier);
            String lblText = "";
            do {
                lblText = "Lbl_" + labelCount;
                labelCount++;
                vLbl.setText(lblText);
            }
            while (resolve(lblText, SymbolType.LABEL) != null);
            lbl.addChild(new TerminalNodeImpl(vLbl));
            lbl.start = lbl.stop = vLbl;
            define(new LabelSymbol(lblText, lbl));
        }
    }

    private static <E> String toListedString(Collection<E> c) {
        StringBuilder s = new StringBuilder();
        for (E e: c) {
            s.append("\"").append(e).append("\", ");
        }
        s.delete(s.length() - 2, s.length());
        return s.toString();
    }

    private static <E> boolean containsOneOf(Collection<? extends E> c1,
                                             Collection<? extends E> c2) {
        for (E e: c1) {
            if (c2.contains(e)) return true;
        }
        return false;
    }

    private static <E> void copyInto(Collection<? extends E> from, Collection<E> to) {
        to.clear();
        to.addAll(from);
    }

    private static <E> Set<E> union(final Set<? extends E> left, final Set<? extends E> right) {
        Set<E> set = new HashSet<>(left);
        set.addAll(right);
        return set;
    }

}
