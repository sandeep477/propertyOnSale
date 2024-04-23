package com.example.demo.repository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.amazonaws.services.dynamodbv2.datamodeling.DynamoDBMapper;
import com.amazonaws.services.dynamodbv2.datamodeling.DynamoDBSaveExpression;
import com.amazonaws.services.dynamodbv2.model.AttributeValue;
import com.amazonaws.services.dynamodbv2.model.ExpectedAttributeValue;
import com.example.demo.entities.Property;

@Repository
public class PropertyRepository {

	@Autowired
	private DynamoDBMapper dynamoDBMapper;
	
	public Property save(Property property)
	{
	   dynamoDBMapper.save(property);
	   return property;
	}
	
	public Property getPropertyById(String property_id)
 	{
       return dynamoDBMapper.load(Property.class,property_id);
       
	}
	
	public String deleteProperty(String property_id)
	{
		Property property = dynamoDBMapper.load(Property.class,property_id);
		
		dynamoDBMapper.delete(property);
		
		return "property deleted";
	}
	public String updateProperty(String property_id,Property property)
	{
		dynamoDBMapper.save(property,
				new DynamoDBSaveExpression()
				.withExpectedEntry("property_id",
						new ExpectedAttributeValue(
								new AttributeValue().withS(property_id))));
		
		return property_id;
	}
}
