package com.illunex.invest.communication.controller.mail;

import com.illunex.invest.api.common.response.ResponseData;
import com.illunex.invest.api.core.communication.controller.FileController;
import com.illunex.invest.api.core.communication.dto.MultiFileDeleteDTO;
import com.illunex.invest.communication.service.file.FileService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

@RestController
@RequiredArgsConstructor
public class FileControllerImpl implements FileController {
    private final FileService fileService;

    @Override
    public ResponseEntity<ResponseData> upload(MultipartFile file, String bucket, String path) {
        String key = fileService.fileUpload(file, bucket, path);

        return ResponseEntity.ok(ResponseData.builder()
                .errorCode(0)
                .data(key)
                .message("success")
                .build());
    }

    @Override
    public ResponseEntity<String> multiFileDelete(MultiFileDeleteDTO multiFileDeleteDTO) {
        String result = fileService.multiFileDelete(multiFileDeleteDTO.getBucket(), multiFileDeleteDTO.getKeys());
        return new ResponseEntity<>(result, HttpStatus.OK);
    }
}
