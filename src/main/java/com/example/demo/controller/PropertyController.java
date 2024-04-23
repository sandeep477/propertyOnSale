package com.example.demo.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.entities.Property;
import com.example.demo.repository.PropertyRepository;

@RestController
public class PropertyController {

	@Autowired
	public PropertyRepository propertyRepository;
	
	@PostMapping("/property")
	public Property saveProperty(@RequestBody Property property)
	{
		return propertyRepository.save(property);
	}
	@PostMapping("/property/{id}")
	public Property getProperty(@PathVariable("id") String property_id)
	{	
		return propertyRepository.getPropertyById(property_id);
	}
	
}
