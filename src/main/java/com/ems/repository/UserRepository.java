package com.ems.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.ems.entity.User;

public interface UserRepository extends JpaRepository<User, Long>{

	public User findByUsername(String username);
	
	public User findByEmployeecode(String employeecode);
	
}
