package com.white.product.core.model;

import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;

public class ResponseObject<T> extends ResponseEntity<ResponseObject.Payload<T>> {

    public ResponseObject(HttpStatusCode status, String message, T data) {
        super(new Payload<>(status.value(),message,data), status);
    }
    public ResponseObject(HttpStatusCode status, String message) {
        super(new Payload<>(status.value(),message), status);
    }


    @AllArgsConstructor
    @Getter
    @Setter
    public static class Payload<T> {
        private int status;
        private String message;
        @JsonInclude(JsonInclude.Include.NON_NULL)
        private T data;

        public Payload( int status,String message) {
            this.message = message;
            this.status = status;
        }
    }

}
