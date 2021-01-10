package com.example.springbootdemo.controller;

import java.net.URI;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import com.example.springbootdemo.entity.User;
import com.example.springbootdemo.repository.UserRepository;

@RestController
@RequestMapping("/api")
public class UserController {

	@Autowired
	private UserRepository userRepository;
	

	@GetMapping("/users")
	public ResponseEntity<List<User>> getAllUsers(){
	    
	    Optional<List<User>> optUsers = Optional.ofNullable(userRepository.findAll());
	    
	    if(optUsers.isPresent()) {
	        List<User> Users = optUsers.get();
	        
	        return new ResponseEntity<List<User>>(Users, HttpStatus.OK);
	    } else {
	        return new ResponseEntity<>(null, HttpStatus.NO_CONTENT);
	    }
	}
	
	@GetMapping("/users/{id}")
	public User retreiveTask(@PathVariable int id) {
		Optional<User> user = userRepository.findById(id);
		
		return user.get();
	}
	
	@DeleteMapping("/users/{id}")
	public void deleteUser(@PathVariable int id) {
		userRepository.deleteById(id);
	}
	
	@PostMapping("/users")
	public ResponseEntity<Object> createUser(@RequestBody User user){
		User savedUser = userRepository.save(user);
		
		URI location = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}")
				.buildAndExpand(savedUser.getId()).toUri();
		
		return ResponseEntity.created(location).build();
	}
	
	@PutMapping("/users/{id}")
	public ResponseEntity<Object> updateUser(@RequestBody User user, @PathVariable int id){
		Optional<User> userOptional = userRepository.findById(id);
		
		if(!userOptional.isPresent())
			return ResponseEntity.notFound().build();
		user.setId(id);
		
		userRepository.save(user);
		return ResponseEntity.noContent().build();
	}
}
