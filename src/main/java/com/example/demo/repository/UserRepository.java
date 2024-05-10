package com.example.demo.repository;


import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.amazonaws.services.dynamodbv2.AmazonDynamoDB;
import com.amazonaws.services.dynamodbv2.datamodeling.DynamoDBMapper;
import com.amazonaws.services.dynamodbv2.datamodeling.DynamoDBSaveExpression;
import com.amazonaws.services.dynamodbv2.model.AttributeValue;
import com.amazonaws.services.dynamodbv2.model.ExpectedAttributeValue;
import com.example.demo.Dto.LoginDTO;
import com.example.demo.entities.User;
import com.example.demo.entities.registerUser;
import com.example.demo.entities.userLogin;
import com.example.demo.payload.response.LoginMessage;
import com.amazonaws.services.dynamodbv2.document.Item;
import com.amazonaws.services.dynamodbv2.document.Table;
import com.amazonaws.services.dynamodbv2.document.DynamoDB;

@Repository
public class UserRepository {

	@Autowired
	private DynamoDBMapper dynamoDBMapper;
	
	/**
	 * 
	 * @param registeruser
	 * @return registered user
	 */
	public registerUser register(registerUser registeruser) {
		registerUser user = dynamoDBMapper.load(registerUser.class, registeruser.getEmailId());
		System.out.print("User: "+ user);
		if(user != null) {
			return null;
		}
		dynamoDBMapper.save(registeruser);
		return registeruser;
	}
	
	/**
	 * 
	 * @param userlogin
	 * @return status of user login
	 */
	public LoginMessage signinUser(userLogin userlogin) {
		registerUser user = dynamoDBMapper.load(registerUser.class, userlogin.getEmailId());
        System.out.print("User: "+user);
        // Check if the user exists
        if (user != null) {
            // Check if the password matches
            if (user.getPassword().equals(userlogin.getPassword())) {
                // Password matches, return login success
                return new LoginMessage("Login Success", true);
            } else {
                // Password does not match, return login failed
                return new LoginMessage("Password does not match", false);
            }
        } else {
            // User does not exist, return login failed
            return new LoginMessage("User does not exist", false);
        }
    }
	
	
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
		return "User is deleted successfully!";
		
	}
	
	/**
	 * 
	 * @param loginDTO
	 * @return login response
	 */
//	public LoginMessage loginUser(LoginDTO loginDTO) {
//		User user1 = dynamoDBMapper.load(User.class,loginDTO.getEmail());
//		System.out.print("user1 "+ user1);
//		if(user1 != null) {
//			String password = loginDTO.getPassword();
//			String password1 = user1.getpasssword();
//			if(password == password1) {
////				Optional<User> user = userRepo.findOneByEmailAndPassword(loginDTO.getEmail(), password1);
////				Optional<User> user = dynamoDBMapper).load(loginDTO.getEmail(),password1);
//				User user = 
//				if(user.isPresent()) {
//					return new LoginMessage("Login Success", true);
//				} else {
//					return new LoginMessage("Login Failed", false);
//				}
//			} else {
//				return new LoginMessage("Password does not matched", false);
//			}
//		} else {
//			return new LoginMessage(")Email does not matched", false);
//		}
//		return null;
//	}
	
	public LoginMessage loginUser(LoginDTO loginDTO) {
		User user = dynamoDBMapper.load(User.class, loginDTO.getUser_id());
        System.out.print("User: "+user);
        // Check if the user exists
        if (user != null) {
            // Check if the password matches
            if (user.getpassword().equals(loginDTO.getPassword())) {
                // Password matches, return login success
                return new LoginMessage("Login Success", true);
            } else {
                // Password does not match, return login failed
                return new LoginMessage("Password does not match", false);
            }
        } else {
            // User does not exist, return login failed
            return new LoginMessage("User does not exist", false);
        }
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

	public List<User> findAll() {
		// TODO Auto-generated method stub
		return null;
	}

	

}
