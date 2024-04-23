package com.example.demo.repository;

import org.springframework.beans.factory.annotation.Autowired;

import com.amazonaws.services.dynamodbv2.datamodeling.DynamoDBMapper;
import com.amazonaws.services.dynamodbv2.datamodeling.DynamoDBSaveExpression;
import com.amazonaws.services.dynamodbv2.model.AttributeValue;
import com.amazonaws.services.dynamodbv2.model.ExpectedAttributeValue;
import com.example.demo.entities.Pictures;

public class PictureRepository {
	@Autowired
	private DynamoDBMapper dynamoDBMapper;
	
	public Pictures save(Pictures picture)
	{
		dynamoDBMapper.save(picture);
		return picture;
	}
	
	public Pictures getPictureById(String picture_id)
	{
		return dynamoDBMapper.load(Pictures.class,picture_id);
	}
	
	public String deletePicture(String picture_id)
	{
		Pictures picture = dynamoDBMapper.load(Pictures.class,picture_id);
		dynamoDBMapper.delete(picture);
		return "picture deleted";
	}
	
	public String updatePicture(String picture_id,Pictures picture)
	{
		dynamoDBMapper.save(picture,
				new DynamoDBSaveExpression()
				.withExpectedEntry("picture_id",
						new ExpectedAttributeValue(
								new AttributeValue().withS(picture_id))));
		
		return picture_id;
	}

}
