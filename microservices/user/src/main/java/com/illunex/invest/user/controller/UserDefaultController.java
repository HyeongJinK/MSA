package com.illunex.invest.user.controller;

import com.illunex.invest.api.common.response.ResponseData;
import com.illunex.invest.api.composite.startup.company.controller.DefaultController;
import com.illunex.invest.api.core.user.exception.DuplicateUserException;
import com.illunex.invest.api.core.user.exception.UsernameNotFoundException;
import com.illunex.invest.api.core.user.exception.UsernameSearchEmptyException;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.web.bind.annotation.ExceptionHandler;

public class UserDefaultController extends DefaultController {
    @ExceptionHandler(UsernameNotFoundException.class)
    public ResponseEntity<ResponseData> UsernameNotFound(UsernameNotFoundException e) {
        return exceptionProcess(e.getMessage());
    }

    @ExceptionHandler(BadCredentialsException.class)
    public ResponseEntity<ResponseData> BadCredentials(BadCredentialsException e) {
        return exceptionProcess(e.getMessage());
    }

    @ExceptionHandler(UsernameSearchEmptyException.class)
    public ResponseEntity<ResponseData> UsernameSearchEmpty(UsernameSearchEmptyException e) {
        return exceptionProcess(e.getMessage());
    }

    @ExceptionHandler(DuplicateUserException.class)
    public ResponseEntity<ResponseData> DuplicateUserException(DuplicateUserException e) {
        return exceptionProcess(e.getMessage());
    }
}
