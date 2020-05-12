package com.illunex.invest.api.core.company.dto;

import lombok.*;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

@NoArgsConstructor
@AllArgsConstructor
@Getter @Setter
@Builder
public class VcCompanyDTO {
    Long companyIdx;
    LogoDTO logo;
    String name;
    String businessNumber;
    String companyType;
    String establishmentDate;
    String employeeCount;
    String business;
    String nation;
    String stocksList;
    AddressDTO address;
    String description;
    String homePage;
    String location;
    List<SalesDTO> sales = new ArrayList<>();
    String scale;
    String introduction;
    LocalDateTime updateDate;

    MainProductDTO mainProduct;
    List<VcProductDTO> products;
}
