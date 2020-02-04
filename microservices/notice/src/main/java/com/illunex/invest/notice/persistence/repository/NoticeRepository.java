package com.illunex.invest.notice.persistence.repository;

import com.illunex.invest.notice.persistence.entity.Notice;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface NoticeRepository extends JpaRepository<Notice, Long> {
    Notice findByNoticeIdx(Long noticeIdx);
}
