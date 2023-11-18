package com.Strong.Tshirt_Web.Entity;

import java.sql.Date;
import org.hibernate.annotations.CreationTimestamp;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

@Entity
public class AuthUsers {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer authority_Id;

    @Column(nullable = false, unique = true)
    private String authName;

    @Column(nullable = false)
    private String email;

    @Column(nullable = false)
    private String phone_Number;

    @Column(nullable = false)
    private String passowrd_hash;

    @Column(nullable = false)
    private String address;

    @Column(nullable = false)
    @CreationTimestamp
    private Date regdate;

    @Column(nullable = false)
    private boolean Enabled;

    public AuthUsers() {
    }

    public AuthUsers(Integer authority_Id, String authName, String email, String phone_Number, String passowrd_hash,
            String address, Date regdate, boolean enabled) {
        this.authority_Id = authority_Id;
        this.authName = authName;
        this.email = email;
        this.phone_Number = phone_Number;
        this.passowrd_hash = passowrd_hash;
        this.address = address;
        this.regdate = regdate;
        this.Enabled = enabled;
    }

    public Integer getAuthority_Id() {
        return authority_Id;
    }

    public void setAuthority_Id(Integer authority_Id) {
        this.authority_Id = authority_Id;
    }

    public String getAuthName() {
        return authName;
    }

    public void setAuthName(String authName) {
        this.authName = authName;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPhone_Number() {
        return phone_Number;
    }

    public void setPhone_Number(String phone_Number) {
        this.phone_Number = phone_Number;
    }

    public String getPassowrd_hash() {
        return passowrd_hash;
    }

    public void setPassowrd_hash(String passowrd_hash) {
        this.passowrd_hash = passowrd_hash;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public Date getRegdate() {
        return regdate;
    }

    public void setRegdate(Date regdate) {
        this.regdate = regdate;
    }

    public boolean isEnabled() {
        return Enabled;
    }

    public void setEnabled(boolean enabled) {
        Enabled = enabled;
    }

}
