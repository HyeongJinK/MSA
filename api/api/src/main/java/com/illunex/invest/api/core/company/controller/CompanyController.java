package com.illunex.invest.api.core.company.controller;

import com.illunex.invest.api.core.company.dto.CompanyDTO;
import io.swagger.annotations.*;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

@Api(value = "회사 API")
@RequestMapping("/company")
public interface CompanyController {
    @ApiOperation(value = "회사 리스트 조회")
    @GetMapping({"", "/list"})
    List<CompanyDTO> getList();

    @ApiOperation(value = "유저 번호로 회사 조회")
    @ApiImplicitParams({
            @ApiImplicitParam(name = "userIdx"
                    , value = "유저번호"
                    , required = true
                    , dataType = "String"
                    , paramType = "path"
                    , defaultValue = ""
            )
    })
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "Success"),
            @ApiResponse(code = 400, message = "Bad Request")
    })
    @GetMapping("/{userIdx}")
    CompanyController getCompany(@PathVariable Long userIdx);
}
