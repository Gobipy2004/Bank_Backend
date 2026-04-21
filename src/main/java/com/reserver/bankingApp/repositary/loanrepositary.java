package com.reserver.bankingApp.repositary;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.reserver.bankingApp.entity.Loan;


public interface loanrepositary extends JpaRepository<Loan, Long>{

	List<Loan> findByUserUid(long uid); 
}
