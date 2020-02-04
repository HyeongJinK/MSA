package com.illunex.invest.notice.controller;

import com.illunex.invest.notice.persistence.entity.Notice;
import com.illunex.invest.notice.service.NoticeService;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import java.util.List;

@RestController
public class NoticeController {
    private Log log = LogFactory.getLog(NoticeController.class);

    @Autowired
    NoticeService noticeService;

    @CrossOrigin("*")
    @RequestMapping("/test")
    public List<Notice> test() {

        List<Notice> data = noticeService.test();

        return data;
    }

    @CrossOrigin("*")
    @RequestMapping("/testOne")
    public Notice testOne() {

        Notice data = noticeService.testOne();

        return data;
    }
}
