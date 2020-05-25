package com.illunex.invest.api.core.company.dto;

import io.swagger.annotations.ApiModelProperty;
import lombok.*;

import java.time.LocalDateTime;

@NoArgsConstructor
@AllArgsConstructor
@Getter @Setter
@Builder
@ToString(of = {"companyIdx"})
public class CompanyDTO {
    Long companyIdx;
    LocalDateTime updateDate;
    @ApiModelProperty(value="로고", name="logo", required=true)
    LogoDTO logo;
    @ApiModelProperty(value="회사 이름", name="name", required=true)
    String name;
    @ApiModelProperty(value="사업자 등록번호", name="businessNumber", required=true)
    String businessNumber;
    @ApiModelProperty(value="대표", name="ceo", required=true)
    String ceo;
    @ApiModelProperty(value="산업분야", name="companyType", required=false)
    String companyType;
    @ApiModelProperty(value="설립일", name="establishmentDate", required=false)
    String establishmentDate;
    @ApiModelProperty(value="직원수", name="employeeCount", required=false)
    String employeeCount;
    @ApiModelProperty(value="기업구분", name="business", required=false)
    String business;
    @ApiModelProperty(value="매출", name="business", required=false)
    String sales;
    @ApiModelProperty(value="매출 기준년도", name="business", required=false)
    String year;
    @ApiModelProperty(value="국가", name="nation", required=false)
    String nation;
    @ApiModelProperty(value="상장구분", name="stocksList", required=false)
    String stocksList;
    @ApiModelProperty(value="기본정보 작성 상태", name="stocksList", required=false)
    String status;
    @ApiModelProperty(value="죽", name="address", required=false)
    AddressDTO address;
    @ApiModelProperty(value="홈페이지", name="homePage", required=false)
    String homePage;
    @ApiModelProperty(value="기업개요", name="description", required=false)
    String description;
    @ApiModelProperty(value="주요상품", name="mainProduct", required=false)
    MainProductDTO mainProduct;
}
