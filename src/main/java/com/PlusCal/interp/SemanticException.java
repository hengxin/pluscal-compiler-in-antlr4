package com.PlusCal.interp;

import org.antlr.v4.runtime.ParserRuleContext;
import org.antlr.v4.runtime.Token;
import org.antlr.v4.runtime.tree.TerminalNode;

public class SemanticException extends RuntimeException {

    private Token token;

    public SemanticException() {
        super();
    }

    public SemanticException(String msg) {
        super(msg);
    }

    public SemanticException(String msg, Throwable cause) {
        super(msg, cause);
    }

    public SemanticException(String msg, ParserRuleContext ctx) {
        super(msg);
    }

    public SemanticException(String msg, TerminalNode node) {
        super(msg);
        this.token = node.getSymbol();
    }

    public Token getOffendingToken() {
        return token;
    }
}
