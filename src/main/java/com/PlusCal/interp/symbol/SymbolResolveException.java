package com.PlusCal.interp.symbol;

import com.PlusCal.interp.SemanticException;

public class SymbolResolveException extends SemanticException {

    public SymbolResolveException() {
        super();
    }

    public SymbolResolveException(String msg) {
        super(msg);
    }

    public SymbolResolveException(Throwable cause) {
        super(cause);
    }

    public SymbolResolveException(String msg, Throwable cause) {
        super(msg, cause);
    }
}
