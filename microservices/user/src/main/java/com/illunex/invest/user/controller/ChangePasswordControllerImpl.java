package com.illunex.invest.user.controller;

import com.illunex.invest.api.core.user.controller.ChangePasswordController;
import com.illunex.invest.api.core.user.model.ChangePasswordRequest;
import com.illunex.invest.user.exception.BadCredentialsException;
import com.illunex.invest.user.exception.UsernameSearchEmptyException;
import com.illunex.invest.user.service.ChangePasswordService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;

@RestController
@RequiredArgsConstructor
public class ChangePasswordControllerImpl implements ChangePasswordController {
    private final ChangePasswordService changePasswordService;

    @Override
    public ResponseEntity<HashMap<String, Object>> changePassword(ChangePasswordRequest request) {
        return new ResponseEntity<>(changePasswordService.changePassword(request.getUsername()
                    , request.getPrePassword()
                    , request.getPassword())
                , HttpStatus.OK);
    }

    @ExceptionHandler(BadCredentialsException.class)
    public ResponseEntity<HashMap<String, Object>> BadCredentials(BadCredentialsException e) {
        HashMap<String, Object> result = new HashMap<>();
        result.put("status", 302);
        result.put("message", e.getMessage());

        return new ResponseEntity<>(result, HttpStatus.OK);
    }

    @ExceptionHandler(UsernameSearchEmptyException.class)
    public ResponseEntity<HashMap<String, Object>> UsernameSearchEmpty(UsernameSearchEmptyException e) {
        HashMap<String, Object> result = new HashMap<>();
        result.put("status", 302);
        result.put("message", e.getMessage());

        return new ResponseEntity<>(result, HttpStatus.OK);
    }


}
