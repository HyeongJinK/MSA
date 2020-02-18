package com.illunex.invest.company.exception;

import lombok.NoArgsConstructor;

@NoArgsConstructor
public class NoneCompanyException extends RuntimeException {
    public NoneCompanyException(String message) {
        super(message);
    }

    public NoneCompanyException(String message, Throwable cause) {
        super(message, cause);
    }

    public NoneCompanyException(Throwable cause) {
        super(cause);
    }
}
