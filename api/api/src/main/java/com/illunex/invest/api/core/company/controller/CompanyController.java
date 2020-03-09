package com.illunex.invest.api.core.company.controller;

import com.illunex.invest.api.core.company.dto.CompanyDTO;
import com.illunex.invest.api.core.company.model.CompanyRegisterRequest;
import io.swagger.annotations.*;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Api(value = "회사 API")
@RequestMapping(value = "/company")
public interface CompanyController {
    @ApiOperation(value = "회사 전체 리스트 조회")
    @GetMapping({"/", ""})
    ResponseEntity<List<CompanyDTO>> getAllList();

    @ApiOperation(value = "회사 신규 등록")
    @PostMapping("/register")
    ResponseEntity<Long> registerCompany(@RequestBody CompanyRegisterRequest request);

    @ApiOperation(value = "회사번호로 회사 조회")
    @ApiImplicitParams({
            @ApiImplicitParam(name = "id"
                    , value = "회사번호"
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
    @GetMapping("/read/{companyId}")
    ResponseEntity<CompanyDTO> getCompany(@PathVariable Long id);

    @ApiOperation(value = "회사번호에 일치하는 회사 업데이트")
    @PostMapping("/form")
    ResponseEntity<CompanyDTO> updateCompany(@RequestBody CompanyDTO companyDTO);
}
