package com.illunex.invest.api.core.company.dto;

import lombok.*;

import java.time.LocalDateTime;
import java.util.List;

@NoArgsConstructor
@AllArgsConstructor
@Getter @Setter
@Builder
public class VcCompanyDTO {
    Long companyIdx;
    String logo;
    String name;
    String businessNumber;
    String companyType;
    String establishmentDate;
    String employeeCount;
    String business;
    String nation;
    String stocksList;
    String zipCode;
    String address;
    String addressDetail;
    String description;
    String homePage;
    String location;
    String sales;
    String scale;
    String introduction;
    LocalDateTime updateDate;

    List<MainProductLineDTO> mainProductLines;
    List<VcProductDTO> products;
}
