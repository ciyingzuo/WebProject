package com.example.WebProject.model;

import org.springframework.data.annotation.CreatedDate;

import javax.persistence.*;
import java.util.Date;

/**
 * User used to represent a User.
 *
 * @see Enum
 */
public class User {
    public static enum accountType {
        Faculty,
        Student,
        Admin;
    }

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer Id;
    private String firstName;
    private String lastName;
    private String password;
    private String username;
    @Enumerated(EnumType.STRING)
    private accountType role;
    private String phone;
    private String emailAddress;
    @Column(name = "date_of_birth")
    @CreatedDate
    private Date date_of_birth;

    public Integer getId() {
        return Id;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public Date getDate_of_birth() {
        return date_of_birth;
    }

    public void setDate_of_birth(Date date_of_birth) {
        this.date_of_birth = date_of_birth;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public accountType getRole() {
        return role;
    }

    public void setRole(accountType role) {
        this.role = role;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public void setPassowrd(String passowrd) {
        this.password = passowrd;
    }

    public void setEmailAddress(String emailAddress) {
        this.emailAddress = emailAddress;
    }

    public String getUsername() {
        return username;
    }

    public String getPassword() {
        return password;
    }

    public String getEmailAddress() {
        return emailAddress;
    }


    /**
     * Construct a invalid user which only contains username.
     *
     * @param username username
     */
    public void invalidUser(String username){
        this.firstName = "";
        this.lastName = "";
        this.username = username;
        this.date_of_birth = new Date();
        this.emailAddress = "";
        this.password = "";
        this.phone = "";
        this.role = accountType.Admin;
        this.Id = -1;
    }
}
