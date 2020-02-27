package com.illunex.invest.InvestorRelations.persistence.entity;

import javax.persistence.*;

@Entity
@Table(name = "history")
public class HistoryEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    Long idx;
    String date;
    String content;

    @ManyToOne
    @JoinColumn(name = "ir_idx")
    IREntity ir;
}
