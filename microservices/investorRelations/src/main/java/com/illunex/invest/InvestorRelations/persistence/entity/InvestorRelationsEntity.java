package com.illunex.invest.InvestorRelations.persistence.entity;

import javax.persistence.*;
import java.util.Date;

@Entity
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

//    @OneToOne
//    CompanyInfo companyInfo;                        // 기본정보상
//    @OneToMany
//    List<History> histories;                        // 주요연혁
//    @OneToMany
//    List<MajorPersonnel> majorPersonnels;           // 주요인력
//    @OneToMany
//    List<ShareHolderStatus> shareHolderStatuses;    // 주주현황
//    @OneToOne
//    Finance finance;                                // 재무정보
//    @OneToOne
//    ServiceTechnology serviceTechnology;            // 서비스 및 기술
//    @OneToOne
//    InvestmentAttraction investmentAttraction;      // 발표자료
//    @OneToOne
//    VideoData videoData;                            // 동영상
}
