package com.illunex.invest.api.core.invest.controller;

import com.illunex.invest.api.core.invest.dto.EvaluateDTO;
import com.illunex.invest.api.core.invest.dto.EvaluateListDTO;
import io.swagger.annotations.Api;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

@Api(produces = "produces Value")
@RequestMapping(value = "/evaluate")
public interface EvaluateController {
//    @ApiOperation(value = "a1331"
//            , notes = "Notes Test"
//            , response = irController.class
//            , responseContainer = "ResponseContainer Test"
//            , produces = "Produces Test")
//    @ApiResponses(value = {
//            @ApiResponse(code = 200, message = "Success"),
//            @ApiResponse(code = 400, message = "Bad Request")
//    })
    @GetMapping(value = "/list")
    ResponseEntity<EvaluateListDTO> getEvaluateList(@RequestParam Long companyIdx);
    @GetMapping(value = "/detail")
    ResponseEntity<EvaluateDTO> getEvaluate(@RequestParam Long evaluateIdx);
}
