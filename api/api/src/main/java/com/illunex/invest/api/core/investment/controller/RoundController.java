package com.illunex.invest.api.core.investment.controller;

import com.illunex.invest.api.core.investment.dto.VQRoundDTO;
import io.swagger.annotations.Api;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

@Api(produces = "produces Value")
@RequestMapping(value = "/round")
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
    @PostMapping(value = "/answer")
    ResponseEntity<String> vqRoundAnswer(@RequestBody VQRoundDTO vqRoundDTO);
}
