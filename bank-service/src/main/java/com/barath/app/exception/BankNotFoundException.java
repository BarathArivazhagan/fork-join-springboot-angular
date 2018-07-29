package com.barath.app.exception;

public class BankNotFoundException extends RuntimeException {

    public BankNotFoundException() {
        super();
    }

    public BankNotFoundException(String message) {
        super(message);
    }

    public BankNotFoundException(String message, Throwable cause) {
        super(message, cause);
    }

    public BankNotFoundException(Throwable cause) {
        super(cause);
    }

    protected BankNotFoundException(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
        super(message, cause, enableSuppression, writableStackTrace);
    }
}
