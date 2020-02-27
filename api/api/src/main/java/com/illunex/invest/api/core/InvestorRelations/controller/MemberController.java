package com.illunex.invest.api.core.InvestorRelations.controller;

import com.illunex.invest.api.core.InvestorRelations.dto.HistoryDTO;
import com.illunex.invest.api.core.InvestorRelations.dto.MemberDTO;
import io.swagger.annotations.Api;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

@Api(produces = "produces Value")
public interface MemberController {
//    @ApiOperation(value = "a1331"
//            , notes = "Notes Test"
//            , response = InvestorRelationsController.class
//            , responseContainer = "ResponseContainer Test"
//            , produces = "Produces Test")
//    @ApiResponses(value = {
//            @ApiResponse(code = 200, message = "Success"),
//            @ApiResponse(code = 400, message = "Bad Request")
//    })

    ResponseEntity<List<MemberDTO>> getMemberList(@RequestParam Long irIdx);

    ResponseEntity<List<MemberDTO>> editMemberList(@RequestBody List<MemberDTO> memberDTOList);
}
