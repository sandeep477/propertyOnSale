package com.example.demo.Dto;

public class LoginDTO {

	private String user_id;
	private String password;
	private String emailId;
	public LoginDTO(String password, String emailId, String user_id) {
		super();
		this.user_id = user_id;
		this.password = password;
		this.emailId = emailId;
	}
	public String getUser_id() {
		return user_id;
	}
	public void setUser_id(String user_id) {
		this.user_id = user_id;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public String getemailId() {
		return emailId;
	}
	public void setemailId(String emailId) {
		this.emailId = emailId;
	}
	
	@Override
	public String toString() {
		return "LoginDTO [user_id=" + user_id + " ,password=" + password + ", emailId=" + emailId + "]";
	}
	public LoginDTO() {
      
  }
	
//    private String emailId;
//    private String password;
//
//    public LoginDTO(String emailId, String password) {
//        this.emailId = emailId;
//        this.password = password;
//    }
//
//    public LoginDTO() {
//        
//    }
//
//    public String getEmailId() {
//        return emailId;
//    }
//
//    public void setEmailId(String emailId) {
//        this.emailId = emailId;
//    }
//
//    public String getPassword() {
//        return password;
//    }
//
//    public void setPassword(String password) {
//        this.password = password;
//    }
//
//    @Override
//    public String toString() {
//        return "LoginDTO [emailId=" + emailId + ", password=" + password + "]";
//    }
}
