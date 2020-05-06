package com.illunex.invest.api.core.company.dto;

import lombok.*;

@NoArgsConstructor
@AllArgsConstructor
@Getter @Setter
@Builder
public class VcCompanyDetailDTO {
    Long companyIdx;
    String logo;
    String name;
    String companyType;
    String establishmentDate;
    String employeeCount;
    String business;
    String nation;
    String stocksList;
    String introduction;
    String address;
    String addressDetail;
    String sales;
    String scale;
    VcProductDTO product;
}
