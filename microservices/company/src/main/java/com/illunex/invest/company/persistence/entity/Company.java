package com.illunex.invest.company.persistence.entity;

import javax.persistence.*;
import java.util.Date;
import java.util.List;

@Entity
public class Company {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    Long companyIdx;
    Long userIdx;
    String logo;                // 로고
    String name;                // 이름
    String businessNumber;      // 사업자 등록번호
    String companyType;         // 산업분야    // todo enum 혹은 따로 DB 구성 여부
    Date establishmentDate;     // 설립일
    String employeeCount;       // 직원수
    String business;            // 기업구분  todo 스타트업, 중소기업, 중견기업, 대기업..... enum 사용 여부 확인
    String nation;              // 국가 todo 국가 타입 enum 고려
    String stocksList;          // 상장구분 todo 미상장, 코스닥, 코스피, enum
    String zipCode;             // 우편번호
    String address;             // 주소
    String addressDetail;       // 상세주소
    String mainProductLine;     // 주요제품군
    String description;         // 기업개요
    String homePage;            // 홈페이지

    @OneToMany
    List<CompanyProduct> companyProducts;

    @OneToMany
    List<CompanyMember> companyMembers;
}
