package com.illunex.invest.apiconsumer.service;


import org.springframework.cloud.netflix.ribbon.RibbonClient;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@FeignClient(name = "gateway")
@RibbonClient(name = "company")
public interface CompanyServiceProxy {
    @RequestMapping(value = "/company/test", method = RequestMethod.GET)
    public String getTest();
}
