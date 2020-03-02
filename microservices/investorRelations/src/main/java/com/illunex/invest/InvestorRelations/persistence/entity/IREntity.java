package com.illunex.invest.InvestorRelations.persistence.entity;

import lombok.*;

import javax.persistence.*;
import java.util.Date;
import java.util.List;

@Entity
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@Table(name = "ir")
public class IREntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    Long idx;
    String year;            // 년도
    Long companyIdx;        // 회사 기본키
    Boolean isPassword;     // 패스워드 사용유/무
    String password;        // 패스워드
    String progress;        // 작성 %
    String cardColor;       // 카드 색상
    Date updateDate;        // 마지막 수정일
    Integer readCount;      // 조회수

    @OneToOne(cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    @JoinColumn(name="basic_info_idx")
    BasicInfoEntity basicInfo;                              // 기본정보

    @OneToMany(mappedBy = "ir", cascade = CascadeType.ALL)
    List<HistoryEntity> history;                            // 주요연혁

    @OneToMany(mappedBy = "ir", cascade = CascadeType.ALL)
    List<MemberEntity> member;                              // 주요인력

    @OneToMany(mappedBy = "ir", cascade = CascadeType.ALL)
    List<ShareholderEntity> shareholder;                    // 주주현황

    @OneToOne(cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    @JoinColumn(name="finance_idx")
    FinanceEntity finance;                                  // 재무현황

    @OneToOne(cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    @JoinColumn(name="product_idx")
    ProductEntity product;                                  // 제품,기술,시장

    @OneToOne(cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    @JoinColumn(name="outcome_idx")
    OutcomeEntity outcome;                                  // 성과 및 계획

}
