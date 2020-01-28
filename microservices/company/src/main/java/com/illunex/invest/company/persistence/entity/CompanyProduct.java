package com.illunex.invest.company.persistence.entity;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class CompanyProduct {
    @Id
    Long companyProductIdx;
    String title;
    String description;
    String imgUrl;
    String viewMode;
}
