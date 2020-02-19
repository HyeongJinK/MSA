package com.illunex.invest.company.exception;

import lombok.NoArgsConstructor;

@NoArgsConstructor
public class NoneCompanyException extends RuntimeException {
    public NoneCompanyException(String message) {
        super(message);
    }
}

