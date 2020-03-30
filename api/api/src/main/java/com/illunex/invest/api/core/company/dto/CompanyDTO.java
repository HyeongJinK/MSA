package com.illunex.invest.api.core.company.dto;

import io.swagger.annotations.ApiModelProperty;
import lombok.*;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

@NoArgsConstructor
@AllArgsConstructor
@Getter @Setter
@Builder
@ToString(of = {"companyIdx", "logo", "name", "businessNumber"
        , "companyType", "establishmentDate", "employeeCount", "business", "nation"
        , "stocksList", "zipCode", "address", "addressDetail"
        , "description", "homePage"})
public class CompanyDTO {
    Long companyIdx;
    @ApiModelProperty(value="로고", name="logo", required=true)
    String logo;
    @ApiModelProperty(value="회사 이름", name="name", required=true)
    String name;
    @ApiModelProperty(value="사업자 등록번호", name="businessNumber", required=true)
    String businessNumber;
    @ApiModelProperty(value="산업분야", name="companyType", required=false)
    String companyType;
    @ApiModelProperty(value="설립일", name="establishmentDate", required=false)
    LocalDateTime establishmentDate;
    @ApiModelProperty(value="직원수", name="employeeCount", required=false)
    String employeeCount;
    @ApiModelProperty(value="기업구분", name="business", required=false)
    String business;
    @ApiModelProperty(value="국가", name="nation", required=false)
    String nation;
    @ApiModelProperty(value="상장구분", name="stocksList", required=false)
    String stocksList;
    @ApiModelProperty(value="우편번호", name="zipCode", required=false)
    String zipCode;
    @ApiModelProperty(value="주소", name="address", required=false)
    String address;
    @ApiModelProperty(value="상세주소", name="addressDetail", required=false)
    String addressDetail;
    @ApiModelProperty(value="기업개요", name="description", required=false)
    String description;
    @ApiModelProperty(value="홈페이지", name="homePage", required=false)
    String homePage;

    @ApiModelProperty(value="주요제품군", name="companyProducts", required=false)
    List<MainProductLineDTO> mainProductLines = new ArrayList<>();
}
