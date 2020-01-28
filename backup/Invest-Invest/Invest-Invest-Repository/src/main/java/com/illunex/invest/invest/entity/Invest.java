package com.illunex.invest.invest.entity;

import com.illunex.invest.invest.entity.enumable.InvestState;

import javax.persistence.*;
import java.util.List;

@Entity
public class Invest {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    Long idx;
    Long userIdx;
    Long companyIdx;
    InvestState investState;

    @OneToMany
    List<Judge> judges;             // 심사위원
    @OneToMany
    List<ExamItem> examItems;       // 심사항목
}
