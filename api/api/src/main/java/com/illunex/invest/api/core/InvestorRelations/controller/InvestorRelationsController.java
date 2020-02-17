package com.illunex.invest.api.core.InvestorRelations.controller;

import com.illunex.invest.api.core.InvestorRelations.dto.InvestorRelationsDTO;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.List;

@Api(produces = "produces Value")
public interface InvestorRelationsController {
    @ApiOperation(value = "a1331"
            , notes = "Notes Test"
            , response = InvestorRelationsController.class
            , responseContainer = "ResponseContainer Test"
            , produces = "Produces Test")
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "Success"),
            @ApiResponse(code = 400, message = "Bad Request")
    })
    @GetMapping("")
    public List<InvestorRelationsDTO> getInvestorRelationsList();
}
