package com.illunex.invest.apiconsumer.service;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class TestController {
    private Log log = LogFactory.getLog(TestController.class);

    @Autowired CompanyServiceProxy companyServiceProxy;

    @RequestMapping("/test")
    public String test() {
        String result = companyServiceProxy.getTest();
        return result;
    }
}
