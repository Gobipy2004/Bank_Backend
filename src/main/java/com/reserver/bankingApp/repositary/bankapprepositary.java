package com.reserver.bankingApp.repositary;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.reserver.bankingApp.entity.User;

public interface bankapprepositary extends JpaRepository<User, Long>{
	
	List<User> findByName(String name);

}
