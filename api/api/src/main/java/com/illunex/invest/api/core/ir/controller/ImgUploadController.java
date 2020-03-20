package com.illunex.invest.api.core.ir.controller;

import com.illunex.invest.api.common.response.ResponseData;
import com.illunex.invest.api.core.communication.dto.MultiFileDeleteDTO;
import com.illunex.invest.api.core.ir.dto.ImgDTO;
import io.swagger.annotations.Api;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

@Api(produces = "produces Value")
@RequestMapping(value = "/ir")
public interface ImgUploadController {
//    @ApiOperation(value = "a1331"
//            , notes = "Notes Test"
//            , response = irController.class
//            , responseContainer = "ResponseContainer Test"
//            , produces = "Produces Test")
//    @ApiResponses(value = {
//            @ApiResponse(code = 200, message = "Success"),
//            @ApiResponse(code = 400, message = "Bad Request")
//    })
    @PostMapping(value = "/img/temp")
    ResponseEntity<String> imgTemp(@RequestBody ImgDTO imgDTO);
    @PostMapping(value = "/img/delete")
    ResponseEntity<MultiFileDeleteDTO> imgDelete(@RequestBody ImgDTO imgDTO);
}
