package com.example.demo.services;

import java.io.IOException;
import java.net.URL;
import java.util.Date;
import java.util.List;
import java.util.UUID;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import com.amazonaws.HttpMethod;
import com.amazonaws.services.s3.AmazonS3;
import com.amazonaws.services.s3.model.GeneratePresignedUrlRequest;
import com.amazonaws.services.s3.model.ListObjectsV2Request;
import com.amazonaws.services.s3.model.ListObjectsV2Result;
import com.amazonaws.services.s3.model.ObjectMetadata;
import com.amazonaws.services.s3.model.PutObjectRequest;
import com.amazonaws.services.s3.model.PutObjectResult;
import com.amazonaws.services.s3.model.S3Object;
import com.amazonaws.services.s3.model.S3ObjectSummary;
import com.example.demo.exception.ImageUploadException;


@Service
public class S3ImageUploader implements ImageUploader{
	
	@Autowired
	private AmazonS3 client;
	


	@Override
	public String uploadImage(MultipartFile image) {
		// TODO Auto-generated method stub
		
		String actualFileName = image.getOriginalFilename();
		
		String fileName = UUID.randomUUID().toString()+actualFileName.substring(actualFileName.lastIndexOf('.'));
		
		ObjectMetadata metaData = new ObjectMetadata();
		
		metaData.setContentLength(image.getSize());
		
		try {
			PutObjectResult putObjectResult = client.putObject(new PutObjectRequest("sellpropertyimages", fileName, image.getInputStream(),metaData));
			
			return this.preSignedUrl(fileName);
		} catch (RuntimeException | IOException e) {
			// TODO Auto-generated catch block
		     throw new ImageUploadException("error in uploading image "+e.getMessage());
		}
	}

	@Override
	public List<String> allFiles() {
		// TODO Auto-generated method stub
		
		ListObjectsV2Request listObjectRequest = new ListObjectsV2Request()
				                                    .withBucketName("sellpropertyimages");
		
		ListObjectsV2Result listObjectV2Result  = client.listObjectsV2(listObjectRequest);
		
		List<S3ObjectSummary> objectSummary = listObjectV2Result.getObjectSummaries();
		
		List<String> listFileUrl = objectSummary.stream().map(item -> this.preSignedUrl(item.getKey())).collect(Collectors.toList());
		
		
		return listFileUrl;
	}

	@Override
	public String preSignedUrl(String filename) {
		
		Date expirationDate = new Date();
		
		long time = expirationDate.getTime();
		int hour = 2;
		time = time + hour *60*60*1000;
		
		expirationDate.setTime(time);
		GeneratePresignedUrlRequest generatePresignedUrlRequest  = new GeneratePresignedUrlRequest("sellpropertyimages", filename)
				.withMethod(HttpMethod.GET)
				.withExpiration(expirationDate);
		
		URL url = client.generatePresignedUrl(generatePresignedUrlRequest);
		// TODO Auto-generated method stub
		return url.toString();
	}

	@Override
	public String getImageUrlByName(String fileName) {
		// TODO Auto-generated method stub
		
		
		S3Object object = client.getObject("sellpropertyimages",fileName);
		
		String key = object.getKey();
		String url = preSignedUrl(key);
		
		return url;
	}

	
	
}
