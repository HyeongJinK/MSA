package com.illunex.invest.user.controller;

import com.illunex.invest.api.core.user.controller.SignUpController;
import com.illunex.invest.api.core.user.dto.UserDTO;
import com.illunex.invest.api.core.user.model.SignUpRequest;
import com.illunex.invest.user.exception.DuplicateUserException;
import com.illunex.invest.user.service.SignUpService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;

@RestController
@RequiredArgsConstructor
public class SignUpControllerImpl implements SignUpController {
    private final SignUpService signUpService;

    @Override
    public ResponseEntity<UserDTO> signUp(SignUpRequest signUpRequest) {
        return new ResponseEntity(signUpService.signUp(signUpRequest.getUsername()
                    , signUpRequest.getPassword()
                    , signUpRequest.getName())
                , HttpStatus.OK);
    }

    @ExceptionHandler(DuplicateUserException.class)
    public ResponseEntity<HashMap> DuplicateUserException(DuplicateUserException e) {
        HashMap<String, Object> result = new HashMap<>();
        result.put("message", "중복된 유저가 있습니다.");

        return new ResponseEntity<>(result, HttpStatus.EXPECTATION_FAILED);
    }
}
