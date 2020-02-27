package com.illunex.invest.api.composite.startup.controller;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;
import org.springframework.web.bind.annotation.GetMapping;

@Api(produces = "produces Value")
public interface TemplateController {
    @ApiOperation(value = "Value Test"
            , notes = "Notes Test"
            , response = TemplateController.class
            , responseContainer = "ResponseContainer Test"
            , produces = "Produces Test")
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "Success"),
            @ApiResponse(code = 400, message = "Bad Request")
    })
    @GetMapping("/test")
    public String templateApi1();
}
