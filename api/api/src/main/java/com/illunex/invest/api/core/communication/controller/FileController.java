package com.illunex.invest.api.core.communication.controller;

import com.illunex.invest.api.common.response.ResponseData;
import com.illunex.invest.api.core.communication.dto.MultiFileDeleteDTO;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

@RequestMapping("/file")
public interface FileController {
    @PostMapping("/upload")
    ResponseEntity<ResponseData> upload(@RequestParam("file") MultipartFile file
            , @RequestParam("bucket") String bucket
            , @RequestParam("path") String path);

    @PostMapping("/multiFileDelete")
    ResponseEntity<String> multiFileDelete(@RequestBody MultiFileDeleteDTO multiFileDeleteDTO);
}
