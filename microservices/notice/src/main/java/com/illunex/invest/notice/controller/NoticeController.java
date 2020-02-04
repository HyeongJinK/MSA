package com.illunex.invest.notice.controller;

import com.illunex.invest.notice.persistence.entity.Notice;
import com.illunex.invest.notice.persistence.repository.NoticeRepository;
import com.google.gson.Gson;
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
    NoticeRepository noticeRepository;

    @CrossOrigin("*")
    @RequestMapping("/test")
    public String test() {

        List<Notice> data = noticeRepository.findAll();
        System.out.println(data);
        Gson gson = new Gson();
        String json = gson.toJson(data);
        System.out.println(json);
        return json;
    }
}
