package com.example.demo.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.Dto.LoginDTO;
import com.example.demo.entities.User;
import com.example.demo.entities.registerUser;
import com.example.demo.entities.userLogin;
import com.example.demo.payload.response.LoginMessage;
import com.example.demo.repository.UserRepository;

@RestController
@CrossOrigin
public class UserController {
	
	@Autowired
    public UserRepository userRepository;
    
	
	/**
     * 
     * @param registeruser
     * @return registerd user
     */
    @PostMapping("/register")
    public registerUser registerUser(@RequestBody registerUser registeruser)
    {
         return userRepository.register(registeruser);    	
    }
    
    /**
     * 
     * @param loginuser
     * @return status message for user sign in
     */
    @PostMapping("/signin")
    public ResponseEntity<?> signinUser(@RequestBody userLogin loginuser) {
    	LoginMessage loginMessage = userRepository.signinUser(loginuser);
    	return ResponseEntity.ok(loginMessage);
    }
	
    @PostMapping("/user")
    public User saveUser(@RequestBody User user)
    {
         return userRepository.save(user);    	
    }
    
    @PostMapping("/login")
    public ResponseEntity<?> loginUser(@RequestBody LoginDTO loginDTO) {
    	LoginMessage loginMessage = userRepository.loginUser(loginDTO);
    	return ResponseEntity.ok(loginMessage);
    }
    
    @GetMapping("/user/{id}")
    public User getUser(@PathVariable("id") String user_id)
    {
    	return userRepository.getUserById(user_id);
    }
    
    @GetMapping("/userslist")
    public ResponseEntity<List<User>> getAllUsers() {
    	List<User> users = userRepository.findAll();
    	return ResponseEntity.ok(users);
    }
    
    @DeleteMapping("/user/{id}")
    public String deleteUser(@PathVariable("id") String user_id) {
    	return userRepository.delete(user_id);
    }
}
