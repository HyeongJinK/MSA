package com.illunex.invest.api.core.ir.controller;

import com.illunex.invest.api.common.response.ResponseData;
import com.illunex.invest.api.core.ir.dto.EditDTO;
import com.illunex.invest.api.core.ir.dto.ImgUploadDTO;
import com.illunex.invest.api.core.ir.dto.ListDTO;
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
    @PostMapping(value = "/img")
    ResponseEntity<String> imgUpload(@RequestParam("file") MultipartFile file);
    @DeleteMapping(value = "/img")
    ResponseEntity<String> imgDelete(@RequestBody ImgUploadDTO imgUploadDTO);
}
