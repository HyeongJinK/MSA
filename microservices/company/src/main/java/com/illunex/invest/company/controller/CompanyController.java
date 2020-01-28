package com.illunex.invest.company.controller;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class CompanyController {
    private Log log = LogFactory.getLog(CompanyController.class);

    @RequestMapping("/test")
    public String test() {
        return "test";
    }
}
