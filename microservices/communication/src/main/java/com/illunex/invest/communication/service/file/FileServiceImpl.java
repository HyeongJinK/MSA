package com.illunex.invest.communication.service.file;

import com.amazonaws.auth.AWSCredentials;
import com.amazonaws.auth.AWSStaticCredentialsProvider;
import com.amazonaws.auth.BasicAWSCredentials;
import com.amazonaws.regions.Regions;
import com.amazonaws.services.s3.AmazonS3;
import com.amazonaws.services.s3.AmazonS3ClientBuilder;
import com.amazonaws.services.s3.iterable.S3Objects;
import com.amazonaws.services.s3.model.DeleteObjectsRequest;
import com.amazonaws.services.s3.model.GetObjectRequest;
import com.amazonaws.services.s3.model.ObjectMetadata;
import com.amazonaws.services.s3.model.S3Object;
import com.illunex.invest.communication.persistence.file.entity.File;
import com.illunex.invest.communication.persistence.file.entity.FileStore;
import com.illunex.invest.communication.persistence.file.repository.FileRepository;
import com.illunex.invest.communication.persistence.file.repository.FileStoreRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@Service
public class FileServiceImpl implements FileService {

    @Autowired
    FileRepository fileRepository;

    @Autowired
    FileStoreRepository fileStoreRepository;

    @Override
    public String fileUpload(MultipartFile file, String bucket, String path) {
        AmazonS3 amazonS3 = getAmazonS3();
        ObjectMetadata metadata = new ObjectMetadata();
        metadata.setContentType(MediaType.IMAGE_PNG_VALUE);
        metadata.setContentLength(file.getSize());

        String fileName = path + file.getOriginalFilename() + "_" +  LocalDateTime.now().format(DateTimeFormatter.ofPattern("yMdHmsn"));

        FileStore fileStore = fileStoreRepository.findByBucketAndPath(bucket, path);

        if (fileStore == null) {
            FileStore newFileStore = FileStore.builder()
                    .bucket(bucket)
                    .maxSize(1)
                    .path(path)
                    .build();

            fileStore = fileStoreRepository.save(newFileStore);
        }

        try {
            amazonS3.putObject(bucket, fileName, file.getInputStream(), metadata);

            File saveFile = File.builder()
                    .fileName(fileName)
                    .filePath(path)
                    .originalFilename(file.getOriginalFilename())
                    .fileStore(fileStore)
                    .build();

            fileRepository.save(saveFile);
        } catch (IOException e) {
            // TODO 에러 처리
            e.printStackTrace();
        }

        return "https://"+bucket+".s3.ap-northeast-2.amazonaws.com/"+fileName;
    }

    @Override
    @Transactional
    public String multiFileDelete(String bucket, String[] keys) {
        AmazonS3 amazonS3 = getAmazonS3();

        for (int i=0; i<keys.length; i++) {
            fileRepository.deleteByFileName(keys[i]);
        }

        DeleteObjectsRequest delObjReq = new DeleteObjectsRequest(bucket).withKeys(keys);
        amazonS3.deleteObjects(delObjReq);

        return "File delete success";
    }

    private AmazonS3 getAmazonS3() {
        String accessKey = "AKIA34TO5GCYDQY6FUU2";
        String secretKey = "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";
        AWSCredentials credentials = new BasicAWSCredentials(accessKey, secretKey);
        return AmazonS3ClientBuilder
                .standard()
                .withCredentials(new AWSStaticCredentialsProvider(credentials))
                .withRegion(Regions.AP_NORTHEAST_2)
                .build();
    }
}
