package com.PlusCal.interp;

import org.antlr.v4.runtime.*;
import org.antlr.v4.runtime.tree.TerminalNode;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

public class PlusCalLogger extends BaseErrorListener {

    private static final PlusCalLogger logger = new PlusCalLogger();
    private List<Record> records;

    private static class Record {
        final String msg;
        long timestamp;

        private Record(String text) {
            this.msg = text;
            this.timestamp = System.currentTimeMillis();
        }

        @Override
        public String toString() {
            StringBuilder buf = new StringBuilder();
            buf.append(new SimpleDateFormat("yyyy-MM-dd HH:mm:ss:SSS").format(new Date(timestamp)));
            buf.append(" ");
            buf.append(msg);
            return buf.toString();
        }
    }

    public static PlusCalLogger getLogger() {
        return logger;
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
        System.out.println(word);
    }

    public static void reportError(String msg, ParserRuleContext ctx) {
        reportError(msg, ctx.start.getLine());
    }

    public static void reportError(String msg, TerminalNode terminalNode) {
        reportError(msg, terminalNode.getSymbol().getLine());
    }

    public static void reportError(String msg, int line) {
        System.err.println("ERROR in line " + line + ": " + msg + "!");
    }
}
