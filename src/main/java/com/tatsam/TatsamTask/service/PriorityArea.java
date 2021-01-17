package com.tatsam.TatsamTask.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.tatsam.TatsamTask.entity.User;
import com.tatsam.TatsamTask.exception.ItamWsException;
import com.tatsam.TatsamTask.repository.PriorityAreaRepository;
import com.tatsam.TatsamTask.repository.UserRepository;

@Service
public class PriorityArea implements PriorityAreaInf{

	@Autowired
	private PriorityAreaRepository priorityAreaRepository;
	
	@Autowired
	private UserRepository userRepository;
	
	@Override
	public void addPriorityArea(com.tatsam.TatsamTask.entity.PriorityArea priorityArea, Long userId) {
		
		User user = userRepository.findById(userId).orElse(null);
		if (user != null) {
			if(user.getRole().equals("ADMIN")) {
				priorityAreaRepository.save(priorityArea);
			}else {
				throw new ItamWsException("User do not have permission to add {riority Area");
			}
		}
	}

}
