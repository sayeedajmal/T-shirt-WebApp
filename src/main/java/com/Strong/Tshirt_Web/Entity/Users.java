package com.Strong.Tshirt_Web.Entity;

import java.sql.Date;

import org.hibernate.annotations.CreationTimestamp;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;

@Entity
public class Users {
    @Id
    @GeneratedValue
    private Integer user_id;

    @Column(nullable = false)
    private String username;

    @Column(nullable = false)
    private String email;

    @Column(nullable = false)
    private String passowrd_hash;

    @Column(nullable = false)
    private String fname;

    private String lname;

    @Column(nullable = false)
    private String address;

    @Column(nullable = false)
    private String phone_number;

    @Column(nullable = false)
    @CreationTimestamp
    private Date Regdate;

    public Users() {

    }

    public Users(String username, String email, String passowrd_hash, String fname, String lname, String address,
            String phone_number) {
        this.username = username;
        this.email = email;
        this.passowrd_hash = passowrd_hash;
        this.fname = fname;
        this.lname = lname;
        this.address = address;
        this.phone_number = phone_number;
    }

    public Integer getUser_id() {
        return user_id;
    }

    public void setUser_id(Integer user_id) {
        this.user_id = user_id;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassowrd_hash() {
        return passowrd_hash;
    }

    public void setPassowrd_hash(String passowrd_hash) {
        this.passowrd_hash = passowrd_hash;
    }

    public String getFname() {
        return fname;
    }

    public void setFname(String fname) {
        this.fname = fname;
    }

    public String getLname() {
        return lname;
    }

    public void setLname(String lname) {
        this.lname = lname;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getPhone_number() {
        return phone_number;
    }

    public void setPhone_number(String phone_number) {
        this.phone_number = phone_number;
    }

    public Date getRegdate() {
        return Regdate;
    }

    public void setRegdate(Date regdate) {
        Regdate = regdate;
    }

    @Override
    public String toString() {
        return "Users [user_id=" + user_id + ", username=" + username + ", email=" + email + ", passowrd_hash="
                + passowrd_hash + ", fname=" + fname + ", lname=" + lname + ", address=" + address + ", phone_number="
                + phone_number + ", Regdate=" + Regdate + "]";
    }
}
