//package com.illunex.invest.notice.controller;
//
//import com.illunex.invest.api.composite.TemplateController;
//import com.illunex.invest.notice.service.NoticeServiceProxy;
//import org.apache.commons.logging.Log;
//import org.apache.commons.logging.LogFactory;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.web.bind.annotation.RestController;
//
//@RestController
//public class TemplateControllerImpl implements TemplateController {
//    private Log log = LogFactory.getLog(TemplateControllerImpl.class);
//
//    @Autowired
//    NoticeServiceProxy noticeServiceProxy;
//
//    @Override
//    public String templateApi1() {
//        String result = noticeServiceProxy.getTest();
//        return result;
//    }
//}
