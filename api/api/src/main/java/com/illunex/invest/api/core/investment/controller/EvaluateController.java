package com.illunex.invest.api.core.investment.controller;

import com.illunex.invest.api.core.investment.dto.*;
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
    @PostMapping(value = "/")
    ResponseEntity<String> setEvaluate(@RequestBody EvaluateDTO evaluateDTO);
    @GetMapping(value = "/list")
    ResponseEntity<EvaluateListDTO> getEvaluateList(@RequestParam Long companyIdx);
    @GetMapping(value = "/list/state")
    ResponseEntity<EvaluateStateListDTO> getEvaluateStateList(@RequestParam Long companyIdx);
    @GetMapping(value = "/list/card")
    ResponseEntity<EvaluateCardListDTO> getEvaluateCardList(@RequestParam Long companyIdx);
    @GetMapping(value = "/list/history")
    ResponseEntity<EvaluateListDTO> getEvaluateHistory(@RequestParam Long companyIdx);
    @GetMapping(value = "/detail")
    ResponseEntity<EvaluateDTO> getEvaluate(@RequestParam Long evaluateIdx);
    @PostMapping(value = "/edit")
    ResponseEntity<String> editEvaluate(@RequestBody EvaluateDTO evaluateDTO);
    @PostMapping(value = "/comment")
    ResponseEntity<String> editComment(@RequestBody EvaluateCommentDTO evaluateCommentDTO);
    @PostMapping(value = "/delete")
    ResponseEntity<String> deleteEvaluate(@RequestBody EvaluateDTO evaluateDTO);
    @PostMapping(value = "/review")
    ResponseEntity<String> review(@RequestBody EvaluateReviewDTO evaluateReviewDTO);
    @PostMapping(value = "/confirm")
    ResponseEntity<String> confirmEvaluate(@RequestBody EvaluateDTO evaluateDTO);
    @PostMapping(value = "/reject")
    ResponseEntity<String> rejectEvaluate(@RequestBody EvaluateDTO evaluateDTO);
}
