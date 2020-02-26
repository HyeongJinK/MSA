package com.illunex.invest.InvestorRelations.persistence.entity;

import lombok.*;

import javax.persistence.*;
import java.util.Date;

@Entity
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@Table(name = "investor_relations")
public class IREntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    Long irIdx;
    String year;            // 년도
    Long companyIdx;        // 회사 기본키
    Boolean isPassword;     // 패스워드 사용유/무
    String password;        // 패스워드
    String progress;        // 작성 %
    String cardColor;       // 카드 색상
    Date updateDate;        // 마지막 수정일
    Integer readCount;      // 조회수

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name="investor_relations_idx")
    BasicInfoEntity basicInfoEntity;                        // 기본정보

//    @OneToMany
//    @JoinColumn(name="history_idx")
//    List<HistoryEntity> histories;                              // 주요연혁
//
//    @OneToMany
//    @JoinColumn(name="major_personnel_idx")
//    List<MajorPersonnelEntity> majorPersonnelEntities;          // 주요인력
//
//    @OneToMany
//    @JoinColumn(name="shareholder_status_idx")
//    List<ShareHolderStatusEntity> shareHolderStatusEntities;    // 주주현황
//
//    @OneToOne
//    @JoinColumn(name="finance_idx")
//    FinanceEntity financeEntity;                                // 재무정보
//
//    @OneToOne
//    @JoinColumn(name="service_technology_idx")
//    ServiceTechnologyEntity serviceTechnologyEntity;            // 서비스 및 기술
}
