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
@Table(name = "investor_relations", uniqueConstraints = { @UniqueConstraint(columnNames = {"year", "companyIdx"})})
public class InvestorRelationsEntity {
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
//
//    @OneToOne
//    @JoinColumn(name="company_info_ci_idx")
//    CompanyInfoEntity companyInfoEntity;                        // 기본정보
//    @OneToMany
//    List<HistoryEntity> histories;                              // 주요연혁
//    @OneToMany
//    List<MajorPersonnelEntity> majorPersonnelEntities;          // 주요인력
//    @OneToMany
//    List<ShareHolderStatusEntity> shareHolderStatusEntities;    // 주주현황
//    @OneToOne
//    FinanceEntity financeEntity;                                // 재무정보
//    @OneToOne
//    ServiceTechnologyEntity serviceTechnologyEntity;            // 서비스 및 기술
//    @OneToOne
//    VideoDataEntity videoDataEntity;                            // 동영상
}
