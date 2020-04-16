package com.illunex.invest.api.composite.startup.company.controller;

import com.illunex.invest.api.common.response.ResponseData;
import com.illunex.invest.api.core.company.dto.ShareholderDTO;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RequestMapping(value = "/company/shareholder")
public interface ShareholderCompositeController {
    @PostMapping(value = {"", "/"})
    ResponseEntity<ResponseData> editShareholders(@RequestBody ShareholderDTO shareholderDTO);
    @GetMapping(value = {"", "/"})
    ResponseEntity<ResponseData> getShareholders();
    @GetMapping(value = {"/{id}"})
    ResponseEntity<ResponseData> getShareholder(@PathVariable Long id);
    @DeleteMapping(value = "/{id}")
    ResponseEntity<ResponseData> deleteShareholder(@PathVariable Long id);
    @PostMapping(value = "/lock")
    ResponseEntity<ResponseData> lockSetting(@RequestParam("id") Long id, @RequestParam("rock") Boolean rock);
    @PostMapping(value = "/setPassword")
    ResponseEntity<ResponseData> setPassword(@RequestParam("id") Long id, @RequestParam("password") String password);
    @PostMapping(value = "/passwordCheck")
    ResponseEntity<ResponseData> passwordCheck(@RequestParam("id") Long id, @RequestParam("password") String password);
}
