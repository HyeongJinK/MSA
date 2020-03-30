package com.illunex.invest.company.persistence.entity;

import lombok.*;

import javax.persistence.*;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "company")
@Getter @Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
@ToString(of = {"companyIdx", "logo", "name", "businessNumber"
, "companyType", "establishmentDate", "employeeCount", "business", "nation"
, "stocksList", "zipCode", "address", "addressDetail", "description", "homePage"})
public class Company {
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    Long companyIdx;
    String logo;                // 로고
    String name;                // 이름
    String businessNumber;      // 사업자 등록번호
    String companyType;         // 산업분야
    LocalDateTime establishmentDate;     // 설립일
    String employeeCount;       // 직원수
    String business;            // 기업구분
    String nation;              // 국가
    String stocksList;          // 상장구분
    String zipCode;             // 우편번호
    String address;             // 주소
    String addressDetail;       // 상세주소
    String description;         // 기업개요
    String homePage;            // 홈페이지

    @OneToMany(fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    List<MainProductLine> mainProductLines = new ArrayList<>();     // 주요제품군

    @OneToMany(fetch = FetchType.LAZY, cascade = CascadeType.DETACH, mappedBy = "company")
    List<Product> products = new ArrayList<>();

    @OneToMany(fetch = FetchType.LAZY, cascade = CascadeType.DETACH, mappedBy = "company")
    List<Member> members = new ArrayList<>();

    @OneToMany(fetch = FetchType.LAZY, cascade = CascadeType.DETACH, mappedBy = "company")
    List<Plugin> plugins = new ArrayList<>();

    public Company(Long companyIdx) {
        this.companyIdx = companyIdx;
    }
}
