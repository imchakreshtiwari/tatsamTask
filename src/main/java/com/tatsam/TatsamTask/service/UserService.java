package com.tatsam.TatsamTask.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.tatsam.TatsamTask.entity.User;
import com.tatsam.TatsamTask.repository.UserRepository;

@Service
public class UserService  implements UserServiceInf{

	@Autowired
	private UserRepository userRepository;
	
	@Override
	public void addUser(User user) {
		userRepository.save(user);
	}

}
