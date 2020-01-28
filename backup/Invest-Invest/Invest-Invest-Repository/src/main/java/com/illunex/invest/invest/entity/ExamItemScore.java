package com.illunex.invest.invest.entity;

import javax.persistence.*;

@Entity
public class ExamItemScore {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    Long examItemScoreIdx;
    String score;

    @OneToOne
    ExamItem examItem;
}
