package com.illunex.invest.InvestorRelations.persistence.entity;

import lombok.*;

import javax.persistence.*;

@Entity
@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "major_personnel")
public class MajorPersonnelEntity {// 주요인력
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    Long idx;
    String imgUrl;              // 사진
    String rank;                // 직급
    String name;                // 이름
    String etc;                 // 비고
}
