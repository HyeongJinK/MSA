package com.illunex.invest.api.core.ir.controller;

import com.illunex.invest.api.core.ir.dto.BasicInfoDTO;
import com.illunex.invest.api.core.ir.dto.ProductDTO;
import io.swagger.annotations.Api;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;

@Api(produces = "produces Value")
public interface ProductController {
//    @ApiOperation(value = "a1331"
//            , notes = "Notes Test"
//            , response = irController.class
//            , responseContainer = "ResponseContainer Test"
//            , produces = "Produces Test")
//    @ApiResponses(value = {
//            @ApiResponse(code = 200, message = "Success"),
//            @ApiResponse(code = 400, message = "Bad Request")
//    })

    ResponseEntity<ProductDTO> getProductInfo(@RequestParam Long irIdx);

    ResponseEntity<ProductDTO> editProductInfo(@RequestBody ProductDTO productDTO);
}
