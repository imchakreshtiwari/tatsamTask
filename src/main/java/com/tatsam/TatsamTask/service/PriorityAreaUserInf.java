package com.tatsam.TatsamTask.service;

import java.util.List;

import com.tatsam.TatsamTask.entity.PriorityAreaUser;

public interface PriorityAreaUserInf {

	public List<PriorityAreaUser> getAllPriorityAreas();
	
	public void addPriorityOrderandSatisfactionRating(PriorityAreaUser priorityAreaUser);
	
}
