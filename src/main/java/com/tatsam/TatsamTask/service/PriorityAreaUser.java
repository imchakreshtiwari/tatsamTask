package com.tatsam.TatsamTask.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.tatsam.TatsamTask.repository.PriorityAreaUserRepository;

@Service
public class PriorityAreaUser  implements PriorityAreaUserInf{

	@Autowired
	private PriorityAreaUserRepository priorityAreaUserRepository;
	
	@Override
	public List<com.tatsam.TatsamTask.entity.PriorityAreaUser> getAllPriorityAreas() {
		
		return priorityAreaUserRepository.findAll();
	}

	@Override
	public void addPriorityOrderandSatisfactionRating(com.tatsam.TatsamTask.entity.PriorityAreaUser priorityAreaUser) {
		
		priorityAreaUserRepository.save(priorityAreaUser);
	}

}
