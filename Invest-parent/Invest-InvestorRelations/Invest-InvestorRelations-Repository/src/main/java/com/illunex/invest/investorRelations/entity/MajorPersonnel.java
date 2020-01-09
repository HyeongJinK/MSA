package com.illunex.invest.investorRelations.entity;

import javax.persistence.*;

@Entity
public class MajorPersonnel {// 주요인력
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    Long idx;
    String imgUrl;              // 사진
    String rank;                // 직급
    String name;                // 이름
    String etc;                 // 비고
}
