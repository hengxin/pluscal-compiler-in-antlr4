package com.PlusCal.interp.symbol;

import com.PlusCal.interp.SemanticException;

import java.util.*;
import java.util.stream.Collectors;

import static com.PlusCal.interp.symbol.SymbolType.*;
import static com.PlusCal.parser.PlusCalParser.*;
import static com.PlusCal.interp.symbol.BuiltInOperator.*;
import static com.PlusCal.interp.RuleContextUtils.*;

@SuppressWarnings({"rawtypes","unchecked"})
public final class SymbolTable implements Scope {

    private static final int PREDEFINED_LINENO = -1;

    private static ParameterizedSymbol toBeParameterizedSymbol = null;
    private static final Set<String> namespace = new HashSet<>();

    private static SymbolTable currentScope = null;
    static SymbolTable root;
    static final Map<String, ProcedureSymbol> procedures = new LinkedHashMap<>();
    static final Map<String, ProcessSymbol> processes = new LinkedHashMap<>();
    static final Map<String, LabelSymbol> labels = new LinkedHashMap<>();

    public static void init() {
        if (currentScope == null) {
            root = createScope();
        }
    }

    public static void enterScope(Scope scope) {
        scope.enter();
    }

    public static SymbolTable createScope() {
        currentScope = new SymbolTable(currentScope);
        return currentScope;
    }

    public static void exitScope() {
        currentScope = currentScope.getEnclosingScope();
    }

    public static SymbolTable getCurrentScope() {
        return currentScope;
    }

    /**
     * define a symbol in the symbol table
     * @param symbolType
     * @param name
     */
    public static <S extends Symbol> Symbol define(SymbolType<S> symbolType,
                                                    String name) {
        // TODO: if can
        if (ScopedSymbol.class.isAssignableFrom((symbolType.symbolClass))) {
            createScope();
        }
        return null;
    }

    /**
     * define a symbol in the symbol table
     * @param symbol defined symbol
     * @return {@code true} if the symbol is successfully defined
     */
    public static <T extends Symbol<T>> Symbol define(T symbol) throws SemanticException {
        String line = symbol.line() != -1 ? "Line " + symbol.line() + ": " : "",
                type = symbol.type().name;

        /*
         * functional operator definition does not allow for defining
         * operators with same identifiers and different number of parameters
         */
        Symbol oldSymbol = symbol.type().defineSymbolOfType(symbol);
        if (oldSymbol != null){
            throw new DefinitionException(symbol.name() + " has been defined as a/an " + oldSymbol.type());
        }

        if (symbol.type() == LABEL) {
            currentScope.labelsInThisScope.putIfAbsent(symbol.name(), (LabelSymbol) symbol);
        }

        if (symbol instanceof ParameterizedSymbol) {
            toBeParameterizedSymbol = (ParameterizedSymbol) symbol;
            if (toBeParameterizedSymbol.line() == PREDEFINED_LINENO) {
                endDefiningParameterizedSymbol();
            }
        }

        return symbol;
    }

    /**
     * resolve symbol of the target symbol symbolType(class)
     * @param symbol
     * @param symbolType
     * @param params used for checking numbers of operator
     *               or macro/procedure calling parameters
     * @param <T>
     * @throws SymbolResolveException
     * @return
     */
    public static <T extends Symbol> T resolve(String symbol,
                                               SymbolType<T> symbolType,
                                               int params, boolean requireNonNull)
            throws SymbolResolveException {
        if (symbolType == LABEL && (symbol.equals("Done") || symbol.equals("Error")))
            throw new SymbolResolveException("Done or Error cannot be used as actual labels");

        T target = symbolType.getSymbolOfType(symbol);
        String typeName = symbolType.name;
        if (requireNonNull && target == null)
            throw new SymbolResolveException("undefined " + typeName + " \"" + symbol + "\"");

        if (target instanceof ParameterizedSymbol) {
            ParameterizedSymbol operator = (ParameterizedSymbol) target;
            int argNum = operator.getParameterCount();
            if (argNum != params) {
                if (requireNonNull) {
                    throw new SymbolResolveException(symbolType.name + " " + symbol +
                            " should contain " + argNum + " parameters");
                }
                return null;
            }
        }

        return target;
    }

