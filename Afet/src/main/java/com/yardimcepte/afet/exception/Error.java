package com.yardimcepte.afet.exception;

public record Error(
        String code,
        String type,
        String info
) {
}