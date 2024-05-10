package com.example.demo.entities;

public class userLogin {
	private String password;
	private String emailId;
	
	public userLogin(String password, String emailId) {
		super();
		this.password = password;
		this.emailId = emailId;
	}

	public userLogin() {
		super();
		// TODO Auto-generated constructor stub
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getEmailId() {
		return emailId;
	}

	public void setEmailId(String emailId) {
		this.emailId = emailId;
	}

	@Override
	public String toString() {
		return "userLogin [password=" + password + ", emailId=" + emailId + "]";
	}
	

}
