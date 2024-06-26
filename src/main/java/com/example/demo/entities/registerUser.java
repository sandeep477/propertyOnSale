package com.example.demo.entities;

import com.amazonaws.services.dynamodbv2.datamodeling.DynamoDBAttribute;
import com.amazonaws.services.dynamodbv2.datamodeling.DynamoDBAutoGeneratedKey;
import com.amazonaws.services.dynamodbv2.datamodeling.DynamoDBHashKey;
import com.amazonaws.services.dynamodbv2.datamodeling.DynamoDBTable;

@DynamoDBTable(tableName = "register")
public class registerUser {
	@DynamoDBAutoGeneratedKey
	private String userId;
	
	@DynamoDBAttribute
	private String userName;
	
	@DynamoDBAttribute
	private String userGroup;
	
	@DynamoDBAttribute
	private String mobileNumber;
	
	@DynamoDBHashKey
	@DynamoDBAttribute
	private String emailId;
	
	@DynamoDBAttribute
	private String password;

	public registerUser(String userId, String userName, String userGroup, String mobileNumber, String emailId,
			String password) {
		super();
		this.userId = userId;
		this.userName = userName;
		this.userGroup = userGroup;
		this.mobileNumber = mobileNumber;
		this.emailId = emailId;
		this.password = password;
	}

	public registerUser() {
		super();
		// TODO Auto-generated constructor stub
	}

	public String getUserId() {
		return userId;
	}

	public void setUserId(String userId) {
		this.userId = userId;
	}

	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	public String getUserGroup() {
		return userGroup;
	}

	public void setUserGroup(String userGroup) {
		this.userGroup = userGroup;
	}

	public String getMobileNumber() {
		return mobileNumber;
	}

	public void setMobileNumber(String mobileNumber) {
		this.mobileNumber = mobileNumber;
	}

	public String getEmailId() {
		return emailId;
	}

	public void setEmailId(String emailId) {
		this.emailId = emailId;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	@Override
	public String toString() {
		return "registerUser [userId=" + userId + ", userName=" + userName + ", userGroup=" + userGroup
				+ ", mobileNumber=" + mobileNumber + ", emailId=" + emailId + ", password=" + password + "]";
	}
	
	

}
