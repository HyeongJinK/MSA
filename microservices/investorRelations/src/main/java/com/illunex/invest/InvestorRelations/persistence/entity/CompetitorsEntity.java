package com.illunex.invest.InvestorRelations.persistence.entity;

import com.illunex.invest.InvestorRelations.persistence.entity.enumable.NationType;
import lombok.*;

import javax.persistence.*;

@Entity
@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "competitors")
public class CompetitorsEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    Long competitorsIdx;
    @Enumerated(EnumType.STRING)
    NationType nation;          // 국가
    String description;         // 내용
    String sales;               // 매출
}
