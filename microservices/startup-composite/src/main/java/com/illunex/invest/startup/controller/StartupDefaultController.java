package com.illunex.invest.startup.controller;

import com.illunex.invest.api.common.exception.ExpireUserException;
import com.illunex.invest.api.common.response.ResponseData;
import com.illunex.invest.api.composite.startup.company.controller.DefaultController;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;

public class StartupDefaultController extends DefaultController {
    @ExceptionHandler(ExpireUserException.class)
    public ResponseEntity<ResponseData> FileUpload(ExpireUserException e) {
        return new ResponseEntity<>(ResponseData.builder()
                .errorCode(44)
                .message(e.getMessage())
                .build(), HttpStatus.OK);
    }
}
