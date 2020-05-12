package com.illunex.invest.api.core.company.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.ArrayList;
import java.util.List;

@Getter @Setter
@NoArgsConstructor
@AllArgsConstructor
public class MainProductDTO {
    String mainProductName;     // 주요제품 - 제품명
    String introduction;        // 주요제품 - 제품 한줄 소개출
    List<MainProductLineDTO> mainProductLines = new ArrayList<>();     // 주요제품군
}
