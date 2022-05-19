package com.PlusCal.interp.pretreatment;

import com.PlusCal.interp.PlusCalLogger;
import com.PlusCal.interp.symbol.DefinitionException;
import com.PlusCal.interp.symbol.SymbolResolveException;
import com.PlusCal.parser.PlusCalParser;
import org.antlr.v4.runtime.CommonToken;
import org.antlr.v4.runtime.ParserRuleContext;
import org.antlr.v4.runtime.TokenStreamRewriter;
import org.antlr.v4.runtime.tree.ParseTree;
import org.antlr.v4.runtime.tree.TerminalNode;

import java.util.*;
import java.util.stream.Collectors;

import static com.PlusCal.parser.PlusCalParser.*;
import static com.PlusCal.interp.RuleContextUtils.*;

/**
 * define and expand macros
 */
final class Macros {

    private static final Map<String, MacroSymbol> macros = new HashMap<>();

    private static String[] toStringList(List<? extends ParserRuleContext> contexts) {
        return contexts.stream().map(ParserRuleContext::getText).toArray(String[]::new);
    }

    public static boolean define(String name, PlusCalParser.MacroContext ctx)
            throws SymbolResolveException {
        int line = getLine(ctx);
        MacroSymbol symbol = new MacroSymbol(name, line, ctx);
        macros.put(symbol.name, symbol);
        return true;
    }

    private static MacroSymbol resolve(String symbol, int paramNum){
        MacroSymbol target = macros.get(symbol);

        if (target == null)
            throw new SymbolResolveException("undefined macro \"" + symbol + "\"");

        int argNum = target.getParameterCount();
        if (argNum != paramNum)
            throw new SymbolResolveException("macro " + symbol +
                    " should contain " + argNum + " parameters");

        else return target;
    }

    public static void expandMacro(TokenStreamRewriter rewriter, MacroCallContext ctx, String...parameters) {
        assert parameters.length == ctx.expr().size();
        MacroSymbol macro = resolve(ctx.name().getText(), ctx.expr().size());
        rewriter.replace(ctx.getStart(), ctx.getStop(),
                macro.expandWithParams(ctx.getStart().getCharPositionInLine(), parameters));
    }

    /**
     * symbol of macros. Record some basic information of the macro,
     * and a pointer to a real macro which works for expanding
     */
    private static class MacroSymbol {
        String[] params;
        final String name;
        final int line;
        Macro instance;
        boolean hasError;
        final MacroContext ctx;

        MacroSymbol(String name, int line, MacroContext ctx) {
            this.name = name;
            this.line = line;
            this.ctx = ctx;
            hasError = !(cSyntax? validDefinition(ctx.compoundStmt().stmt()) : validDefinition(ctx.body().stmt()));
            if (hasError) {
                throw new DefinitionException("Error macro definition");
            }
            else {
                String[] params = toStringList(ctx.variable());
                this.instance = new Macro(ctx.name().getText(), ctx.compoundStmt(), params);
                this.params = new String[params.length];
                if (params.length != 0) {
                    int i = 0;
                    for (String param: params) {
                        this.params[i++] = param;
                    }
                }
            }

        }


        @Override
        public String toString() {
            StringBuilder call = new StringBuilder();
            call.append(name).append("(");
            for (String arg: params) {
                call.append(arg).append(",");
            }
            if (params.length > 0) call.deleteCharAt(call.length() - 1);
            call.append(")");
            return call.toString();
        }

        int getParameterCount() {
            return params.length;
        }

        String expandWithParams(int basePos, String...parameters) {
            return instance.expand(basePos, parameters);
        }

        String expandWithParams(int basePos, List<ExprContext> contexts) {
            return instance.expand(basePos, toStringList(contexts));
        }

        private static boolean validDefinition(List<StmtContext> definition) {
            // TODO: a macro definition may contain no labels,
            //       no while, call, return or goto statement.
            if (definition == null) return true;
            boolean b = true;
            for (StmtContext stmtContext: definition) {
                b = b && checkStmt(stmtContext);
            }
            return b;
        }

        private static boolean checkStmt(StmtContext stmtDef) {
            boolean b = true;
            if (labeled(stmtDef)) {
                PlusCalLogger.reportError("a macro definition may contain no labels",
                        getLine(stmtDef));
                b = false;
            }
            if (stmtDef.unLabeledStmt() != null) {
                // 暂时移去while
                if (isOneOfStmtType(stmtDef,
                        ReturnContext.class, CallContext.class, GotoContext.class)) {
                    PlusCalLogger.reportError("a macro definition may contain no while, call, return or goto statement",
                            getLine(stmtDef.unLabeledStmt()));
                    return false;
                }
                return b;
            }
            else {
                return validDefinition(stmtDef.compoundStmt().stmt()) && b;
            }
        }

    }

