package com.Strong.Tshirt_Web.Entity;

import java.util.List;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToMany;

/**
 * Authorities
 */
@Entity
public class Authorities {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int authority_Id;

    @Column(nullable = false)
    private String authority;

    @ManyToMany(mappedBy = "authorities")
    private List<AuthUsers> authUsers;

    public Authorities(int authority_Id, String authority, List<AuthUsers> authUsers) {
        this.authority_Id = authority_Id;
        this.authority = authority;
        this.authUsers = authUsers;
    }

    
    public Authorities() {
    }

    public int getAuthority_Id() {
        return authority_Id;
    }

    public void setAuthority_Id(int authority_Id) {
        this.authority_Id = authority_Id;
    }

    public String getAuthority() {
        return authority;
    }

    public void setAuthority(String authority) {
        this.authority = authority;
    }

    public void setAuthUsers(List<AuthUsers> authUsers) {
        this.authUsers = authUsers;
    }

    public List<AuthUsers> getAuthUsers() {
        return authUsers;
    }

}