package com.example.demo.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.model.User;
import com.example.demo.repo.UserRepository;

@RestController
@RequestMapping("/user")
public class UserController {
	
	@Autowired
	private UserRepository userRepo;

	@PostMapping("/create")
	public ResponseEntity<?> create(@RequestBody final User user){
		User newUser=new User();
		newUser.setUserName(user.getUserName());
		newUser.setPassword(user.getPassword());
		userRepo.saveAndFlush(newUser);
		return ResponseEntity.status(HttpStatus.OK).body(newUser);	
	}
	@PostMapping("/login")
	public ResponseEntity<?> archive(@RequestBody final User user){
		User isUser=userRepo.checkUser(user.getUserName(),user.getPassword());
		if(isUser!=null) {
			return ResponseEntity
					.status(HttpStatus.OK)
					.body("Login Successfully...");
		}else {
			return ResponseEntity
					.status(HttpStatus.OK)
					.body("Login Failed....");
		}
					
	}
}
