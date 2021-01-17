package com.tatsam.TatsamTask.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.tatsam.TatsamTask.entity.PriorityArea;

@Repository
public interface PriorityAreaRepository extends JpaRepository<PriorityArea, Long>{

}
