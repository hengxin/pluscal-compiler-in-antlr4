package com.PlusCal.interp.symbol;

import com.PlusCal.interp.SemanticException;
import org.antlr.v4.runtime.ParserRuleContext;
import org.antlr.v4.runtime.tree.TerminalNode;

public class DefinitionException extends SemanticException {

    public DefinitionException() {
        super();
    }

    public DefinitionException(String msg) {
        super(msg);
    }

    public DefinitionException(String msg, ParserRuleContext ctx) {
        super(msg, ctx);
    }

    public DefinitionException(String msg, TerminalNode node) {
        super(msg, node);
    }

    public DefinitionException(String msg, Throwable cause) {
        super(msg, cause);
    }
}