    public static <T extends AbstractSymbol> T resolve(String symbol, SymbolType<T> symbolType) {
        return resolve(symbol, symbolType, 0, true);
    }

    public static <T extends Symbol> T resolve(String symbol,
                                               SymbolType<T> symbolType,
                                               int params) {
        return resolve(symbol, symbolType, params, true);
    }

    public static <T extends Symbol> boolean ifDefined(String symbol, SymbolType<T> symbolType) {
        return resolve(symbol, symbolType, 0, false) != null;
    }

    public static void defineParameter(VariableSymbol paramSymbol) {
        if (toBeParameterizedSymbol != null) {
            toBeParameterizedSymbol.addParameter(paramSymbol);
        }
        else {
            throw new DefinitionException("No more parameter allowed");
        }
    }

    private static void endDefiningParameterizedSymbol() {
        toBeParameterizedSymbol = null;
    }

    private final SymbolTable enclosingScope;
    final Map<String, VariableSymbol> variables;
    final Map<String, LabelSymbol> labelsInThisScope;

    private SymbolTable(SymbolTable enclosingScope) {
        this.enclosingScope = enclosingScope;
        this.variables = new LinkedHashMap<>();
        this.labelsInThisScope = new LinkedHashMap<>();
    }

    @Override
    public VariableSymbol defineVariable(VariableSymbol symbol) {
        return variables.putIfAbsent(symbol.name(), symbol);
    }

    @Override
    public VariableSymbol get(String symbolName) {
        VariableSymbol s = variables.get(symbolName);
        if (s != null) return s;
        if (getEnclosingScope() != null)
            return getEnclosingScope().get(symbolName);
        return null;
    }

    @Override
    public Collection<VariableSymbol> getLocalElements() {
        return variables.values();
    }

    @Override
    public <S extends VariableSymbol> Collection<S> getLocalElementsOf(SymbolType<S> type) {
        return (Collection<S>) variables.values().stream().filter(type.symbolClass::isInstance)
                .collect(Collectors.toList());
    }

    @Override
    public List<LabelSymbol> getLocalLabels() {
        return new ArrayList<>(labelsInThisScope.values());
    }

    @Override
    public void enter() {
        if (getEnclosingScope() == currentScope) {
            currentScope = this;
        }
        else if (this != currentScope)
            throw new IllegalStateException("cannot enter a scope that is not linked with current scope");
    }

    public SymbolTable getEnclosingScope() {
        return enclosingScope;
    }

    /*
     * Concrete definitions of symbol classes
     */
    public static class NormalVariableSymbol extends AbstractSymbol<NormalVariableSymbol>
            implements VariableSymbol<NormalVariableSymbol> {
        private static NormalVariableSymbol SUBSCRIPT_FORMAL_PARAM = new NormalVariableSymbol("_");
        public final Boolean isEqual;
        public final ExprContext initialValue;

        NormalVariableSymbol(String name) {
            this(name, PREDEFINED_LINENO, false, null);
        }

        public NormalVariableSymbol(String name, int line) {
            super(name, line, VARIABLE);
            this.isEqual = null;
            this.initialValue = null;
        }

        public NormalVariableSymbol(String name, int line, boolean isEqual, ExprContext initialValue) {
            super(name, line, VARIABLE);
            this.isEqual = isEqual;
            this.initialValue = initialValue;
        }

        @Override
        public String name() {
            return name;
        }

        @Override
        public String toString() {
            return name;
        }
    }

    /**
     * AbstractSymbol with parameters
     */
    private interface ParameterizedSymbol<S extends Symbol<S>, ParameterType extends VariableSymbol>
            extends Symbol<S> {

        int getParameterCount();

        ParameterType getParameter(int i);

        <T extends ParameterType> void addParameter(T param);
    }

