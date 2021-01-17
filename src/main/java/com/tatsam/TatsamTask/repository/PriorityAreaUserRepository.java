package com.tatsam.TatsamTask.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.tatsam.TatsamTask.entity.PriorityAreaUser;

@Repository
public interface PriorityAreaUserRepository extends JpaRepository<PriorityAreaUser, Long>{

}
