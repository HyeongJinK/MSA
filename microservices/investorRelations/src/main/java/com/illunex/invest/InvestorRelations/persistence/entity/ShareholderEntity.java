package com.illunex.invest.InvestorRelations.persistence.entity;

import lombok.*;

import javax.persistence.*;

@Entity
@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "shareholder")
public class ShareholderEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    Long idx;
    String name;                // 주주명
    String value;               // 금액
    String etc;                 // 비고

    @ManyToOne
    @JoinColumn(name = "ir_idx")
    IREntity ir;
}
