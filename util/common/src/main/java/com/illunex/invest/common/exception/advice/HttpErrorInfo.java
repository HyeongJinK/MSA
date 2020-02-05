package com.illunex.invest.common.exception.advice;

import lombok.AllArgsConstructor;
import lombok.Getter;
import org.springframework.http.HttpStatus;

import java.time.ZonedDateTime;

@Getter
@AllArgsConstructor
public class HttpErrorInfo {
    private final ZonedDateTime timestamp;
    private final HttpStatus httpStatus;
    private final String message;

    public HttpErrorInfo(HttpStatus httpStatus, String message) {
        timestamp = ZonedDateTime.now();
        this.httpStatus = httpStatus;
        this.message = message;
    }
}
