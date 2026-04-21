package com.reserver.bankingApp.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.reserver.bankingApp.bankappservice.bankappservice;
import com.reserver.bankingApp.entity.User;

import jakarta.validation.Valid;

@RestController
@RequestMapping("/api/user")
@CrossOrigin(origins = "*")
public class bankappcontroller {
	
	@Autowired
	private bankappservice bankser;

	@GetMapping("/getbyid/{id}")
	public User getbyid(@PathVariable long id) {
		return bankser.getbyid(id);
	}
	
	@PostMapping("/save")
	public User save(@Valid @RequestBody User u) {
		return bankser.createuser(u);
	}
	
	@GetMapping("/fetchbyname/{name}")
	public List<User> fetchbyname(@PathVariable String name){
		return bankser.searchbyname(name);
	}
	
	@DeleteMapping("/deletebyid/{id}")
	public String delete(@PathVariable long id) {
		return bankser.delete(id);
	}
	
}
