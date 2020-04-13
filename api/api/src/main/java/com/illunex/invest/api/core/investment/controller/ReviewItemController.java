package com.illunex.invest.api.core.investment.controller;

import com.illunex.invest.api.core.investment.dto.*;
import io.swagger.annotations.Api;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@Api(produces = "produces Value")
@RequestMapping(value = "/review")
public interface ReviewItemController {
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
    ResponseEntity<ListDTO> getReviewItemList(@RequestParam Long companyIdx);
    @GetMapping(value = "/detail")
    ResponseEntity<ReviewItemTemplateDTO> getReviewItem(@RequestParam Long templateIdx);
    @PostMapping(value = "/edit")
    ResponseEntity<String> editReviewItem(@RequestBody ReviewItemTemplateDTO reviewItemTemplateDTO);
    @PostMapping(value = "/delete")
    ResponseEntity<String> deleteReviewItem(@RequestBody ReviewItemTemplateDTO reviewItemTemplateDTO);
}
