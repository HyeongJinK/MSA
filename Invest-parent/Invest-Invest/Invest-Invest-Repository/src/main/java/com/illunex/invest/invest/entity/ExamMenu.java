package com.illunex.invest.invest.entity;

import com.illunex.invest.invest.entity.enumable.ViewMode;

import javax.persistence.*;
import java.util.List;

@Entity
public class ExamMenu {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    Long examMenuIdx;
    Long userIdx;
    String title;
    ViewMode viewMode;

    @OneToMany
    List<ExamItemTemplate> examItemTemplate;
}
