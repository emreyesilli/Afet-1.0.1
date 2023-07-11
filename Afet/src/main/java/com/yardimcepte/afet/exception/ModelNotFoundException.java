package com.yardimcepte.afet.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

import java.util.Objects;

@ResponseStatus(HttpStatus.NOT_FOUND)
public class ModelNotFoundException extends RuntimeException {

    private ErrorResponse errorResponse;

    public ModelNotFoundException(ErrorResponse errorResponse) {
        this.errorResponse = errorResponse;
    }


    public ErrorResponse getErrorResponse() {
        return errorResponse;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        ModelNotFoundException that = (ModelNotFoundException) o;
        return Objects.equals(errorResponse, that.errorResponse);
    }

    @Override
    public int hashCode() {
        return Objects.hash(errorResponse);
    }
}
