package com.tatsam.TatsamTask.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.tatsam.TatsamTask.entity.User;

@Repository
public interface UserRepository extends JpaRepository<User, Long> {

}