    /**
     * any symbolType of symbol which has its own scope should
     * extend this class
     */
    private static abstract class ScopedSymbol<Definition,
            S extends Symbol<S>> extends AbstractSymbol<S>
            implements Scope {
        SymbolTable scope;
        public final Definition defContext;

        protected ScopedSymbol(String name, int line, SymbolType symbolType) {
            this(name, line, symbolType, null);
        }

        protected ScopedSymbol(String name, int line, SymbolType symbolType, Definition ctx) {
            super(name, line, symbolType);
            defContext = ctx;
            scope = new SymbolTable(currentScope);
        }

        @Override
        public VariableSymbol get(String s) {
            return scope.get(s);
        }

        public SymbolTable getScope() {
            return scope;
        }

        @Override
        public VariableSymbol defineVariable(VariableSymbol symbol) {
            return scope.defineVariable(symbol);
        }

        @Override
        public Collection<VariableSymbol> getLocalElements() {
            return scope.getLocalElements();
        }

        @Override
        public <V extends VariableSymbol> Collection<V> getLocalElementsOf(SymbolType<V> type) {
            return scope.getLocalElementsOf(type);
        }

        @Override
        public void enter() {
            scope.enter();
        }

        @Override
        public List<LabelSymbol> getLocalLabels() {
            return scope.getLocalLabels();
        }
    }

    public static class LabelSymbol extends AbstractSymbol<LabelSymbol> {
        public final boolean plus;
        public final boolean minus;

        LabelSymbol(String name) {
            super(name, PREDEFINED_LINENO, LABEL);
            this.plus = false;
            this.minus = false;
        }

        public LabelSymbol(String name, LabelContext ctx) {
            this(name, ctx, false, false);
        }

        public LabelSymbol(String name, LabelContext ctx, boolean plus, boolean minus) {
            super(name, getLine(ctx), LABEL);
            this.plus = plus;
            this.minus = minus;
        }


    }

    public static class ProcedureSymbol extends ScopedSymbol<ProcedureContext, ProcedureSymbol>
            implements ParameterizedSymbol<ProcedureSymbol, NormalVariableSymbol>{
        protected List<NormalVariableSymbol> params;
        protected int paramNum;

        public ProcedureSymbol(String name, ProcedureContext ctx) {
            this(name, getLine(ctx), ctx);
        }

        ProcedureSymbol(String name, int line, ProcedureContext ctx) {
            // TODO
            super(name, line, PROCEDURE, ctx);
            enterScope(scope);
            NormalVariableSymbol symbol;
            params = new ArrayList<>(ctx.prodVarDecl().size());
            for (ProdVarDeclContext decl: ctx.prodVarDecl()) {
                if (decl.expr() == null) {
                    symbol = new NormalVariableSymbol(decl.variable().getText(), getLine(decl));
                }
                else {
                    symbol = new NormalVariableSymbol(decl.variable().getText(), getLine(decl), true, decl.expr());
                }
                params.add(symbol);
                define(symbol);
            }
            exitScope();
            endDefiningParameterizedSymbol();
        }

        @Override
        public String toString() {
            return name;
        }

        @Override
        public int getParameterCount() {
            return params.size();
        }

        @Override
        public NormalVariableSymbol getParameter(int i) {
            return params.get(i);
        }

        @Override
        public void addParameter(NormalVariableSymbol param) {
            // TODO
            params.add(param);
            if (params.size() == paramNum) endDefiningParameterizedSymbol();
        }

    }

    public static class ProcessSymbol extends ScopedSymbol<ProcessContext, ProcessSymbol> {
        public final boolean isEqual;
        public final boolean fair;
        public final boolean plus;
        public final ExprContext expr;

        public ProcessSymbol(String name, ProcessContext ctx) {
            this(name, getLine(ctx), Objects.requireNonNull(ctx));
        }

