package com.illunex.invest.api.core.ir.controller;

import com.illunex.invest.api.core.ir.dto.IRDTO;
import com.illunex.invest.api.core.ir.dto.ListDTO;
import com.illunex.invest.api.core.ir.dto.PasswordDTO;
import com.illunex.invest.api.core.ir.dto.SignatureDTO;
import io.swagger.annotations.Api;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@Api(produces = "produces Value")
@RequestMapping(value = "/ir")
public interface IRController {
//    @ApiOperation(value = "a1331"
//            , notes = "Notes Test"
//            , response = irController.class
//            , responseContainer = "ResponseContainer Test"
//            , produces = "Produces Test")
//    @ApiResponses(value = {
//            @ApiResponse(code = 200, message = "Success"),
//            @ApiResponse(code = 400, message = "Bad Request")
//    })
    @GetMapping(value = "/")
    ResponseEntity<IRDTO> getIR(@RequestParam Long companyIdx, @RequestParam String year);
    @GetMapping(value = "/list")
    ResponseEntity<ListDTO> getIRList(@RequestParam Long companyIdx);
    @PostMapping(value = "/color")
    ResponseEntity<String> changeCardColor(@RequestBody IRDTO irdto);
    @PostMapping(value = "/signature")
    ResponseEntity<String> changeSignature(@RequestBody SignatureDTO signatureDTO);
    @PostMapping(value = "/pw/set")
    ResponseEntity<String> setPassword(@RequestBody PasswordDTO passwordDTO);
    @PostMapping(value = "/pw/reset")
    ResponseEntity<String> resetPassword(@RequestBody PasswordDTO passwordDTO);
    @PostMapping(value = "/pw/confirm")
    ResponseEntity<String> confirmPassword(@RequestBody PasswordDTO passwordDTO);
    @PostMapping(value = "/pw/change")
    ResponseEntity<String> changePassword(@RequestBody PasswordDTO passwordDTO);

}
