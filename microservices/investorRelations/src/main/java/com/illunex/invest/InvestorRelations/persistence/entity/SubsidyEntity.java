package com.illunex.invest.InvestorRelations.persistence.entity;

import lombok.*;

import javax.persistence.*;

@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Table(name = "subsidy")
public class SubsidyEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    Long idx;
    String name;                // title
    String value;               // 금액
    String date;                // 날짜

    @ManyToOne
    @JoinColumn(name = "basic_info_idx")
    BasicInfoEntity basicInfo;
}