        ProcessSymbol(String name, int line, ProcessContext ctx) {
            super(name, line, PROCESS, ctx);
            this.fair = ctx.Fair() != null;
            this.plus = ctx.Plus() != null;
            this.isEqual = ctx.Equal() != null;
            this.expr = ctx.expr();
        }

        @Override
        public String toString() {
            return name;
        }

    }

    /**
     * Symbol of user-defined operators
     */
    public static class OperatorSymbol extends ScopedSymbol<ExprContext, OperatorSymbol>
            implements ParameterizedSymbol<OperatorSymbol, VariableSymbol>,
            VariableSymbol<OperatorSymbol> {
        protected List<VariableSymbol> params;
        protected final int paramNum;
        protected boolean formal = false;

        OperatorSymbol(String name, String...params) {
            this(name, PREDEFINED_LINENO, null, params);
        }

        protected OperatorSymbol(String name, int paramNum) {
            this(name, PREDEFINED_LINENO, paramNum);
        }

        protected OperatorSymbol(String name, int line, int paramNum) {
            super(name, line, OPERATOR, null);
            this.params = new ArrayList<>(paramNum);
            this.paramNum = paramNum;
        }

        public OperatorSymbol(String name, int paramNum, ExprContext ctx) {
            super(name, getLine(ctx), OPERATOR, null);
            this.params = new ArrayList<>(paramNum);
            this.paramNum = paramNum;

        }

        /**
         * Used only for variable parameters
         * @param name
         * @param line
         * @param ctx
         * @param params
         */
        protected OperatorSymbol(String name, int line, ExprContext ctx, String... params) {
            super(name, line, OPERATOR, null);
            enterScope(scope);
            this.paramNum = params.length;
            this.params = new ArrayList<>(params.length);
            for (int i = 0; i < params.length; i++) {
                this.params.add(new NormalVariableSymbol(params[i], line));
                define(this.params.get(i));
            }
            exitScope();

        }

        @Override
        public String toString() {
            StringBuilder sb = new StringBuilder();
            sb.append(name);
            if (params.size() > 0) {
                sb.append("(");
                for (VariableSymbol param: params) {
                    sb.append(param.toString()).append(",");
                }
                sb.deleteCharAt(sb.length() - 1);
                sb.append(")");
            }
            return sb.toString();
        }

        @Override
        public int getParameterCount() {
            return paramNum;
        }

        @Override
        public VariableSymbol getParameter(int i) {
            return params.get(i);
        }

        @Override
        public <T extends VariableSymbol> void addParameter(T param) {
            params.add(param);
            if (param != NormalVariableSymbol.SUBSCRIPT_FORMAL_PARAM) define(param);
            if (params.size() == paramNum) endDefiningParameterizedSymbol();
        }

        @Override
        public String name() {
            return name;
        }

        public static OperatorSymbol formalParameter(String name, int line, int paramNum) {
            OperatorSymbol op = new OperatorSymbol(name, line, paramNum);
            return formalOf(op);
        }

        private static OperatorSymbol formalOf(OperatorSymbol op) {
            op.formal = true;
            for (int i = 0; i < op.paramNum; i++) {
                op.addParameter(NormalVariableSymbol.SUBSCRIPT_FORMAL_PARAM);
            }
            return op;
        }

        public static OperatorSymbol formalPrefixOp(PrefixOperator operator, int line) {
            return formalOf(makePrefixOpSymbol(operator, line));
        }

        public static OperatorSymbol formalInfixOp(InfixOperator operator, int line) {
            return formalOf(makeInfixOpSymbol(operator, line));
        }

        public static OperatorSymbol formalPostfixOp(PostfixOperator operator, int line) {
            return formalOf(makePostfixOpSymbol(operator, line));
        }
    }

    static UserDefinedBuiltinOperatorSymbol makePrefixOpSymbol(PrefixOperator operator) {
        return makePrefixOpSymbol(operator, "x");
    }

