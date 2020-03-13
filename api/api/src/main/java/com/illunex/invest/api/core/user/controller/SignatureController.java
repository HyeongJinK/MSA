package com.illunex.invest.api.core.user.controller;

import com.illunex.invest.api.common.response.ResponseData;
import io.swagger.annotations.Api;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

@Api(value = "서명")
@RequestMapping("/signature")
public interface SignatureController {
    @PostMapping("/{userId}")
    ResponseEntity<ResponseData> changePassword(@PathVariable Long userId, @RequestParam("file") MultipartFile file, @RequestParam("fileName") String fileName);
}
