package com.illunex.invest.api.core.company.controller;

import com.illunex.invest.api.common.response.ResponseData;
import com.illunex.invest.api.common.response.ResponseList;
import com.illunex.invest.api.core.company.dto.CompanyDTO;
import com.illunex.invest.api.core.company.dto.CompanyWriteCheckDTO;
import com.illunex.invest.api.core.company.dto.LogoDTO;
import com.illunex.invest.api.core.company.request.CompanyRegisterRequest;
import io.swagger.annotations.*;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@Api(value = "회사 API")
@RequestMapping(value = "/company")
public interface CompanyController {
    @ApiOperation(value = "회사 전체 리스트 조회")
    @GetMapping({"/", ""})
    ResponseEntity<ResponseList> getAllList();

    @ApiOperation(value = "회사 신규 등록")
    @PostMapping("/register")
    ResponseEntity<ResponseData> registerCompany(@RequestBody CompanyRegisterRequest request);

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
    @GetMapping("/read/{id}")
    ResponseEntity<CompanyDTO> getCompany(@PathVariable Long id);

    @ApiOperation(value = "회사번호에 일치하는 회사 업데이트")
    @PostMapping("/form")
    ResponseEntity<ResponseData> updateCompany(@RequestBody CompanyDTO companyDTO);

    @ApiOperation(value = "로고 정보 가져오기")
    @GetMapping("/logo")
    ResponseEntity<LogoDTO> getLogo(@RequestParam("companyIdx") Long companyIdx);

    @ApiOperation(value = "로고 수정")
    @PostMapping("/logo")
    ResponseEntity<ResponseData> updateLogo(@RequestBody LogoDTO logoDTO);

    @ApiOperation(value = "사업자등록증, 기업정보 작성여부 체크")
    @GetMapping("/check")
    ResponseEntity<CompanyWriteCheckDTO> getCompanyWriteCheck(@RequestParam Long companyIdx);
}
