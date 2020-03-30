package com.illunex.invest.api.core.company.controller;

import com.illunex.invest.api.core.company.dto.ShareholderDTO;
import io.swagger.annotations.Api;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Api(value = "주주명부 API")
@RequestMapping(value = "/shareholder")
public interface ShareholderController {
    @GetMapping("/{companyIdx}")
    ResponseEntity<List<ShareholderDTO>> getShareholders(@PathVariable("companyIdx") Long companyIdx);

    @GetMapping("/read/{id}")
    ResponseEntity<ShareholderDTO> getShareholder(@PathVariable("id") Long id);

    @PostMapping
    ResponseEntity<String> editShareholder(@RequestBody ShareholderDTO shareholderDTO);

    @DeleteMapping("/{id}")
    ResponseEntity<String> deleteShareholder(@PathVariable("id") Long id);
}
