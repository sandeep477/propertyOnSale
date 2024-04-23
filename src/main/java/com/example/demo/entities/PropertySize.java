package com.example.demo.entities;

import com.amazonaws.services.dynamodbv2.datamodeling.DynamoDBAttribute;
import com.amazonaws.services.dynamodbv2.datamodeling.DynamoDBDocument;

@DynamoDBDocument
public class PropertySize {
	@DynamoDBAttribute
	public Integer length;
	
	@DynamoDBAttribute
	public Integer width;
}
