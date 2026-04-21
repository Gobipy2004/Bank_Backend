package com.reserver.bankingApp.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import com.reserver.bankingApp.bankappservice.loanservice;
import com.reserver.bankingApp.entity.Loan;

@RestController
@RequestMapping("/api/loan")
@CrossOrigin(origins = "*")
public class loancontroller {

    @Autowired
    private loanservice loanser;



    // APPLY LOAN
    @PostMapping("/apply/{userid}")
    public String applyLoan(
            @PathVariable long userid,
            @RequestBody Loan loan
    ) {

        return loanser.applyloan(userid, loan);
    }



    // GET LOAN BY ID
    @GetMapping("/{loanid}")
    public Loan getLoanById(
            @PathVariable long loanid
    ) {

        return loanser.getloanbyid(loanid);
    }



    // GET ALL LOANS OF A USER
    @GetMapping("/user/{userid}")
    public List<Loan> getLoansByUser(
            @PathVariable long userid
    ) {

        return loanser.getloanbyuserid(userid);
    }



    // CHECK LOAN STATUS
    @GetMapping("/status/{loanid}")
    public String loanStatus(
            @PathVariable long loanid
    ) {

        return loanser.loanstatus(loanid);
    }



    // APPROVE LOAN (ADMIN)
    @PutMapping("/approve/{loanid}")
    public String approveLoan(
            @PathVariable long loanid
    ) {

        return loanser.approveLoan(loanid);
    }



    // REJECT LOAN (optional)
    @PutMapping("/reject/{loanid}")
    public String rejectLoan(
            @PathVariable long loanid
    ) {

        return loanser.rejectLoan(loanid);
    }



    // DELETE LOAN
    @DeleteMapping("/{userid}/{loanid}")
    public String deleteLoan(
            @PathVariable long userid,
            @PathVariable long loanid
    ) {

        return loanser.deleteloan(userid ,loanid);
    }
    
    
    @GetMapping("/all")
    public List<Loan> getAllLoans(){
        return loanser.getAllLoans();
    }

}