package com.example.movieTracker.controllers;

import java.util.Collection;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.example.movieTracker.models.User;
import com.example.movieTracker.repository.UserRepository;
@RestController
public class UserRESTController {
	@Autowired
	private UserRepository userRepository;
	
	@CrossOrigin
	@GetMapping("user")
	public Collection<User> getUsers(){
		return userRepository.findAll();
	}
	
	@CrossOrigin
	@GetMapping("user/{id}")
	public User getUser(@PathVariable ("id")Integer id){
		return userRepository.getOne(id);
	}
	
	@CrossOrigin
	@GetMapping("userName/{name}")
	public Collection<User> getUserByName(@PathVariable ("name") String userName){
		return userRepository.findByNameContainingIgnoreCase(userName);
	}
	
	@CrossOrigin
	@DeleteMapping("user/{id}")
	public ResponseEntity<User> deleteUser(@PathVariable ("id") Integer id){
		if(!userRepository.existsById(id))
			return new ResponseEntity<>(HttpStatus.NO_CONTENT);
		userRepository.deleteById(id);
			return new ResponseEntity<>(HttpStatus.OK);
	}
	
	@CrossOrigin
	@PostMapping("userPost")
	public ResponseEntity<User> insertUser(@RequestBody User user){
		if(!userRepository.existsById(user.getId())){
			userRepository.save(user);
			return new ResponseEntity<>(HttpStatus.OK);
		}
		return new ResponseEntity<>(HttpStatus.CONFLICT);
	}
	
	@CrossOrigin
	@PutMapping("userPut")
	public ResponseEntity<User> updateUser(@RequestBody User user){
		if(!userRepository.existsById(user.getId()))
			return new ResponseEntity<>(HttpStatus.NO_CONTENT);
		userRepository.save(user);
		return new ResponseEntity<>(HttpStatus.OK);
	}

}
