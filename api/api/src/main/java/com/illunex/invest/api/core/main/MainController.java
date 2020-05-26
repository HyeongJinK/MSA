package com.illunex.invest.api.core.main;

import com.illunex.invest.api.core.main.dto.WriteCheckDTO;
import io.swagger.annotations.Api;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Api(produces = "produces Value")
@RequestMapping(value = "/main")
public interface MainController {
//    @ApiOperation(value = "a1331"
//            , notes = "Notes Test"
//            , response = irController.class
//            , responseContainer = "ResponseContainer Test"
//            , produces = "Produces Test")
//    @ApiResponses(value = {
//            @ApiResponse(code = 200, message = "Success"),
//            @ApiResponse(code = 400, message = "Bad Request")
//    })
    @GetMapping(value = "/check")
    ResponseEntity<WriteCheckDTO> getWriteCheck();
}
