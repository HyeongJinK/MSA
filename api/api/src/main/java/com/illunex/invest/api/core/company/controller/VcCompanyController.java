package com.illunex.invest.api.core.company.controller;

import com.illunex.invest.api.core.company.dto.VcCompanyDetailDTO;
import com.illunex.invest.api.core.company.dto.VcCompanyListDTO;
import com.illunex.invest.api.core.company.dto.VcFavoriteCompanyDTO;
import com.illunex.invest.api.core.company.dto.VcFavoriteCompanyListDTO;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.web.bind.annotation.*;

@Api(value = "회사 API")
@RequestMapping(value = "/vc")
public interface VcCompanyController {
    @ApiOperation(value = "VC 회사 리스트 조회")
    @GetMapping("/company/list")
    VcCompanyListDTO getVcCompanyList();

    @ApiOperation(value = "VC 회사 조회")
    @GetMapping("/company")
    VcCompanyDetailDTO getVcCompanyDetail(@RequestParam Long companyIdx);

    @ApiOperation(value = "VC 관심기업 리스트 조회")
    @GetMapping("/favorite/list")
    VcFavoriteCompanyListDTO getVcFavoriteCompanyList(@RequestParam Long userIdx);

    @ApiOperation(value = "VC 관심기업 조회")
    @GetMapping(value = "/favorite")
    VcFavoriteCompanyDTO getFavoriteCompany(@RequestParam Long companyIdx);

    @ApiOperation(value = "VC 관심기업 등록")
    @PostMapping(value = "/favorite/set")
    String setFavoriteCompany(@RequestBody VcFavoriteCompanyDTO vcFavoriteCompanyDTO);

}
