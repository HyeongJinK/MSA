package com.illunex.invest.notice.persistence.entity;

import lombok.Getter;
import lombok.Setter;
import javax.persistence.*;
import java.sql.Timestamp;

@Getter
@Setter
@Entity
public class Notice {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    Long noticeIdx;              // ID
    String subject;              // 제목
    Timestamp regDate;           // 등록일
    String content;              // 내용
}
