package com.illunex.invest.company.persistence.entity;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
@Getter @Setter
public class CompanyMemberEntity {
    @Id
    Long companyMemberIdx;
    String name;
    String rank;
    String career;
    String imgUrl;
}
