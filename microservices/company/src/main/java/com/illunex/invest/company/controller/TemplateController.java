package com.illunex.invest.company.controller;

import com.illunex.invest.api.core.user.model.SignInRequest;
import com.illunex.invest.common.exception.exceptions.TemplateException;
import com.illunex.invest.company.exception.TestException;
import org.springframework.web.bind.annotation.*;

@RestController
public class TemplateController {
    @GetMapping("/test")
    public String test() {
        return "test";
    }

    @PostMapping("/test2")
    public String test2() {
        return "test2";
    }

    @PostMapping("/test3")
    public String test3(@RequestBody SignInRequest signInRequest) {
        return signInRequest.getUsername();
    }


    @GetMapping("/errorTemplate")
    public String errorTemplate() {
        if (true) {
            throw new TestException("에러 템플릿 테스트 t");
        }
        return "test";
    }

    @GetMapping("/errorTemplate2")
    public String CommonErrorTemplate() {
        if (true) {
            throw new TemplateException("에러 템플릿 테스트 t2");
        }
        return "test";
    }

    @ExceptionHandler(TestException.class)
    public String testException() {
        return "testError";
    }
}
