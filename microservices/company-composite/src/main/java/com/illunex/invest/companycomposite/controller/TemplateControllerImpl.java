package com.illunex.invest.companycomposite.controller;

import com.illunex.invest.api.composite.TemplateController;
import com.illunex.invest.companycomposite.service.CompanyServiceProxy;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class TemplateControllerImpl implements TemplateController {
    private Log log = LogFactory.getLog(TemplateControllerImpl.class);

    @Autowired
    CompanyServiceProxy companyServiceProxy;

    @HystrixCommand(fallbackMethod = "fallFunc")
    @Override
    public String templateApi1() {
        String result = companyServiceProxy.getTest();
        return result;
    }

    public String fallFunc() {
        return "접속 오류 처리";
    }
}
