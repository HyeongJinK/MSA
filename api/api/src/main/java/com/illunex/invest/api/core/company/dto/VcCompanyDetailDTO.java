package com.illunex.invest.api.core.company.dto;

import lombok.*;

import java.util.List;

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
    List<SalesDTO> sales;
    String scale;
    VcProductDTO product;
}
