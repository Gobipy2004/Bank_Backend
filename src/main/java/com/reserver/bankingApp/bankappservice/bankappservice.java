package com.reserver.bankingApp.bankappservice;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.reserver.bankingApp.entity.User;
import com.reserver.bankingApp.exception.ResourceNotFoundException;
import com.reserver.bankingApp.repositary.bankapprepositary;

@Service
public class bankappservice {
	
	@Autowired
	private bankapprepositary bankrepo;
	
	//1.Get user By Id
	public User getbyid(long id) {
		return bankrepo.findById(id).orElseThrow(()->new ResourceNotFoundException("user","id",id));
	}
	
	//2.Create User
	public User createuser(User u) {
		return bankrepo.save(u);
	}
	
	//3.Delete User By Id
	public String delete(long id) {
		User u=bankrepo.findById(id).orElseThrow(()->new ResourceNotFoundException("user", "id", id));
		bankrepo.deleteById(id);
		return "Data Deleted";
	}
	
	//3.Fetch data By Name
	public List<User> searchbyname(String name){
		return bankrepo.findByName(name);
	}

}
