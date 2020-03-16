package com.illunex.invest.communication.service.file;

import org.springframework.web.multipart.MultipartFile;

public interface FileService {
    String fileUpload(MultipartFile file, String bucket, String path);
}
