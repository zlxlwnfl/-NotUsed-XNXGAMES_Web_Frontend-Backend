package com.juri.XNXGAMES.controller;

import javax.ws.rs.core.Response;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.juri.XNXGAMES.service.UserService;

import lombok.AllArgsConstructor;

@RestController
@RequestMapping("/user/*")
@AllArgsConstructor
public class UserController {

	private UserService userService;
	
	@PostMapping("/")
	public ResponseEntity<Void> create(@RequestParam String userName, 
										@RequestParam String password) {
		Response response = userService.create(userName, password);
		
		if(response.getStatus() != 201)
			return new ResponseEntity<>(HttpStatus.NOT_ACCEPTABLE);
		return new ResponseEntity<>(HttpStatus.CREATED);
	}
	
}
