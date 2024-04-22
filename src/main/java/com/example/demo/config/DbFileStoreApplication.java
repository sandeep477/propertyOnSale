package com.example.demo.config;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.amazonaws.auth.AWSStaticCredentialsProvider;
import com.amazonaws.auth.BasicAWSCredentials;
import com.amazonaws.services.s3.AmazonS3;
import com.amazonaws.services.s3.AmazonS3ClientBuilder;

@Configuration
public class DbFileStoreApplication {

	@Value("${cloud.aws.credentials.access-key}")
	private String awsAccesskey;
	
	@Value("${cloud.aws.credentials.secret-key}")
	private String awsSecretKey;
	
	@Value("${cloud.aws.region.static}")
	private String region;

    @Bean
    AmazonS3 client()
	{String AccessKey = "AKIAZI2LCBP2ZJCGDAV2";
	 String SecretKey = "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";
	 String reg  ="eu-north-1";
		com.amazonaws.auth.AWSCredentials credentials =  new BasicAWSCredentials(AccessKey,SecretKey);
		
		
		AmazonS3 amazons3 =  AmazonS3ClientBuilder.standard()
		                     .withCredentials(new AWSStaticCredentialsProvider(credentials))
		                     .withRegion(reg)
		                     .build();
		
		return amazons3;
		
	}
}
