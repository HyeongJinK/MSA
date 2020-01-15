package com.illunex.invest.invest.entity;

import javax.persistence.*;
import java.util.List;

@Entity
public class Judge {    // 특정 제안에 선택된 심사위원
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    Long judgeIdx;
    Long userIdx;

    @OneToOne
    JudgeTemplate judgeTemplate;
    @OneToMany
    List<ExamItemScore> examItemScores;
}
