package com.example.demo.exception;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;

import com.example.demo.controller.CustomResponse;

public class GlobalExceptionHandler {

	
	@ExceptionHandler
	public ResponseEntity<CustomResponse> handleImageUploadException(ImageUploadException imageUploadException)
	{
		return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(new CustomResponse.Builder()
				.message(imageUploadException.getMessage())
				.success(false)
				.build());
	}
}
