package com.Strong.Tshirt_Web.Entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

/**
 * Authorities
 */
@Entity
public class Authorities {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int auth_Id;

    @Column(nullable = false)
    private String auth_Name;

    @Column(nullable = false)
    private String authority;

    public Authorities(int auth_Id, String auth_Name, String authority) {
        this.auth_Id = auth_Id;
        this.auth_Name = auth_Name;
        this.authority = authority;
    }

    public Authorities() {
    }

    public int getAuth_Id() {
        return auth_Id;
    }

    public void setAuth_Id(int auth_Id) {
        this.auth_Id = auth_Id;
    }

    public String getAuth_Name() {
        return auth_Name;
    }

    public void setAuth_Name(String auth_Name) {
        this.auth_Name = auth_Name;
    }

    public String getAuthority() {
        return authority;
    }

    public void setAuthority(String authority) {
        this.authority = authority;
    }

}