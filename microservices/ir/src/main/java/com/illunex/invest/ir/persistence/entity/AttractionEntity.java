package com.illunex.invest.ir.persistence.entity;

import lombok.*;

import javax.persistence.*;

@Entity
@Getter @Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "attraction")
public class AttractionEntity {  // 기존 투자 유치
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    Long idx;
    String name;                    // title
    String price;                   // 금액
    String date;                    // 날짜

    @ManyToOne
    @JoinColumn(name = "basic_info_idx")
    BasicInfoEntity basicInfo;
}