    /**
     * used for expanding
     */
    private static class Macro {
        static final String PARAM_TAG = "\\param:=";
        final String name;
        private final String[] params;

        List<CommonToken> definition;
        String text;

        private int startPositionInLine;

        Macro(String name,
              CompoundStmtContext definition,
              String...params) {
            this.name = name;
            this.params = params;
            this.definition = new ArrayList<>(20);
            toTokenDefinition(definition);
        }

        private void toTokenDefinition(ParseTree definition) {
            List<MacroCallContext> macroCallStarts = new ArrayList<>();
            ParseTree tree, child;
            Stack<ParseTree> trees = new Stack<>();
            trees.add(definition);
            while (!trees.isEmpty()) {
                tree = trees.pop();
                if (tree instanceof TerminalNode) {
                    this.definition.add((CommonToken) ((TerminalNode) tree).getSymbol());
                }
                else {
                    for (int i = tree.getChildCount() - 1; i >= 0; i--) {
                        child = tree.getChild(i);
                        trees.push(child);
                        if (child instanceof MacroCallContext) {
                            macroCallStarts.add(((MacroCallContext) child));
                        }
                    }
                }
            }

            expandDefinition(macroCallStarts);
        }

        private void expandDefinition(List<MacroCallContext> macroCallContexts) {
            List<Integer> macroCallStarts = macroCallContexts.stream()
                    .map(macroCallContext -> macroCallContext.getStart().getTokenIndex()).collect(Collectors.toList()),
                    macroCallStops = macroCallContexts.stream()
                            .map(macroCallContext -> macroCallContext.getStop().getTokenIndex()).collect(Collectors.toList());
            StringBuilder sb = new StringBuilder();
            CommonToken token = definition.get(1);
            int basePos = token.getCharPositionInLine(), lastPos = basePos,
                    line = token.getLine(), startPos = token.getCharPositionInLine(), n = definition.size();
            this.startPositionInLine = basePos;
            int index = -1;
            for (int k = 1, end = -1; k < n - 1; k++) {
                token = definition.get(k);
                if (token.getLine() - line > 0) {
                    sb.append("\n".repeat(token.getLine() - line)).append(" ".repeat(basePos + token.getCharPositionInLine() - startPos));
                }
                else {
                    if (token.getCharPositionInLine() - lastPos > 0) {
                        sb.append(" ".repeat(token.getCharPositionInLine() - lastPos));
                    }
                }
                if (token.getType() == Identifier && ((index = macroCallStarts.indexOf(token.getTokenIndex())) != -1)){
                    int start = token.getCharPositionInLine();
                    MacroSymbol macroSymbol = Objects.requireNonNull(macros.get(token.getText()));
                    end = macroCallStops.get(index);
                    do {
                        k++;
                        token = definition.get(k);
                        String after = tagIfParameter(token.getText());
                        token.setText(after);
                    }
                    while (k < definition.size() && definition.get(k).getTokenIndex() != end);
                    sb.append(macroSymbol.expandWithParams(start, macroCallContexts.get(index).expr()));
                    if (k < definition.size())
                        token = definition.get(k);
                }
                else {
                    if (token.getType() == Identifier) {
                        String tag = tagIfParameter(token.getText());
                        token.setText(tag);
                        sb.append(tag);
                    }
                    else sb.append(token.getText());
                }
                String text = token.getText();
                if (text.contains(PARAM_TAG)) {
                    text = params[java.lang.Integer.parseInt(text.substring(8))];
                }
                lastPos = token.getCharPositionInLine() + text.length();
                line = token.getLine();
            }
            if (sb.charAt(sb.length() - 1) == ';') sb.deleteCharAt(sb.length() - 1);

            this.text = sb.toString();
        }

        private String tagIfParameter(String text) {
            for (int i = 0; i < params.length; i++) {
                if (params[i].equals(text)) {
                    return PARAM_TAG + i;
                }
            }
            return text;
        }


        public String expand(int basePos, String...values) {
            String[] lines = text.split("\n");
            StringBuilder sb = new StringBuilder();
            String line;
            for (int i = 0, j = 0, k = 0; i < lines.length; i++, j = 0) {
                line = lines[i];
                while (line.charAt(j) == ' ') {
                    j++;
                }
                line = line.substring(j);
                if (i != 0) sb.append(" ".repeat(basePos + j - startPositionInLine));
                j = -1; k = 0;
                while ((j = line.indexOf(PARAM_TAG, j + 1))!= -1) {
                    k = j + 8;
                    while (line.charAt(k) >= '0' && line.charAt(k) <= '9') k++;
                    line = line.substring(0, j) + values[java.lang.Integer.parseInt(line.substring(j + 8, k))] + line.substring(k);
                }
                sb.append(line);
                if (i != lines.length - 1) sb.append("\n");
            }
            return sb.toString();
        }

    }


}
