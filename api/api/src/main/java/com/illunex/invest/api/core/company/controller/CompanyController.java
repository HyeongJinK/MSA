package com.illunex.invest.api.core.company.controller;

import com.illunex.invest.api.core.company.dto.CompanyDTO;
import io.swagger.annotations.*;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

@Api(value = "회사 API")
@RequestMapping("/company")
public interface CompanyController {
    @ApiOperation(value = "회사 전체 리스트 조회")
    @GetMapping({"", "/list"})
    ResponseEntity<List<CompanyDTO>> getAllList();

    @ApiOperation(value = "유저 번호로 회사 조회")
    @ApiImplicitParams({
            @ApiImplicitParam(name = "userIdx"
                    , value = "유저번호"
                    , required = true
                    , dataType = "CompanyDTO"
                    , paramType = "path"
                    , defaultValue = ""
            )
    })
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "Success"),
            @ApiResponse(code = 400, message = "Bad Request")
    })
    @GetMapping("/user/{userIdx}")
    ResponseEntity<CompanyDTO> getCompany(@PathVariable Long userIdx);

    @ApiOperation(value = "회사 신규 등록")
    ResponseEntity<Long> insertCompany(@ModelAttribute CompanyDTO companyDTO);
}
