package com.illunex.invest.company.exception;

import lombok.NoArgsConstructor;

@NoArgsConstructor
public class TestException extends RuntimeException {
    public TestException(String message) {
        super(message);
    }

    public TestException(String message, Throwable cause) {
        super(message, cause);
    }

    public TestException(Throwable cause) {
        super(cause);
    }
}
