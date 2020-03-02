package com.illunex.invest.InvestorRelations.persistence.entity;

import lombok.*;

import javax.persistence.*;
import java.util.List;

@Entity
@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "outcome")
public class OutcomeEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    Long idx;
    String content;

    @OneToOne(mappedBy = "outcome", fetch = FetchType.LAZY, cascade = CascadeType.DETACH)
    IREntity ir;

    @OneToMany(mappedBy = "outcome", cascade = CascadeType.ALL)
    List<InvestEntity> invest;               // 투자

    @OneToMany(mappedBy = "outcome", cascade = CascadeType.ALL)
    List<AwardEntity> award;                 // 수상실적

    @OneToMany(mappedBy = "outcome", cascade = CascadeType.ALL)
    List<ExportEntity> export;               // 수출

    @OneToMany(mappedBy = "outcome", cascade = CascadeType.ALL)
    List<FundEntity> fund;                   // 정책자금

    @OneToMany(mappedBy = "outcome", cascade = CascadeType.ALL)
    List<PlanEntity> plan;                   // 주요계획

}
