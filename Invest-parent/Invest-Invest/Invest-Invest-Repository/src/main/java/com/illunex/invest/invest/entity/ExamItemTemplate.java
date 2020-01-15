package com.illunex.invest.invest.entity;

import com.illunex.invest.invest.entity.enumable.ViewMode;

import javax.persistence.*;

@Entity
public class ExamItemTemplate {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    Long examItemTemplateIdx;
    String title;
    ViewMode viewMode;

    @ManyToOne
    ExamMenu examMenu;
}
