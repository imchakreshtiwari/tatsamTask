package com.tatsam.TatsamTask.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.tatsam.TatsamTask.entity.User;
import com.tatsam.TatsamTask.service.UserServiceInf;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@RestController
@RequestMapping("/rest")
public class UserController {

	@Autowired
	private UserServiceInf userService;
	
	@PostMapping(value = "/user")
	public void addCoachingDetails(@RequestBody User user) {
	
		log.info("Calling api to add users with role");
		
		userService.addUser(user);
		
	}
}
