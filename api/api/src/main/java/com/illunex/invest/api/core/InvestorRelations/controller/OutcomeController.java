package com.illunex.invest.api.core.InvestorRelations.controller;

import com.illunex.invest.api.core.InvestorRelations.dto.OutcomeDTO;
import com.illunex.invest.api.core.InvestorRelations.dto.ProductDTO;
import io.swagger.annotations.Api;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;

@Api(produces = "produces Value")
public interface OutcomeController {
//    @ApiOperation(value = "a1331"
//            , notes = "Notes Test"
//            , response = InvestorRelationsController.class
//            , responseContainer = "ResponseContainer Test"
//            , produces = "Produces Test")
//    @ApiResponses(value = {
//            @ApiResponse(code = 200, message = "Success"),
//            @ApiResponse(code = 400, message = "Bad Request")
//    })

    ResponseEntity<OutcomeDTO> getOutcomeInfo(@RequestParam Long irIdx);

    ResponseEntity<OutcomeDTO> editOutcomeInfo(@RequestBody OutcomeDTO outcomeDTO);
}
