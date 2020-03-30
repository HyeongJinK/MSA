package com.illunex.invest.startup.controller;

import com.illunex.invest.api.common.exception.ExpireUserException;
import com.illunex.invest.api.common.exception.FileUploadException;
import com.illunex.invest.api.common.response.ResponseData;
import com.illunex.invest.api.composite.startup.DefaultController;
import com.illunex.invest.api.core.user.exception.UsernameSearchEmptyException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.DisabledException;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.web.bind.annotation.ExceptionHandler;

public class StartupDefaultController extends DefaultController {
    @ExceptionHandler(ExpireUserException.class)
    public ResponseEntity<ResponseData> ExpireUser(ExpireUserException e) {
        return new ResponseEntity<>(ResponseData.builder()
                .errorCode(44)
                .message(e.getMessage())
                .build(), HttpStatus.OK);
    }

    @ExceptionHandler(DisabledException.class)
    public ResponseEntity<ResponseData> DisabledException(DisabledException e) {
        return exceptionProcess(e.getMessage());
    }

    @ExceptionHandler(BadCredentialsException.class)
    public ResponseEntity<ResponseData> BadCredentialsException(BadCredentialsException e) {
        return exceptionProcess(e.getMessage());
    }

    @ExceptionHandler(UsernameNotFoundException.class)
    public ResponseEntity<ResponseData> UsernameNotFoundException(UsernameNotFoundException e) {
        return exceptionProcess(e.getMessage());
    }

    @ExceptionHandler(UsernameSearchEmptyException.class)
    public ResponseEntity<ResponseData> UsernameSearchEmpty(UsernameSearchEmptyException e) {
        return exceptionProcess(e.getMessage());
    }

    @ExceptionHandler(FileUploadException.class)
    public ResponseEntity<ResponseData> FileUpload(FileUploadException e) {
        return exceptionProcess(e.getMessage());
    }
}
