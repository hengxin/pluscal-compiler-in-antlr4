package com.PlusCal.interp;

public class LabelException extends SemanticException {

    public LabelException() {
        super();
    }

    public LabelException(String msg) {
        super(msg);
    }

    public LabelException(String msg, Throwable cause) {
        super(msg, cause);
    }
}
