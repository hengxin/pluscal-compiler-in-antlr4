package com.PlusCal.interp;

public class SemanticException extends RuntimeException{

    public SemanticException() {
        super();
    }

    public SemanticException(String msg) {
        super(msg);
    }

    public SemanticException(Throwable cause) {
        super(cause);
    }

    public SemanticException(String msg, Throwable cause) {
        super(msg, cause);
    }
}
