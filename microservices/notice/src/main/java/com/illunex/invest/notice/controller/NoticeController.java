package com.illunex.invest.notice.controller;

import com.illunex.invest.notice.persistence.entity.Notice;
import com.illunex.invest.notice.service.NoticeService;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.sql.Timestamp;
import java.time.LocalDateTime;
import java.util.List;

@CrossOrigin("*")
@RestController
public class NoticeController {
    private Log log = LogFactory.getLog(NoticeController.class);

    @Autowired
    NoticeService noticeService;

    @GetMapping("/notice/list")
    public ResponseEntity<List<Notice>> getAllNotice() {
        return new ResponseEntity(noticeService.getAllNotice(), HttpStatus.OK);
    }

    @GetMapping("/notice/{id}")
    public ResponseEntity<Notice> getOneNotice(@PathVariable("id") Long id) {
        return new ResponseEntity(noticeService.getOneNotice(id), HttpStatus.OK);
    }

    @PostMapping("/notice/add")
    public ResponseEntity<Notice> addNotice(@RequestParam String subject, @RequestParam String content) {
        Notice notice = new Notice();
        notice.setSubject(subject);
        notice.setContent(content);
        notice.setRegDate(Timestamp.valueOf(LocalDateTime.now()));
        return new ResponseEntity(noticeService.addNotice(notice), HttpStatus.OK);
    }

    @PostMapping("/notice/update")
    public ResponseEntity<Notice> updateNotice(@RequestParam Long id, @RequestParam String subject, @RequestParam String content) {
        Notice notice = new Notice();
        notice.setNoticeIdx(id);
        notice.setSubject(subject);
        notice.setContent(content);
        notice.setRegDate(Timestamp.valueOf(LocalDateTime.now()));
        return new ResponseEntity(noticeService.addNotice(notice), HttpStatus.OK);
    }
}
