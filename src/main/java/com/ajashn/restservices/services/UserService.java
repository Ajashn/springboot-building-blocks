package com.ajashn.restservices.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import com.ajashn.restservices.entities.User;
import com.ajashn.restservices.repositories.UserRepository;
import com.ajashn.restservices.exceptions.UserExistsException;
import com.ajashn.restservices.exceptions.UserNotFoundException;


@Service
public class UserService {
	
	@Autowired
	private UserRepository userRepository;

	// getAllUsers Method
	public List<User> getAllUsers() {

		return userRepository.findAll();

	}
	
	public User createUser(User user)  throws UserExistsException {
		User existingUser=userRepository.findByUsername(user.getUsername());
		
		if(existingUser!=null) {
			throw new UserExistsException("User already exists in Repository");
		}
		
		return userRepository.save(user);
	}

	public User getUserById(Long id) throws UserNotFoundException{
		Optional<User> user = userRepository.findById(id);
		if(!user.isPresent()) {
			throw new UserNotFoundException("sorry ,this user is not in our data");
		}
		return user.get();
	} 
	
	// updateUserById
		public User updateUserById(Long id, User user) throws UserNotFoundException{
		
			Optional<User> optionalUser = userRepository.findById(id);

			if (!optionalUser.isPresent()) {
				throw new UserNotFoundException("User Not found in user Repository, provide the correct user id");
			}

			user.setUserid(id);;
			return userRepository.save(user);

		}
		
		// deleteUserById
		public void deleteUserById(Long id) {
			//User user = userRepository.findById(id).get();
			Optional<User> optionalUser = userRepository.findById(id);
			if (!optionalUser.isPresent()) {
				throw new ResponseStatusException(HttpStatus.BAD_REQUEST,"User Not found in user Repository, provide the correct user id to delete");
			}
			userRepository.deleteById(id);
		}

		// getUserByUsername

		public User getUserByUsername(String username) {
			return userRepository.findByUsername(username);
		}
}
