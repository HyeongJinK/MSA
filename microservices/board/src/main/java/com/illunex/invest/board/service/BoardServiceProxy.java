package com.illunex.invest.board.service;


import org.springframework.cloud.netflix.ribbon.RibbonClient;
//import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

//@FeignClient(name = "gateway")
@RibbonClient(name = "board")
public interface BoardServiceProxy {
    @RequestMapping(value = "/notice/test", method = RequestMethod.GET)
    public String getTest();
}
