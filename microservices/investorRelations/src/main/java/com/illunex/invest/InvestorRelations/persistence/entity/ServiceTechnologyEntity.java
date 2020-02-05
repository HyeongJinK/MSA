package com.illunex.invest.InvestorRelations.persistence.entity;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = "service_technology")
public class ServiceTechnologyEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    Long stIdx;
    Long evaluationIdx;
    String productDescription;                          // 주요 제품/서비스 설명 및 차별점
    String salesStructure;                              // 주요 매출 구성
    String marketResearchAndPositioning;                // 시장 리서치 및 포지셔닝
    String skills;                                      // 주요 보유 기술
    String description;

    @OneToMany(cascade = CascadeType.ALL)
    List<TargetMarketAndScaleEntity> targetMarketAndScaleEntities;   // 주요 목표 시장 및 규모
    @OneToMany(cascade = CascadeType.ALL)
    List<CompetitorsEntity> competitors;                      // 주요 경쟁사
    @OneToMany(cascade = CascadeType.ALL)
    List<IntellectualPropertyEntity> intellectualProperties;  // 지식재산권 현황
}
