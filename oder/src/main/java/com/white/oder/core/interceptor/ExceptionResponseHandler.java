package com.white.oder.core.interceptor;


import com.white.oder.core.exception.WhiteException;
import lombok.extern.slf4j.Slf4j;
import org.springframework.core.Ordered;
import org.springframework.core.annotation.Order;
import org.springframework.http.HttpHeaders;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;
import com.white.oder.core.model.ErrorResponse;

@Slf4j
@ControllerAdvice
@Order(Ordered.HIGHEST_PRECEDENCE)
public class ExceptionResponseHandler extends ResponseEntityExceptionHandler {
    @ExceptionHandler(value = { WhiteException.class })
    protected ResponseEntity<Object> handle(WhiteException ex ) {
        ErrorResponse errorResponse = new ErrorResponse(ex.getErrorCode(), ex.getErrorMessage(), ex.getDetails());
        return new ResponseEntity<>(errorResponse, new HttpHeaders(), ex.getHttpStatus());
    }
}
