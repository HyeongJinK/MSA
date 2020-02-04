package com.illunex.invest.notice.persistence.entity;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.util.Date;
import java.util.List;

@Getter
@Setter
@Entity
public class Notice {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    Long noticeIdx;
    String subject;         // 제목
    Date regDate;           // 등록일

}
