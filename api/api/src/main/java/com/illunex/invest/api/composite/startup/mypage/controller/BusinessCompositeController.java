package com.illunex.invest.api.composite.startup.mypage.controller;

import com.illunex.invest.api.common.response.ResponseData;
import com.illunex.invest.api.core.company.dto.BusinessDTO;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

@RequestMapping(value = "/myPage/business")
public interface BusinessCompositeController {
    @GetMapping(value = {"", "/"})
    ResponseEntity<ResponseData> getBusiness();
    @PostMapping(value = {"", "/"})
    ResponseEntity<ResponseData> editBusiness(@RequestBody BusinessDTO businessDTO);
    @PostMapping(value = "/file")
    ResponseEntity<ResponseData> uploadFile(@RequestParam("file") MultipartFile file);
}
