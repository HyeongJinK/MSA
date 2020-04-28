package com.illunex.invest.api.composite.startup.mypage.controller;

import com.illunex.invest.api.common.response.ResponseData;
import com.illunex.invest.api.common.response.ResponseList;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

@Api(value = "마이페이지 서명")
@RequestMapping(value = "/myPage/signature")
public interface SignatureCompositeController {
    @ApiOperation(value = "리스트 조회")
    @GetMapping
    ResponseEntity<ResponseList> signature();
    @ApiOperation(value = "활성화된 리스트 조회")
    @GetMapping(value = "/open")
    ResponseEntity<ResponseList> signatureActive();
    @ApiOperation(value = "파일 올리기")
    @PostMapping
    ResponseEntity<ResponseData> signature(@RequestParam("file") MultipartFile file);
    @ApiOperation(value = "활성&비활성")
    @PutMapping
    ResponseEntity<ResponseData> toggleSignature(@RequestParam Long id);
    @ApiOperation(value = "삭제")
    @DeleteMapping
    ResponseEntity<ResponseData> delSignature(@RequestParam Long id);
}
