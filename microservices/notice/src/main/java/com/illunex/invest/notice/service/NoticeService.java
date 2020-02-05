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

    public Notice getOneNotice(Long id) {
        return this.noticeRepository.findByNoticeIdx(id);
    }

    public Notice addNotice(Notice notice) { return noticeRepository.save(notice); }

    public List<Notice> getAllNotice() { return this.noticeRepository.findAll(); }
}
