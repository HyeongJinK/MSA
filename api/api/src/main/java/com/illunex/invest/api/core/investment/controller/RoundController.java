package com.illunex.invest.api.core.investment.controller;

import com.illunex.invest.api.core.investment.dto.EditDTO;
import com.illunex.invest.api.core.investment.dto.JudgeDTO;
import com.illunex.invest.api.core.investment.dto.ListDTO;
import io.swagger.annotations.Api;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@Api(produces = "produces Value")
@RequestMapping(value = "/judge")
public interface RoundController {
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
    ResponseEntity<ListDTO> getJudgeList(@RequestParam Long companyIdx);
    @GetMapping(value = "/detail")
    ResponseEntity<JudgeDTO> getJudge(@RequestParam Long judgeIdx);
    @PostMapping(value = "/edit")
    ResponseEntity<String> editJudge(@RequestBody EditDTO editDTO);
    @PostMapping(value = "/delete")
    ResponseEntity<String> deleteJudge(@RequestBody JudgeDTO judgeDTO);
}
