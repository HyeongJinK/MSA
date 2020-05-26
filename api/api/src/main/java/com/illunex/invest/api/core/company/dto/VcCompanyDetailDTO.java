package com.illunex.invest.api.core.company.dto;

import lombok.*;

@NoArgsConstructor
@AllArgsConstructor
@Getter @Setter
@Builder
public class VcCompanyDetailDTO {
    Long companyIdx;
    LogoDTO logo;
    String name;
    String companyType;
    String establishmentDate;
    String employeeCount;
    String business;
    String nation;
    String stocksList;
    String introduction;
    AddressDTO address;
    String sales;
    String year;
    String scale;
    VcProductDTO product;
}
