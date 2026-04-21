package com.reserver.bankingApp.entity;

import java.util.HashSet;
import java.util.Set;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;

@Entity
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long uid;

    @NotBlank(message = "Name can not be Blank")
    private String name;

    @Email(message = "Enter Valid Email")
    @Column(unique = true, nullable = false)
    private String email;

    @NotBlank(message = "Password can not Blank")
    private String password;

    @OneToMany(cascade = CascadeType.ALL, mappedBy = "user")
    private Set<Loan> loans = new HashSet<>();


    public void addloan(Loan loan) {
        loans.add(loan);
        loan.setUser(this);
    }

    public void removeloan(Loan loan) {
        loans.remove(loan);
        loan.setUser(null);
    }


    public Long getUid() {   // ⭐ fix here
        return uid;
    }

    public void setUid(Long uid) {
        this.uid = uid;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
}