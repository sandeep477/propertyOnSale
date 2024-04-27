package com.example.demo.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.entities.User;
import com.example.demo.repository.UserRepository;

@RestController
@CrossOrigin
public class UserController {
	
	@Autowired
    public UserRepository userRepository;
    
    @PostMapping("/user")
    public User saveUser(@RequestBody User user)
    {
         return userRepository.save(user);    	
    }
    
    @GetMapping("/user/{id}")
    public User getUser(@PathVariable("id") String user_id)
    {
    	return userRepository.getUserById(user_id);
    }
    
    @DeleteMapping("/user/{id}")
    public String deleteUser(@PathVariable("id") String user_id) {
    	return userRepository.delete(user_id);
    }
}
