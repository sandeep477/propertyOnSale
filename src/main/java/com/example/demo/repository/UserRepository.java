package com.example.demo.repository;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.amazonaws.services.dynamodbv2.datamodeling.DynamoDBMapper;
import com.amazonaws.services.dynamodbv2.datamodeling.DynamoDBSaveExpression;
import com.amazonaws.services.dynamodbv2.model.AttributeValue;
import com.amazonaws.services.dynamodbv2.model.ExpectedAttributeValue;
import com.example.demo.entities.User;

@Repository
public class UserRepository {

	@Autowired
	private DynamoDBMapper dynamoDBMapper;
	
	public User save(User user)
	{
		dynamoDBMapper.save(user);
		return user;
	}
	
	public User getUserById(String user_id)
	{
		return dynamoDBMapper.load(User.class,user_id);
	}
	
	public String delete(String user_id)
	{
		User user = dynamoDBMapper.load(User.class,user_id);
		dynamoDBMapper.delete(user);
		
		return "user Deleted";
		
	}
	
	public String update(String user_id,User user)
	{
		dynamoDBMapper.save(user,
				new DynamoDBSaveExpression()
				.withExpectedEntry("user_id",
						new ExpectedAttributeValue(
								new AttributeValue().withS(user_id))));
		
		return user_id;
	}
}
