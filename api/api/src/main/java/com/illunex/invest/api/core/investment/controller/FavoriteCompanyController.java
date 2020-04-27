package com.illunex.invest.api.core.investment.controller;

import com.illunex.invest.api.core.investment.dto.FavoriteCompanyDTO;
import com.illunex.invest.api.core.investment.dto.ListDTO;
import io.swagger.annotations.Api;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@Api(produces = "produces Value")
@RequestMapping(value = "/favorite")
public interface FavoriteCompanyController {
//    @ApiOperation(value = "a1331"
//            , notes = "Notes Test"
//            , response = irController.class
//            , responseContainer = "ResponseContainer Test"
//            , produces = "Produces Test")
//    @ApiResponses(value = {
//            @ApiResponse(code = 200, message = "Success"),
//            @ApiResponse(code = 400, message = "Bad Request")
//    })
    @GetMapping(value = "/list")
    ResponseEntity<ListDTO> getFavoriteCompanyList(@RequestParam Long userIdx);
    @GetMapping(value = "/")
    ResponseEntity<FavoriteCompanyDTO> getFavoriteCompany(@RequestParam Long companyIdx);
    @PostMapping(value = "/set")
    ResponseEntity<String> setFavoriteCompanyList(@RequestBody FavoriteCompanyDTO favoriteCompanyDTO);
}
