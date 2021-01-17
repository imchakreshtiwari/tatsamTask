package com.tatsam.TatsamTask.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.tatsam.TatsamTask.entity.PriorityAreaUser;
import com.tatsam.TatsamTask.service.PriorityAreaUserInf;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@RestController
@RequestMapping("/rest")
public class PriorityAreaUserController {
	
	@Autowired
	private PriorityAreaUserInf priorityAreaUserInf;
	
	@PostMapping(value = "/priorityAreaUser")
	public void addCoachingDetails(@RequestBody PriorityAreaUser priorityAreaUser) {
	
		log.info("Calling api to add priority area for user");
		
		priorityAreaUserInf.addPriorityOrderandSatisfactionRating(priorityAreaUser);
	}
	
	@GetMapping(value = "/priorityAreaUser")
	public List<PriorityAreaUser> getAllPriorityAreaUsers(){
		
		log.info("Calling api to get all priority area users");
		return priorityAreaUserInf.getAllPriorityAreas();
		
	}

}
