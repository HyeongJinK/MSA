package com.illunex.invest.api.core.user.controller;

import com.illunex.invest.api.common.response.ResponseData;
import com.illunex.invest.api.common.response.ResponseList;
import com.illunex.invest.api.core.user.request.SignatureRequest;
import io.swagger.annotations.Api;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@Api(value = "서명")
@RequestMapping("/signature")
public interface SignatureController {
    @GetMapping("/list")
    ResponseEntity<ResponseList> signatureList(@RequestParam("userId") Long userId);
    @PostMapping("/add")
    ResponseEntity<ResponseData> addSignature(@RequestBody SignatureRequest request);
    @PutMapping("/toggle")
    ResponseEntity<ResponseData> toggleSignature(@RequestParam("id") Long id);
    @DeleteMapping("/delete")
    ResponseEntity<ResponseData> deleteSignature(@RequestParam("id") Long id);
}
