package com.arturbarth.VotosAPI.v1.exceptions;

import org.springframework.http.HttpStatus;
import static java.util.Objects.nonNull;

public class DefaultException extends RuntimeException {

    private final HttpStatus httpStatus;

    public DefaultException(String message, HttpStatus httpStatus) {
        super(message);
        this.httpStatus = nonNull(httpStatus) ? httpStatus : HttpStatus.INTERNAL_SERVER_ERROR;
    }
}