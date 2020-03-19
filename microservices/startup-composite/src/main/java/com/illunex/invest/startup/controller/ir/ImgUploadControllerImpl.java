package com.illunex.invest.startup.controller.ir;

import com.illunex.invest.api.core.ir.controller.ImgUploadController;
import com.illunex.invest.api.core.ir.controller.MemberController;
import com.illunex.invest.api.core.ir.dto.EditDTO;
import com.illunex.invest.api.core.ir.dto.ImgUploadDTO;
import com.illunex.invest.api.core.ir.dto.ListDTO;
import com.illunex.invest.startup.service.ir.IRCompositeIntegration;
import com.illunex.invest.startup.service.user.UserCompositeIntegration;
import lombok.RequiredArgsConstructor;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.*;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.reactive.function.client.WebClient;

@RestController
@RequiredArgsConstructor
public class ImgUploadControllerImpl implements ImgUploadController {
    Logger logger = LoggerFactory.getLogger(ImgUploadControllerImpl.class);

    private final IRCompositeIntegration irCompositeIntegration;


    @Override
    public ResponseEntity<String> imgUpload(@RequestParam("file") MultipartFile file) {

        String imgUrl = irCompositeIntegration.imgUpload(file);

        return new ResponseEntity<>(imgUrl, HttpStatus.OK);
    }

    @Override
    public ResponseEntity<String> imgDelete(ImgUploadDTO imgUploadDTO) {
        return null;
    }
}