package com.illunex.invest.ir.persistence.entity;

import lombok.*;

import javax.persistence.*;

@Entity
@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "ip")
public class IPEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    Long idx;
    String area;                         // 선택
    String applicationNumber;            // 출원번호
    String content;                      // 내용
    String date;                         // 날짜

    @ManyToOne
    @JoinColumn(name = "product_idx")
    ProductEntity product;
}
