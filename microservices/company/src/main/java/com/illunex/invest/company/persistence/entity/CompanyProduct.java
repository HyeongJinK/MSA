package com.illunex.invest.company.persistence.entity;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name= "company_Product")
@Getter @Setter
public class CompanyProduct {
    @Id
    Long companyProductIdx;
    String title;
    String description;
    String imgUrl;
    String viewMode;
}
