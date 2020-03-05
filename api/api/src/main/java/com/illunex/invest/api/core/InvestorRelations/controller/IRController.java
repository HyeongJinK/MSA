package com.illunex.invest.api.core.InvestorRelations.controller;

import com.illunex.invest.api.core.InvestorRelations.dto.BasicInfoDTO;
import com.illunex.invest.api.core.InvestorRelations.dto.IRDTO;
import com.illunex.invest.api.core.InvestorRelations.dto.PasswordDTO;
import io.swagger.annotations.Api;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

@Api(produces = "produces Value")
public interface IRController {
//    @ApiOperation(value = "a1331"
//            , notes = "Notes Test"
//            , response = InvestorRelationsController.class
//            , responseContainer = "ResponseContainer Test"
//            , produces = "Produces Test")
//    @ApiResponses(value = {
//            @ApiResponse(code = 200, message = "Success"),
//            @ApiResponse(code = 400, message = "Bad Request")
//    })

    ResponseEntity<List<IRDTO>> getIRList(@RequestParam Long irIdx);

    ResponseEntity<IRDTO> changeCardColor(@RequestParam Long irIdx, @RequestParam String color);

    ResponseEntity<String> setPassword(@RequestBody PasswordDTO passwordDTO);

    ResponseEntity<String> confirmPassword(@RequestBody PasswordDTO passwordDTO);

    ResponseEntity<String> changePassword(@RequestBody PasswordDTO passwordDTO);

    ResponseEntity<String> resetPassword(@RequestParam Long irIdx);

}
