package com.example.first.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.example.first.DTO.ResponseCategories;
import com.example.first.DTO.User;
import com.example.first.service.TestService;


@RestController
@CrossOrigin(origins = "http://localhost:3000")
public class TestController {
	
	@Autowired
	TestService testService;
	
	@GetMapping("/user/{username}")
	public ResponseEntity<Boolean> validateUser(@PathVariable String username) {
		
		//System.out.println("GET API data recieved for username :"+username);
		
		Boolean isValid = testService.getUser(username);
		
		//System.out.println("GET API response ->"+isValid);
		
		return ResponseEntity.ok(isValid);
		
	}
	
	@PostMapping("/user")
	public ResponseEntity<User> addUser(@RequestBody() User user) {
		
//		System.out.println("POST API data recieved for username :"+user.getUsername());
//		System.out.println("POST API data recieved for password :"+user.getPassword());
//		System.out.println("POST API data recieved for email :"+user.getEmail());
		
		Boolean isInserted = testService.insertUser(user);
		
		//System.out.println("POST API response -> "+isInserted);
		
		if(isInserted)
			return ResponseEntity.ok(user);
		else
			return ResponseEntity.status(HttpStatus.NOT_FOUND).body(null);
		
	}
	
	@GetMapping("/products")
	public ResponseCategories getProducts() {
		ResponseCategories categories = new ResponseCategories();
		categories = testService.getProducts();
		
		return categories;
		
	}
	

}
