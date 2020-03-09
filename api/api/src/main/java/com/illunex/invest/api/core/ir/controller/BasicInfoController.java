package com.illunex.invest.api.core.ir.controller;

import com.illunex.invest.api.core.ir.dto.BasicInfoDTO;
import io.swagger.annotations.Api;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@Api(produces = "produces Value")
@RequestMapping(value = "/ir")
public interface BasicInfoController {
//    @ApiOperation(value = "a1331"
//            , notes = "Notes Test"
//            , response = irController.class
//            , responseContainer = "ResponseContainer Test"
//            , produces = "Produces Test")
//    @ApiResponses(value = {
//            @ApiResponse(code = 200, message = "Success"),
//            @ApiResponse(code = 400, message = "Bad Request")
//    })
    @GetMapping(value = "/basicInfo")
    ResponseEntity<BasicInfoDTO> getBasicInfo(@RequestParam Long irIdx);
    @PostMapping(value = "/basicInfo")
    ResponseEntity<String> editBasicInfo(@RequestBody BasicInfoDTO basicInfoDTO);
}
