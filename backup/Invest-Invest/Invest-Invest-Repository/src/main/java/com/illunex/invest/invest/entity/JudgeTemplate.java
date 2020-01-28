package com.illunex.invest.invest.entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import java.util.Date;

@Entity
public class JudgeTemplate {    // 심사위원
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    Long judgeTemplateIdx;
    Long userIdx;
    Boolean accept;         // 승인여부
    Date inviteDate;        // 초대
    Date createDate;         // 가입일
}
