package com.illunex.invest.api.composite.startup;

import com.illunex.invest.api.common.response.ResponseData;
import org.jetbrains.annotations.NotNull;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

public class DefaultController {
    @NotNull
    protected ResponseEntity<ResponseData> exceptionProcess(String message) {
        return new ResponseEntity<>(ResponseData.builder()
                .errorCode(417)
                .message(message)
                .build(), HttpStatus.OK);
    }
}
