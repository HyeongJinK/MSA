package com.illunex.invest.api.core.ir.controller;

import com.illunex.invest.api.core.ir.dto.HistoryDTO;
import com.illunex.invest.api.core.ir.dto.EditDTO;
import com.illunex.invest.api.core.ir.dto.ListDTO;
import io.swagger.annotations.Api;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Api(produces = "produces Value")
@RequestMapping(value = "/ir")
public interface HistoryController {
//    @ApiOperation(value = "a1331"
//            , notes = "Notes Test"
//            , response = irController.class
//            , responseContainer = "ResponseContainer Test"
//            , produces = "Produces Test")
//    @ApiResponses(value = {
//            @ApiResponse(code = 200, message = "Success"),
//            @ApiResponse(code = 400, message = "Bad Request")
//    })
    @GetMapping(value = "/history")
    ResponseEntity<ListDTO> getHistoryList(@RequestParam Long irIdx);
    @PostMapping(value = "/history")
    ResponseEntity<String> editHistoryList(@RequestBody EditDTO editDTO);
}
