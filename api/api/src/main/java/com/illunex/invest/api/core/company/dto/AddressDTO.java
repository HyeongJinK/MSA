package com.illunex.invest.api.core.company.dto;

import io.swagger.annotations.ApiModelProperty;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter @Setter
@NoArgsConstructor
@AllArgsConstructor
public class AddressDTO {
    @ApiModelProperty(value="우편번호", name="zipCode", required=false)
    String zipCode;
    @ApiModelProperty(value="주소", name="address", required=false)
    String address;
    @ApiModelProperty(value="상세주소", name="addressDetail", required=false)
    String addressDetail;
}
