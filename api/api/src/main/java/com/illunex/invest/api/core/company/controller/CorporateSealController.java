package com.illunex.invest.api.core.company.controller;

import com.illunex.invest.api.common.response.ResponseData;
import com.illunex.invest.api.common.response.ResponseList;
import com.illunex.invest.api.core.company.dto.CorporateSealDTO;
import io.swagger.annotations.Api;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@Api(value = "서명")
@RequestMapping("/corporateSeal")
public interface CorporateSealController {
    @GetMapping({"", "/"})
    ResponseEntity<ResponseList> corporateSealList(@RequestParam("companyId") Long companyId);
    @PostMapping({"", "/"})
    ResponseEntity<ResponseData> addCorporateSealList(@RequestBody CorporateSealDTO corporateSealDTO);
    @PutMapping({"", "/"})
    ResponseEntity<ResponseData> toggleCorporateSeal(@RequestParam("id") Long id);
    @DeleteMapping({"", "/"})
    ResponseEntity<ResponseData> deleteCorporateSeal(@RequestParam("id") Long id);
}
