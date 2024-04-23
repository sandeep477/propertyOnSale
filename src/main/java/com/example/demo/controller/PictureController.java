package com.example.demo.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.entities.Pictures;

import com.example.demo.repository.PictureRepository;

@RestController
public class PictureController {

	@Autowired
	private PictureRepository pictureRepository;
	
	@PostMapping("/picture")
	public Pictures savePicture(@RequestBody Pictures picture) {
		
		return pictureRepository.save(picture);	
	}
	
	@PostMapping("/picture/{id}")
	public Pictures getPicture(@PathVariable("id") String picture_id)
	{
		return pictureRepository.getPictureById(picture_id);	
	}
}
