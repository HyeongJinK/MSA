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
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

@Service
public class FileServiceImpl implements FileService {
    @Override
    public String fileUpload(MultipartFile file, String bucket, String path) {
        AmazonS3 amazonS3 = getAmazonS3();
        ObjectMetadata metadata = new ObjectMetadata();
        metadata.setContentType(MediaType.IMAGE_PNG_VALUE);
        metadata.setContentLength(file.getSize());
        String fileName = path+file.getOriginalFilename()+"_"+ LocalDateTime.now().format(DateTimeFormatter.ofPattern("yMdHmsn"));
        try {
            amazonS3.putObject(bucket, fileName, file.getInputStream(), metadata);
        } catch (IOException e) {
            // TODO 에러 처리
            e.printStackTrace();
        }
        return "https://"+bucket+".s3.ap-northeast-2.amazonaws.com/"+fileName;
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
