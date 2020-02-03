package com.illunex.invest.companycomposite.service;

import io.swagger.annotations.ApiOperation;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class TestController {
    private Log log = LogFactory.getLog(TestController.class);

    @Autowired CompanyServiceProxy companyServiceProxy;
    @ApiOperation(value = "Retrieve all todos for a user by passing in his name"
            , notes = "A list of matching todos is returned. Currently pagination is not supported."
            , response = TestController.class
            , responseContainer = "List"
            , produces = "application/json")
    @RequestMapping("/test")
    public String test() {
        String result = companyServiceProxy.getTest();
        return result;
    }
}
