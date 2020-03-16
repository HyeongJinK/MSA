package com.illunex.invest.communication.service.file;

import com.amazonaws.auth.AWSCredentials;
import com.amazonaws.auth.AWSStaticCredentialsProvider;
import com.amazonaws.auth.BasicAWSCredentials;
import com.amazonaws.regions.Regions;
import com.amazonaws.services.s3.AmazonS3;
import com.amazonaws.services.s3.AmazonS3ClientBuilder;
import com.amazonaws.services.s3.model.ObjectMetadata;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;

@Service
public class FileServiceImpl implements FileService {
    @Override
    public String fileUpload(MultipartFile file, String bucket, String path) {
        String accessKey = "AKIA34TO5GCYDQY6FUU2";
        String secretKey = "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";
        AWSCredentials credentials = new BasicAWSCredentials(accessKey, secretKey);
        AmazonS3 amazonS3 = AmazonS3ClientBuilder
                .standard()
                .withCredentials(new AWSStaticCredentialsProvider(credentials))
                .withRegion(Regions.AP_NORTHEAST_2)
                .build();
        ObjectMetadata metadata = new ObjectMetadata();
        metadata.setContentType(MediaType.IMAGE_PNG_VALUE);
        metadata.setContentLength(file.getSize());
        try {
            amazonS3.putObject(bucket, path+file.getOriginalFilename(), file.getInputStream(), metadata);
        } catch (IOException e) {
            // TODO 에러 처리
            e.printStackTrace();
        }

        return null;
    }
}
