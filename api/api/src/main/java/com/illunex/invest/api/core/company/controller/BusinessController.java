package com.illunex.invest.api.core.company.controller;

import com.illunex.invest.api.core.company.dto.BusinessDTO;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

@Api(value = "사업자번호 인증 API")
@RequestMapping(value = "/business")
public interface BusinessController {
    @ApiOperation(value = "등록증 불러오기")
    @GetMapping(value = "/{companyId}")
    ResponseEntity<BusinessDTO> getBusiness(@PathVariable Long companyId);
    @ApiOperation(value = "사업자 등록 인증 요청 및 수정")
    ResponseEntity<BusinessDTO> editBusiness(@RequestBody BusinessDTO businessDTO);
}
