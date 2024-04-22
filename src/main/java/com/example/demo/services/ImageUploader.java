package com.example.demo.services;

import java.util.List;


import org.springframework.web.multipart.MultipartFile;

public interface ImageUploader {

	
	String uploadImage(MultipartFile image);
	
	
	List<String> allFiles();
	
	
	String preSignedUrl(String filename);
	
	String getImageUrlByName(String fileName);
}
