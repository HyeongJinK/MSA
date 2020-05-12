package com.illunex.invest.company.persistence.entity;

import lombok.*;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Embeddable
@Getter @Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class MainProduct {
    String mainProductName;     // 주요제품 - 제품명
    @Column(length=1000)
    String introduction;        // 주요제품 - 제품 한줄 소개출
    @OneToMany(fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    List<MainProductLine> mainProductLines = new ArrayList<>();     // 주요제품군
}
