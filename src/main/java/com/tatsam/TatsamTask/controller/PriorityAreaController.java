package com.tatsam.TatsamTask.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.tatsam.TatsamTask.entity.PriorityArea;
import com.tatsam.TatsamTask.service.PriorityAreaInf;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@RestController
@RequestMapping("/rest")
public class PriorityAreaController {

	@Autowired
	private PriorityAreaInf priorityAreaInf;
	
	@PostMapping(value = "/priorityArea/{userId}")
	public void addCoachingDetails(@RequestBody PriorityArea priorityArea, @PathVariable("userId") Long userId) {
	
		log.info("Calling api to add priority area");
		
		priorityAreaInf.addPriorityArea(priorityArea, userId);
		
	}
}
