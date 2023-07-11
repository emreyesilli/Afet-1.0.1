package com.yardimcepte.afet.exception;

public record ErrorResponse(
        boolean success,
        String message
) {
}