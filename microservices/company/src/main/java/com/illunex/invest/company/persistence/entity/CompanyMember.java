package com.illunex.invest.company.persistence.entity;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "company_member")
@Getter @Setter
public class CompanyMember {
    @Id
    Long companyMemberIdx;
    String name;
    String rank;
    String career;
    String imgUrl;
}
