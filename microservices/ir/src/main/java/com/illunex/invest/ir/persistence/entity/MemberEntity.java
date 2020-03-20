package com.illunex.invest.ir.persistence.entity;

import lombok.*;

import javax.persistence.*;

@Entity
@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "member")
public class MemberEntity {// 주요인력
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    Long idx;
    String imgUrl;              // 사진
    String imgStatus;           // 사진 저장 유무
    String rank;                // 직급
    String name;                // 이름
    String etc;                 // 비고

    @ManyToOne
    @JoinColumn(name = "ir_idx")
    IREntity ir;
}
