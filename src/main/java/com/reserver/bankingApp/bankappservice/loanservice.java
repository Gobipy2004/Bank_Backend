package com.reserver.bankingApp.bankappservice;

import java.time.LocalDateTime;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.reserver.bankingApp.entity.Loan;
import com.reserver.bankingApp.entity.User;
import com.reserver.bankingApp.exception.ResourceNotFoundException;
import com.reserver.bankingApp.repositary.bankapprepositary;
import com.reserver.bankingApp.repositary.loanrepositary;

@Service
public class loanservice {

    @Autowired
    private bankapprepositary bankrepo;

    @Autowired
    private loanrepositary loanrepo;



    // APPLY LOAN
    @Transactional
    public String applyloan(long userid, Loan loan) {
    	User user = bankrepo.findById(userid).orElseThrow(() -> new ResourceNotFoundException(

                        "user", "user id = ", userid));



        // important fields
        loan.setApplydate(LocalDateTime.now());

        loan.setStatus("PENDING");

        loan.setBalance(loan.getAmount());



        user.addloan(loan);



        bankrepo.save(user);



        return "Loan Applied Successfully";
    }



    // GET LOAN BY ID
    public Loan getloanbyid(long id) {

        return loanrepo.findById(id)

                .orElseThrow(() -> new ResourceNotFoundException(

                        "loan", "loan id ", id));
    }



    // DELETE LOAN
    @Transactional
    public String deleteloan(Long userid, Long loanid) {

        User user = bankrepo.findById(userid)

                .orElseThrow(() -> new ResourceNotFoundException(

                        "user", "user id = ", userid));



        Loan loan = loanrepo.findById(loanid)

                .orElseThrow(() -> new ResourceNotFoundException(

                        "loan", "loan id ", loanid));



        user.removeloan(loan);



        bankrepo.save(user);



        return "Loan Deleted Successfully";
    }



    // GET LOANS BY USER
    public List<Loan> getloanbyuserid(long userid) {

        return loanrepo.findByUserUid(userid);
    }



    // LOAN STATUS
    public String loanstatus(long id) {

        Loan loan = loanrepo.findById(id)

                .orElseThrow(() -> new ResourceNotFoundException(

                        "loan", "loan id ", id));



        return loan.getStatus();
    }



    // APPROVE LOAN
    public String approveLoan(long loanId) {

        Loan loan = loanrepo.findById(loanId)

                .orElseThrow(() -> new ResourceNotFoundException(

                        "loan", "loan id ", loanId));



        loan.setStatus("APPROVED");

        loan.setApprovaldate(LocalDateTime.now());

        loan.setDisbursermentdate(LocalDateTime.now());



        loanrepo.save(loan);



        return "Loan Approved Successfully";
    }



    // REJECT LOAN (optional)
    public String rejectLoan(long loanId) {

        Loan loan = loanrepo.findById(loanId)

                .orElseThrow(() -> new ResourceNotFoundException(

                        "loan", "loan id ", loanId));



        loan.setStatus("REJECTED");

        loan.setApprovaldate(LocalDateTime.now());



        loanrepo.save(loan);



        return "Loan Rejected";
    }
    
    public List<Loan> getAllLoans(){

        return loanrepo.findAll();
    }

}