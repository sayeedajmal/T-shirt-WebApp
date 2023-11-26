package com.Strong.Tshirt_Web.Entity;

import java.sql.Date;
import java.util.List;

import org.hibernate.annotations.CreationTimestamp;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.JoinTable;
import jakarta.persistence.ManyToMany;

@Entity
public class AuthUsers {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(nullable = false, unique = true)
    private String name;

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

    @ManyToMany(fetch = FetchType.EAGER)
    @JoinTable(name = "user_Authorities", joinColumns = @JoinColumn(name = "authority_Id"), inverseJoinColumns = @JoinColumn(name = "id"))
    private List<Authorities> authorities;

    public AuthUsers() {
    }

    public AuthUsers(Integer id, String name, String email, String phone_Number,
            String passowrd_hash,
            String address, Date regdate, boolean enabled) {
        this.id = id;
        this.name = name;
        this.email = email;
        this.phone_Number = phone_Number;
        this.passowrd_hash = passowrd_hash;
        this.address = address;
        this.regdate = regdate;
        this.Enabled = enabled;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
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

    public List<Authorities> getAuthorities() {
        return authorities;
    }

    public void setAuthorities(List<Authorities> authorities) {
        this.authorities = authorities;
    }

}
