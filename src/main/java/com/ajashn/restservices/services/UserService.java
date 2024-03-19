package com.ajashn.restservices.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ajashn.restservices.entities.User;
import com.ajashn.restservices.repositories.UserRepository;


@Service
public class UserService {
	
	@Autowired
	private UserRepository userRepository;

	// getAllUsers Method
	public List<User> getAllUsers() {

		return userRepository.findAll();

	}
	
	public User createUser(User user) {
		return userRepository.save(user);
	}

	public User getUserById(Long id){
		User user = userRepository.findById(id).get();
		return user;
	} 
	
	// updateUserById
		public User updateUserById(Long id, User user) {
			//User existing = userRepository.findById(id).get();
			user.setUserid(id);;
			return userRepository.save(user);

		}
		
		// deleteUserById
		public void deleteUserById(Long id) {
			//User user = userRepository.findById(id).get();
			userRepository.deleteById(id);
		}

		// getUserByUsername

		public User getUserByUsername(String username) {
			return userRepository.findByUsername(username);
		}
}
