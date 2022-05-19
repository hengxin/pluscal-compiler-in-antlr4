package com.PlusCal.interp.symbol;

import com.PlusCal.interp.SemanticException;

public class DefinitionException extends SemanticException {

    public DefinitionException() {
        super();
    }

    public DefinitionException(String msg) {
        super(msg);
    }

    public DefinitionException(Throwable cause) {
        super(cause);
    }

    public DefinitionException(String msg, Throwable cause) {
        super(msg, cause);
    }
}
