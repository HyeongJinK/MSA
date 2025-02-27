package com.illunex.invest.api.core.ir.controller;

import com.illunex.invest.api.core.ir.dto.BasicInfoDTO;
import com.illunex.invest.api.core.ir.dto.FinanceDTO;
import io.swagger.annotations.Api;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@Api(produces = "produces Value")
@RequestMapping(value = "/ir")
public interface FinanceController {
//    @ApiOperation(value = "a1331"
//            , notes = "Notes Test"
//            , response = irController.class
//            , responseContainer = "ResponseContainer Test"
//            , produces = "Produces Test")
//    @ApiResponses(value = {
//            @ApiResponse(code = 200, message = "Success"),
//            @ApiResponse(code = 400, message = "Bad Request")
//    })
    @GetMapping(value = "/finance")
    ResponseEntity<FinanceDTO> getFinanceInfo(@RequestParam Long irIdx);
    @PostMapping(value = "/finance")
    ResponseEntity<String> editFinanceInfo(@RequestBody FinanceDTO financeDTO);
}
