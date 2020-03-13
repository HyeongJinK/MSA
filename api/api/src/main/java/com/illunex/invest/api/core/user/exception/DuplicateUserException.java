package com.illunex.invest.api.core.user.exception;

public class DuplicateUserException extends RuntimeException {
    public DuplicateUserException(String s) {
        super(s);
    }
}
