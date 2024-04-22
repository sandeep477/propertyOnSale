package com.example.demo.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import com.example.demo.services.ImageUploader;


@RestController
@RequestMapping("/api/v1/s3")
public  class S3Controller {

	@Autowired
	private ImageUploader uploader;
	
	
	private S3Controller(ImageUploader uploader)
	{
		this.uploader = uploader;
	}
	
	@PostMapping("/")
	public ResponseEntity<?> uploadImage(@RequestParam MultipartFile file)
	{
		return ResponseEntity.ok(uploader.uploadImage(file));
	}
	
	@GetMapping("/")
	public List<String> getAllFiles()
	{
		return uploader.allFiles();
	}
	
	@GetMapping("/{fileName}")
	public String urlByName(@PathVariable("fileName") String fileName)
	{
	     return uploader.getImageUrlByName(fileName);	
	}

}
