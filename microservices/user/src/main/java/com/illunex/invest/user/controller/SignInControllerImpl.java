package com.illunex.invest.user.controller;

import com.illunex.invest.api.core.user.controller.SingInController;
import com.illunex.invest.api.core.user.dto.UserDTO;
import com.illunex.invest.api.core.user.model.SignInRequest;
import com.illunex.invest.user.exception.UsernameNotFoundException;
import com.illunex.invest.user.exception.UsernameSearchEmptyException;
import com.illunex.invest.user.service.SignInService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;

@RestController
@RequiredArgsConstructor
public class SignInControllerImpl implements SingInController {
    private final SignInService signInService;

    @Override
    public ResponseEntity<UserDTO> findUser(SignInRequest request) {
        return ResponseEntity.ok(signInService.findByUsername(request.getUsername()));
    }

    @ExceptionHandler(UsernameNotFoundException.class)
    public ResponseEntity<HashMap> UsernameNotFoundException(UsernameNotFoundException e) {
        HashMap<String, Object> result = new HashMap<>();
        result.put("message", "아이디를 입력해주세요");

        return new ResponseEntity<>(result, HttpStatus.EXPECTATION_FAILED);
    }
    @ExceptionHandler(UsernameSearchEmptyException.class)
    public ResponseEntity<HashMap> UsernameSearchEmpty(UsernameSearchEmptyException e) {
        HashMap<String, Object> result = new HashMap<>();
        result.put("message", "없는 유저입니다.");

        return new ResponseEntity<>(result, HttpStatus.EXPECTATION_FAILED);
    }
}
