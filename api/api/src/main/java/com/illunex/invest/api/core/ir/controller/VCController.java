package com.illunex.invest.api.core.ir.controller;

import com.illunex.invest.api.core.ir.dto.*;
import io.swagger.annotations.Api;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@Api(produces = "produces Value")
@RequestMapping(value = "/vc")
public interface VCController {
//    @ApiOperation(value = "a1331"
//            , notes = "Notes Test"
//            , response = irController.class
//            , responseContainer = "ResponseContainer Test"
//            , produces = "Produces Test")
//    @ApiResponses(value = {
//            @ApiResponse(code = 200, message = "Success"),
//            @ApiResponse(code = 400, message = "Bad Request")
//    })
    @GetMapping(value = "/")
    ResponseEntity<IRDTO> getIR(@RequestParam Long companyIdx);
    @GetMapping(value = "/basicInfo")
    ResponseEntity<BasicInfoDTO> getBasicInfo(@RequestParam Long companyIdx);
    @GetMapping(value = "/finance")
    ResponseEntity<FinanceDTO> getFinanceInfo(@RequestParam Long companyIdx);
    @GetMapping(value = "/history")
    ResponseEntity<ListDTO> getHistoryList(@RequestParam Long companyIdx);
    @GetMapping(value = "/member")
    ResponseEntity<ListDTO> getMemberList(@RequestParam Long companyIdx);
    @GetMapping(value = "/outcome")
    ResponseEntity<OutcomeDTO> getOutcomeInfo(@RequestParam Long companyIdx);
    @GetMapping(value = "/product")
    ResponseEntity<ProductDTO> getProductInfo(@RequestParam Long companyIdx);
    @GetMapping(value = "/shareholder")
    ResponseEntity<ListDTO> getShareholderList(@RequestParam Long companyIdx);
}
