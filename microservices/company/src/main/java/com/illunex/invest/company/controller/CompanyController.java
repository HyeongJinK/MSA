package com.illunex.invest.company.controller;

import com.illunex.invest.company.exception.TestException;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.illunex.invest.common.exception.exceptions.TemplateException;

@RestController
public class CompanyController {
    private Log log = LogFactory.getLog(CompanyController.class);

    @RequestMapping("/test")
    public String test() {
        return "test";
    }

    @RequestMapping("/errorTemplate")
    public String errorTemplate() {
        if (true) {
            throw new TestException("에러 템플릿 테스트 t");
        }
        return "test";
    }

    @RequestMapping("/errorTemplate2")
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
