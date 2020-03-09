package com.illunex.invest.api.core.ir.dto;

import lombok.*;

import java.util.List;

@Builder
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class ProductDTO {
    Long idx;
    Long irIdx;
    String productInformation;           // 제품 설명
    String productDifference;            // 제품 차별성
    String mainTechnology;               // 주요 기술
    String technologyDifference;         // 기술 차별성
    String marketResearch;               // 시장 리서치
    String positioning;                  // 포지셔닝

    List<CustomerDTO> customer;           // 주요 매출처
    List<IPDTO> ip;                       // 지적 재산권
    List<MarketDTO> market;               // 목표 시장
    List<MarketPlayerDTO> marketPlayer;   // 주요 경쟁사
}
