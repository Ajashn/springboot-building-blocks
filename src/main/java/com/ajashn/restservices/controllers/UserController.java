package com.ajashn.restservices.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.server.ResponseStatusException;
import org.springframework.web.util.UriComponentsBuilder;

import com.ajashn.restservices.entities.User;
import com.ajashn.restservices.exceptions.UserExistsException;
import com.ajashn.restservices.exceptions.UserNotFoundException;
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
	public ResponseEntity<Void>  createUser(@RequestBody User user,UriComponentsBuilder builder) {
		
			try {
				 userService.createUser(user);
				 HttpHeaders headers = new HttpHeaders();
				 headers.setLocation(builder.path("/users/{id}").buildAndExpand(user.getUserid()).toUri());
				 return new ResponseEntity<Void>(headers, HttpStatus.CREATED);
			} catch (UserExistsException ex) {
				throw new ResponseStatusException(HttpStatus.NOT_FOUND, ex.getMessage());
			}

	}
	
	
	@GetMapping("/users/{id}")
	public User getUserById(@PathVariable("id") long id) {
		
		User user = null;
		try {
			user = userService.getUserById(id);
		} catch (UserNotFoundException ex) {
			throw new ResponseStatusException(HttpStatus.NOT_FOUND, ex.getMessage());
		}
		return user;
	}
	
	@PutMapping("/users/{id}") 
	public User updateUserById(@PathVariable("id") long id,@RequestBody User user) {
		try {
			return userService.updateUserById(id, user);
		} catch (UserNotFoundException ex) {
			throw new ResponseStatusException(HttpStatus.BAD_REQUEST, ex.getMessage());
		}
	}
	
	
	  
	  @DeleteMapping("/users/{id}") public void deleteUserById(@PathVariable("id")
	  long id) {
	  
	  userService.deleteUserById(id); 
	  }
	  
	  @GetMapping("/users/exceptions/byusername/{name}") 
	  public User getUserByName(@PathVariable("name") String username) {
	  
	  return userService.getUserByUsername(username); 
	  }
	 
	
	
	
}
