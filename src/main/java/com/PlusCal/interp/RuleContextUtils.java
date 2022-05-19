package com.PlusCal.interp;

import com.PlusCal.parser.PlusCalParser;
import org.antlr.v4.runtime.ParserRuleContext;
import org.antlr.v4.runtime.Token;
import org.antlr.v4.runtime.tree.ParseTree;
import org.antlr.v4.runtime.tree.TerminalNode;

import static com.PlusCal.parser.PlusCalParser.*;

import java.util.*;
import java.util.function.*;

public final class RuleContextUtils {

    /**
     * The text of the parseTree Node
     * @param tNode
     * @return
     */
    public static String toOriginalText(ParserRuleContext tNode) {
        return toOriginalText(tNode, 0, tNode.getChildCount(), Function.identity());
    }

    public static String toOriginalText(ParserRuleContext tNode, Function<String, String> forEachTokenString) {
        return toOriginalText(tNode, 0, tNode.getChildCount(), forEachTokenString);
    }

    public static String toOriginalText(ParserRuleContext tNode, int from, int to) {
        return toOriginalText(tNode, from, to, Function.identity());
    }

    public static String toOriginalText(ParserRuleContext tNode, int from, int to, Function<String, String> forEachTokenString) {
        List<Token> def = toTokenDefinition(tNode, from, to);
        StringBuilder sb = new StringBuilder();
        int curLine = def.get(0).getLine(), curPos = def.get(0).getCharPositionInLine();
        int firstLineIndent = curPos;
        for (Token t : def) {
            if (curLine < t.getLine())  {
                if (firstLineIndent > t.getCharPositionInLine()) {
                    curLine = t.getLine();
                    curPos = t.getCharPositionInLine() - 1;
                }
                else {
                    curPos = 0;
                }
            }
            sb.append("\n".repeat(t.getLine() - curLine))
                    .append(" ".repeat(t.getCharPositionInLine() - curPos))
                    .append(forEachTokenString.apply(t.getText()));
            curPos = t.getCharPositionInLine() + t.getText().length();
            curLine = t.getLine();
        }
        return sb.toString();
    }

    public static List<Token> toTokenDefinition(ParseTree tNode, int from, int to) {
        if (from >= to) return Collections.emptyList();
        List<Token> tokens = new ArrayList<>();
        ParseTree tree;
        Stack<ParseTree> trees = new Stack<>();
        for (int i = to - 1; i >= from; i--) {
            trees.push(tNode.getChild(i));
        }
        while (!trees.isEmpty()) {
            tree = trees.pop();
            if (tree instanceof TerminalNode) {
                tokens.add(((TerminalNode) tree).getSymbol());
            }
            else {
                for (int i = tree.getChildCount() - 1; i >= 0; i--) {
                    trees.push(tree.getChild(i));
                }
            }
        }
        return tokens;
    }

    /**
     * The start line of the context
     * @param ctx
     * @return
     */
    public static int getLine(ParserRuleContext ctx) {
        return ctx.start.getLine();
    }

    /**
     * The start position in line
     * @param ctx
     * @return
     */
    public static int getStartPos(ParserRuleContext ctx) {
        return ctx.start.getCharPositionInLine();
    }

    /**
     * return true if the statement context is a type of the class list
     * @param ctx
     * @param clazz
     * @return
     */
    @SafeVarargs
    public static boolean isOneOfStmtType(StmtContext ctx,
                                           Class<? extends UnLabeledStmtContext>...clazz) {
        PlusCalParser.UnLabeledStmtContext unlabeled;
        if ((unlabeled = ctx.unLabeledStmt()) == null) return false;
        return Arrays.stream(clazz).anyMatch(aClass -> aClass.isInstance(unlabeled));

    }

    public static boolean isStmtType(StmtContext ctx,
                                     Class<? extends UnLabeledStmtContext> clazz) {
        PlusCalParser.UnLabeledStmtContext unlabeled;
        if ((unlabeled = ctx.unLabeledStmt()) == null) return false;
        return clazz.isInstance(unlabeled);
    }

    public static boolean labeled(StmtContext stmt) {
        return stmt.label() != null;
    }

    public static boolean anyLabeled(CompoundStmtContext ctx) {
        for (StmtContext stmt: ctx.stmt()) {
            if (labeled(stmt)) return true;
        }
        return false;
    }

}
