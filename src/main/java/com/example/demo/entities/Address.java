package com.example.demo.entities;

import com.amazonaws.services.dynamodbv2.datamodeling.DynamoDBAttribute;

public class Address {

	@DynamoDBAttribute
	public String city;
	
	@DynamoDBAttribute
	public String ward_number;
	
	@DynamoDBAttribute
	public String colony;
	
	@DynamoDBAttribute
	public String sector;
	
	@DynamoDBAttribute
	public String landmark;
	
	@DynamoDBAttribute
	public String address;
	
	@DynamoDBAttribute
	public PropertySize property_size;
	
	
	
	
}
