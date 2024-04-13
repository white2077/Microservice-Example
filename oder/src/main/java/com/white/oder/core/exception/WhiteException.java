package com.white.oder.core.exception;

import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;
import org.springframework.http.HttpStatus;

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
