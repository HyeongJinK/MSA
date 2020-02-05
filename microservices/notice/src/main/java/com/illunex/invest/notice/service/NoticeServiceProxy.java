package com.illunex.invest.notice.service;


import org.springframework.cloud.netflix.ribbon.RibbonClient;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@FeignClient(name = "gateway")
@RibbonClient(name = "notice")
public interface NoticeServiceProxy {
    @RequestMapping(value = "/notice/test", method = RequestMethod.GET)
    public String getTest();
}