    static UserDefinedBuiltinOperatorSymbol makePrefixOpSymbol(PrefixOperator operator, String operand) {
        return new UserDefinedBuiltinOperatorSymbol<PrefixOperator>(operator, operand);
    }

    public static UserDefinedBuiltinOperatorSymbol makePrefixOpSymbol(PrefixOperator operator, int line) {
        return new UserDefinedBuiltinOperatorSymbol<PrefixOperator>(operator, line, 1);
    }

    static UserDefinedBuiltinOperatorSymbol makeInfixOpSymbol(InfixOperator operator) {
        return makeInfixOpSymbol(operator, "a", "b");
    }

    static UserDefinedBuiltinOperatorSymbol makeInfixOpSymbol(InfixOperator operator, String left, String right) {
        return new UserDefinedBuiltinOperatorSymbol<InfixOperator>(operator, left, right);
    }

    public static UserDefinedBuiltinOperatorSymbol makeInfixOpSymbol(InfixOperator operator, int line) {
        return new UserDefinedBuiltinOperatorSymbol<InfixOperator>(operator, line, 2);
    }

    static UserDefinedBuiltinOperatorSymbol makePostfixOpSymbol(PostfixOperator operator) {
        return makePostfixOpSymbol(operator, "x");
    }

    static UserDefinedBuiltinOperatorSymbol makePostfixOpSymbol(PostfixOperator operator, String operand) {
        return new UserDefinedBuiltinOperatorSymbol<PostfixOperator>(operator, operand);
    }

    public static UserDefinedBuiltinOperatorSymbol makePostfixOpSymbol(PostfixOperator operator, int line) {
        return new UserDefinedBuiltinOperatorSymbol<PostfixOperator>(operator, line, 1);
    }

    /**
     * symbol of user-definable builtin operators
     */
    private static class UserDefinedBuiltinOperatorSymbol
            <Op extends BuiltInOperator> extends OperatorSymbol {
        public final Op operator;

        protected UserDefinedBuiltinOperatorSymbol(Op op, int paramNum) {
            this(op, PREDEFINED_LINENO, paramNum);
        }

        protected UserDefinedBuiltinOperatorSymbol(Op op, int line, int paramNum) {
            super(op.toString(), line, paramNum);
            this.operator = op;
        }

        UserDefinedBuiltinOperatorSymbol(Op op, String...params) {
            this(op, PREDEFINED_LINENO, null, params);
        }

        protected UserDefinedBuiltinOperatorSymbol(Op op, ExprContext ctx, String...params) {
            this(op, getLine(ctx), ctx, params);
        }

        protected UserDefinedBuiltinOperatorSymbol(Op op, int line, ExprContext ctx, String...params) {
            super(op.toString(), line, ctx, params);
            this.operator = op;
        }

        @Override
        public String toString() {
            return name;
        }

        @Override
        public String name() {
            return name;
        }
    }

    public static <S extends Symbol> Collection<S> getElementsOfType(SymbolType<S> type) {
        assert Objects.requireNonNull(type) != OPERATOR;
        return type.getCurrentElements();
    }

    public static Collection<String> getNamesOfLocalElements(Scope scope) {
        return scope.getLocalElements().stream().map(Symbol::name).collect(Collectors.toList());
    }

    public static void printSymbols() {
        StringBuilder sb = new StringBuilder();
        sb.append("variables: ").append("\n");
        for (VariableSymbol s: ((SymbolTable)currentScope).variables.values()) {
            sb.append("    ").append(s).append("\n");
        }
        sb.append("\n").append("processes: ").append("\n");
        for (String s: processes.keySet()) {
            sb.append("    ").append(s).append("\n");
        }
        sb.append("\n").append("procedures: ").append("\n");
        for (String s: procedures.keySet()) {
            sb.append("    ").append(s).append("\n");
        }
        sb.append("\n").append("labels: ").append("\n");
        for (String s: labels.keySet()) {
            sb.append("    ").append(s).append("\n");
        }
        System.out.println(sb);
    }
}