package com.example.demo.entities;

import com.amazonaws.services.dynamodbv2.datamodeling.DynamoDBAttribute;

public class PropertySize {
	@DynamoDBAttribute
	public Integer length;
	
	@DynamoDBAttribute
	public Integer width;
}
