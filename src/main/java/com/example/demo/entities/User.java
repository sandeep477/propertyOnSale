package com.example.demo.entities;

import com.amazonaws.services.dynamodbv2.datamodeling.DynamoDBAttribute;
import com.amazonaws.services.dynamodbv2.datamodeling.DynamoDBAutoGeneratedKey;
import com.amazonaws.services.dynamodbv2.datamodeling.DynamoDBHashKey;
import com.amazonaws.services.dynamodbv2.datamodeling.DynamoDBTable;


@DynamoDBTable(tableName = "user")
public class User {
	@DynamoDBHashKey
	@DynamoDBAutoGeneratedKey
	private String user_id;
	@DynamoDBAttribute
	private String user_name;
	@DynamoDBAttribute
	private String user_group;
	@DynamoDBAttribute
	private String mobile_number;
	@DynamoDBAttribute
	private String password;
	public String getUser_id() {
		return user_id;
	}
	public void setUser_id(String user_id) {
		this.user_id = user_id;
	}
	public String getUser_name() {
		return user_name;
	}
	public void setUser_name(String user_name) {
		this.user_name = user_name;
	}
	public String getMobile_number() {
		return mobile_number;
	}
	public void setMobile_number(String mobile_number) {
		this.mobile_number = mobile_number;
	}
	public String getPasssword() {
		return password;
	}
	public void setPasssword(String passsword) {
		this.password = passsword;
	}
	
}
