package com.white.product.core.interceptor;

import com.white.product.core.emum.ExceptionCode;
import com.white.product.core.exception.WhiteException;
import com.white.product.core.model.ErrorResponse;
import jakarta.validation.ConstraintViolation;
import jakarta.validation.ConstraintViolationException;
import lombok.extern.slf4j.Slf4j;
import org.springframework.core.Ordered;
import org.springframework.core.annotation.Order;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

import java.util.Map;
import java.util.stream.Collectors;

@Slf4j
@ControllerAdvice
@Order(Ordered.HIGHEST_PRECEDENCE)
public class ExceptionResponseHandler extends ResponseEntityExceptionHandler {
    @ExceptionHandler(value = { WhiteException.class })
    protected ResponseEntity<Object> handle(WhiteException ex ) {
        ErrorResponse errorResponse = new ErrorResponse(ex.getErrorCode(), ex.getErrorMessage(), ex.getDetails());
        return new ResponseEntity<>(errorResponse, new HttpHeaders(), ex.getHttpStatus());
    }

    @ExceptionHandler(ConstraintViolationException.class)
    public final ResponseEntity<Object> handleConstraintViolationException(ConstraintViolationException ex ) {
        Map<String, Object> details = ex.getConstraintViolations().stream()
                .collect(Collectors.toMap(violation ->
                                violation.getPropertyPath().toString(), ConstraintViolation::getMessage));
        ErrorResponse errorMessage = new ErrorResponse(ExceptionCode.INVALID_DATA.CODE, ExceptionCode.INVALID_DATA.MESSAGE,details);
        return new ResponseEntity<>(errorMessage, HttpStatus.BAD_REQUEST);
    }
}
