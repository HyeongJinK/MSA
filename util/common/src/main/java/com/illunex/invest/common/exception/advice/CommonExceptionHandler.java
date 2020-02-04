package com.illunex.invest.common.exception.advice;

import com.illunex.invest.common.exception.exceptions.TemplateException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class CommonExceptionHandler {
    private static final Logger LOG = LoggerFactory.getLogger(CommonExceptionHandler.class);

    @ExceptionHandler(TemplateException.class)
    @ResponseStatus(HttpStatus.UNPROCESSABLE_ENTITY)
    public HttpErrorInfo templateException(Exception e) {
        return createHttpErrorInfo(HttpStatus.UNPROCESSABLE_ENTITY, e);
    }

    private HttpErrorInfo createHttpErrorInfo(HttpStatus httpStatus, Exception ex) {
        final String message = ex.getMessage();
        LOG.debug("HTTP Status: {}, Message: {}", httpStatus, message);
        return new HttpErrorInfo(httpStatus, message);
    }
}
