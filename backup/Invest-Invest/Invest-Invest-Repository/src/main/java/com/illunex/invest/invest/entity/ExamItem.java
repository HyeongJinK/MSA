package com.illunex.invest.invest.entity;

import javax.persistence.*;

@Entity
public class ExamItem {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    Long examItemIdx;
    @OneToOne
    ExamItemTemplate examItemTemplate;
}
