package com.illunex.invest.communication.controller.mail;

import com.illunex.invest.api.common.response.ResponseData;
import com.illunex.invest.api.core.communication.controller.FileController;
import com.illunex.invest.communication.service.file.FileService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

@RestController
@RequiredArgsConstructor
public class FileControllerImpl implements FileController {
    private final FileService fileService;

    @Override
    public ResponseEntity<ResponseData> upload(MultipartFile file, String bucket, String path) {
        fileService.fileUpload(file, bucket, path);

        return ResponseEntity.ok(ResponseData.builder()
                .errorCode(0)
                .message("success")
                .build());
    }
}
