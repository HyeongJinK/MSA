package com.illunex.invest.communication.service.file;

import org.springframework.web.multipart.MultipartFile;

import java.util.List;

public interface FileService {
    String fileUpload(MultipartFile file, String bucket, String path);
    String multiFileDelete(String bucket, String[] keys);
}
