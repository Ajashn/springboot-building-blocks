package com.ajashn.restservices.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.ajashn.restservices.entities.User;
import com.ajashn.restservices.services.UserService;


@RestController
public class UserController {
	@Autowired
	private UserService userService;

	// getAllUsers Method
	@GetMapping("/users")
	public List<User> getAllUsers() {

		return userService.getAllUsers();

	}
	
	@PostMapping("/users")
	public User createUser(@RequestBody User user) {
		
			return userService.createUser(user);
	}
	
	
	@GetMapping("/users/{id}")
	public User getUserById(@PathVariable("id") long id) {
		
			return userService.getUserById(id);
	}
	
	@PutMapping("/users/{id}") 
	public User updateUserById(@PathVariable("id") long id,@RequestBody User user) {
			 return userService.updateUserById(id, user); 
	}
	
	
	  
	  @DeleteMapping("/users/{id}") public void deleteUserById(@PathVariable("id")
	  long id) {
	  
	  userService.deleteUserById(id); 
	  }
	  
	  @GetMapping("/users/byusername/{name}") 
	  public User getUserByName(@PathVariable("name") String username) {
	  
	  return userService.getUserByUsername(username); 
	  }
	 
	
	
	
}
