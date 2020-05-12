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
@ToString(of = {"companyIdx"})
public class Company {
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    Long companyIdx;
    LocalDateTime updateDate;   // 마지막 수정일
    @Embedded
    Logo logo;
    String name;                // 기업명
    String businessNumber;      // 사업자 등록번호
    String ceo;                 // 대표
    String companyType;         // 산업분야
    String establishmentDate;   // 설립일
    String employeeCount;       // 직원수
    String business;            // 기업구분
    String nation;              // 국가
    String stocksList;          // 상장구분
    @Embedded
    Address address;
    String homePage;            // 홈페이지
    @Column(length=4000)
    String description;         // 기업개요
    @OneToMany(fetch = FetchType.LAZY, cascade = CascadeType.ALL)       // 매출
    List<Sales> sales = new ArrayList<>();
    @Embedded
    MainProduct mainProduct;
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
