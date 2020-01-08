package com.illunex.invest.company.entity;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import java.util.List;

@Entity
public class Company {
    @Id
    Long companyIdx;
    Long userIdx;
    String name;
    String corporateNumber;

    @OneToMany
    List<CompanyProduct> companyProducts;

    @OneToMany
    List<CompanyMember> companyMembers;
}
