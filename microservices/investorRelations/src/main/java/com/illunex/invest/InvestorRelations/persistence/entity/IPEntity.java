package com.illunex.invest.InvestorRelations.persistence.entity;

import lombok.*;

import javax.persistence.*;
import java.time.LocalDateTime;

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
    String applicationNumber;            // 출원번호
    String content;                      // 내용
    LocalDateTime date;                  // 날짜

    @ManyToOne
    @JoinColumn(name = "product_idx")
    ProductEntity product;
}
