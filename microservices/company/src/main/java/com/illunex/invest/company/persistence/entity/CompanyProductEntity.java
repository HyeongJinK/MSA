package com.illunex.invest.company.persistence.entity;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
@Getter @Setter
public class CompanyProductEntity {
    @Id
    Long companyProductIdx;
    String title;
    String description;
    String imgUrl;
    String viewMode;
}
