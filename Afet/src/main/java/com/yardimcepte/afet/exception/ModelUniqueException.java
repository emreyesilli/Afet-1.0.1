package com.yardimcepte.afet.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

import java.util.Objects;

@ResponseStatus(HttpStatus.BAD_REQUEST)
public class ModelUniqueException extends RuntimeException {
    private ErrorResponse errorResponse;

    public ModelUniqueException(ErrorResponse errorResponse) {
        this.errorResponse = errorResponse;
    }


    public ErrorResponse getErrorResponse() {
        return errorResponse;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        ModelUniqueException that = (ModelUniqueException) o;
        return Objects.equals(errorResponse, that.errorResponse);
    }

    @Override
    public int hashCode() {
        return Objects.hash(errorResponse);
    }
}
