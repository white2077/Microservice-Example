package com.white.product.core.emum;

public enum ExceptionCode {
    INVALID_DATA("E001", "Invalid data");
    public final String CODE;
    public final String MESSAGE;

    ExceptionCode(String code, String message) {
            this.CODE = code;
            this.MESSAGE = message;
    }
}
