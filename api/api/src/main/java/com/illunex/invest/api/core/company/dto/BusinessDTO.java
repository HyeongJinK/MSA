package com.illunex.invest.api.core.company.dto;

import com.illunex.invest.api.core.company.enumable.BusinessStatus;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDateTime;

@AllArgsConstructor
@NoArgsConstructor
@Getter @Setter
public class BusinessDTO {
    Long id;
    CompanyIdDTO company;
    String imgUrl;
    LocalDateTime regDate;
    BusinessStatus status;
}
