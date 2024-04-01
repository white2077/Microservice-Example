package com.white.product.core.exception;

import lombok.*;
import org.springframework.http.HttpStatus;

import java.io.Serial;
import java.util.Map;
@EqualsAndHashCode(callSuper = false)
@Getter
@Setter
public class WhiteException extends RuntimeException{

    private final HttpStatus httpStatus;

    private final String errorCode;

    private final String errorMessage;

    private final Map<String, Object> details;

    public WhiteException(HttpStatus httpStatus, String errorCode, String errorMessage, Map<String, Object> details) {
        this.httpStatus = httpStatus;
        this.errorCode = errorCode;
        this.errorMessage = errorMessage;
        this.details = details;
    }
}
