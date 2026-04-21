package com.reserver.bankingApp.entity;

import java.time.LocalDateTime;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;

@Entity
public class Loan {
     
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	private double amount;
	private LocalDateTime applydate;
	private LocalDateTime approvaldate;
	private LocalDateTime disbursermentdate;
	private double balance;
	private String status;
	
	@ManyToOne
	@JoinColumn
	private User user;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public double getAmount() {
		return amount;
	}

	public void setAmount(double amount) {
		this.amount = amount;
	}

	public LocalDateTime getApplydate() {
		return applydate;
	}

	public void setApplydate(LocalDateTime applydate) {
		this.applydate = applydate;
	}

	public LocalDateTime getApprovaldate() {
		return approvaldate;
	}

	public void setApprovaldate(LocalDateTime approvaldate) {
		this.approvaldate = approvaldate;
	}

	public LocalDateTime getDisbursermentdate() {
		return disbursermentdate;
	}

	public void setDisbursermentdate(LocalDateTime disbursermentdate) {
		this.disbursermentdate = disbursermentdate;
	}

	public double getBalance() {
		return balance;
	}

	public void setBalance(double balance) {
		this.balance = balance;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}
	
	
	
	
}
