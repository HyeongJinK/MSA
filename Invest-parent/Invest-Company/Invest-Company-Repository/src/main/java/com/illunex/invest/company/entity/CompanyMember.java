package com.illunex.invest.company.entity;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class CompanyMember {
    @Id
    Long companyMemberIdx;
    String name;
    String rank;
    String career;
    String imgUrl;
}
