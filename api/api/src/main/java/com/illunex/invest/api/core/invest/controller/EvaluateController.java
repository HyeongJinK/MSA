package com.illunex.invest.api.core.invest.controller;

import com.illunex.invest.api.core.invest.dto.EvaluateDTO;
import com.illunex.invest.api.core.invest.dto.EvaluateListDTO;
import com.illunex.invest.api.core.invest.dto.JudgeDTO;
import com.illunex.invest.api.core.invest.dto.ReviewItemDTO;
import io.swagger.annotations.Api;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

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
    @GetMapping(value = "/")
    ResponseEntity<String> setEvaluate(@RequestParam Long companyIdx, @RequestParam Long vcCompanyIdx);
    @GetMapping(value = "/list")
    ResponseEntity<EvaluateListDTO> getEvaluateList(@RequestParam Long companyIdx);
    @GetMapping(value = "/detail")
    ResponseEntity<EvaluateDTO> getEvaluate(@RequestParam Long evaluateIdx);
    @PostMapping(value = "/edit")
    ResponseEntity<String> editEvaluate(@RequestBody EvaluateDTO evaluateDTO);
    @PostMapping(value = "/judge")
    ResponseEntity<String> editJudge(@RequestBody JudgeDTO judgeDTO);
    @PostMapping(value = "/review")
    ResponseEntity<String> editReviewItem(@RequestBody ReviewItemDTO reviewItemDTO);
}
