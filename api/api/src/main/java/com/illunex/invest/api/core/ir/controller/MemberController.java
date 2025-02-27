package com.illunex.invest.api.core.ir.controller;

import com.illunex.invest.api.common.response.ResponseData;
import com.illunex.invest.api.core.ir.dto.EditDTO;
import com.illunex.invest.api.core.ir.dto.HistoryDTO;
import com.illunex.invest.api.core.ir.dto.ListDTO;
import com.illunex.invest.api.core.ir.dto.MemberDTO;
import io.swagger.annotations.Api;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.util.List;

@Api(produces = "produces Value")
@RequestMapping(value = "/ir")
public interface MemberController {
//    @ApiOperation(value = "a1331"
//            , notes = "Notes Test"
//            , response = irController.class
//            , responseContainer = "ResponseContainer Test"
//            , produces = "Produces Test")
//    @ApiResponses(value = {
//            @ApiResponse(code = 200, message = "Success"),
//            @ApiResponse(code = 400, message = "Bad Request")
//    })
    @GetMapping(value = "/member")
    ResponseEntity<ListDTO> getMemberList(@RequestParam Long irIdx);
    @PostMapping(value = "/member")
    ResponseEntity<String> editMemberList(@RequestBody EditDTO editDTO);
}
