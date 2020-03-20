package com.illunex.invest.startup.controller.ir;

import com.illunex.invest.api.core.ir.dto.ImgDTO;
import com.illunex.invest.startup.service.ir.IRCompositeIntegration;
import lombok.RequiredArgsConstructor;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

@RestController
@RequiredArgsConstructor
public class ImgUploadController{
    Logger logger = LoggerFactory.getLogger(ImgUploadController.class);

    private final IRCompositeIntegration irCompositeIntegration;

    @PostMapping(value = "ir/img")
    public ResponseEntity<String> imgUpload(@RequestParam("file") MultipartFile file, @RequestParam("irIdx") Long irIdx) {
        return new ResponseEntity<>(irCompositeIntegration.imgUpload(file, irIdx), HttpStatus.OK);
    }

    @PostMapping(value = "ir/img/delete")
    public ResponseEntity<String> imgDelete(@RequestBody ImgDTO imgDTO) {
        return new ResponseEntity<>(irCompositeIntegration.imgDelete(imgDTO), HttpStatus.OK);
    }
}