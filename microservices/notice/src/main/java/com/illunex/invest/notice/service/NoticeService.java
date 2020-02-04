package com.illunex.invest.notice.service;

import com.illunex.invest.notice.persistence.entity.Notice;
import com.illunex.invest.notice.persistence.repository.NoticeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class NoticeService {

    @Autowired
    NoticeRepository noticeRepository;

    public Notice testOne() {
        return this.noticeRepository.findByNoticeIdx(1L);
    }

    public List<Notice> test() {
        return this.noticeRepository.findAll();
    }
}
