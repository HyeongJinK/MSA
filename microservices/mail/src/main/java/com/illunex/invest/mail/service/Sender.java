package com.illunex.invest.mail.service;

import com.amazonaws.AmazonClientException;
import com.amazonaws.auth.AWSStaticCredentialsProvider;
import com.amazonaws.auth.BasicAWSCredentials;
import com.amazonaws.regions.Regions;
import com.amazonaws.services.simpleemail.AmazonSimpleEmailService;
import com.amazonaws.services.simpleemail.AmazonSimpleEmailServiceClientBuilder;
import com.illunex.invest.mail.dto.SenderDto;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class Sender {
    Logger log = LoggerFactory.getLogger(getClass());
//      @Value("${AWSAccessKeyId}")
//      private String AWS_ACCESS_KEY_ID;
//
//      @Value("${AWSSecretKey}")
//      private String AWS_SECRET_KEY;

    public void send(SenderDto senderDto){
        try {
            log.info("Attempting to send an email through Amazon SES by using the AWS SDK for Java...");
            // 아래 부분에 위에서 받은 ID, Key를 집어 넣습니다.
            // 인증방식은 제가 고쳐서 진행했습니다.
            BasicAWSCredentials awsCreds = new BasicAWSCredentials("AKIAIWEEGT3JII7FI6AA","ZS/WfxioqV0bNPMTY6jUwtcn84eClMcdVGS5lTbB");
            AWSStaticCredentialsProvider credentialsProvider = new AWSStaticCredentialsProvider(awsCreds);
            try {
                // 아래와 같이 인증방식을 변경함.
                credentialsProvider.getCredentials();
            } catch (Exception e) {
                throw new AmazonClientException(
                        "Cannot load the credentials from the credential profiles file. " +
                                "Please make sure that your credentials file is at the correct " +
                                "location (~/.aws/credentials), and is in valid format.",
                        e);
            }

            AmazonSimpleEmailService client = AmazonSimpleEmailServiceClientBuilder.standard()
                    .withCredentials(credentialsProvider)
                    .withRegion(Regions.US_EAST_1)
                    .build();

            client.sendEmail(senderDto.toSendRequestDto());
            log.info("Email sent!");

        } catch (Exception ex) {
            log.error("The email was not sent.");
            log.error("Error message: " + ex.getMessage());
            throw new AmazonClientException(
                    ex.getMessage(),
                    ex);
        }
    }
}

