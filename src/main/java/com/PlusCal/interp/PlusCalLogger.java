package com.PlusCal.interp;

import org.antlr.v4.runtime.*;
import org.antlr.v4.runtime.tree.TerminalNode;

import java.util.logging.Level;
import java.util.logging.Logger;

import static com.PlusCal.interp.RuleContextUtils.*;

public class PlusCalLogger extends BaseErrorListener {

    private static final PlusCalLogger pcalLogger = new PlusCalLogger();

    public static PlusCalLogger getLogger() {
        return pcalLogger;
    }

    private static Logger logger = Logger.getLogger("PlusCalCompiler");

    static {
        logger.setLevel(Level.ALL);
    }

    private PlusCalLogger() { }

    @Override
    public void syntaxError(Recognizer<?, ?> recognizer,
                            Object offendingSymbol,
                            int line, int charPositionInLine,
                            String msg,
                            RecognitionException e) {
        System.err.println("line " + line + ":" + charPositionInLine + " " + msg);
        underlineError(recognizer, (Token) offendingSymbol, line, charPositionInLine);
    }

    private void underlineError(Recognizer<?, ?> recognizer,
                                       Token offendingToken, int line,
                                       int charPositionInLine) {
        CommonTokenStream tokens = (CommonTokenStream) recognizer.getInputStream();
        String input = tokens.getTokenSource().getInputStream().toString();
        String[] lines = input.split("\n");
        String errorLine = lines[line - 1];
        System.err.println(errorLine);
        for (int i = 0; i < charPositionInLine; i++)  System.err.print(" ");
        int start = offendingToken.getStartIndex(), stop = offendingToken.getStopIndex();
        if (start >= 0 && stop >= 0) {
            for (int i = start; i <= stop; i++) System.err.println("^");
        }
        System.err.println();
    }

    public static void logInfo(String word) {
        logger.info(word);
    }

    public static void reportError(String msg, ParserRuleContext ctx) {
        reportError(msg, getLine(ctx), getStartPos(ctx));
    }

    public static void reportError(String msg, TerminalNode terminalNode) {
        reportError(msg, terminalNode.getSymbol().getLine(), terminalNode.getSymbol().getCharPositionInLine());
    }

    public static void warning(String msg) {
        logger.warning(msg);
    }

    public static void warning(String msg, int line) {
        logger.warning("line " + line + ": " + msg);
    }

    public static void reportError(String msg, int line, int column) {
        System.err.println("ERROR in line " + line + ", column " + column + ": " + msg + "!");
    }
}
