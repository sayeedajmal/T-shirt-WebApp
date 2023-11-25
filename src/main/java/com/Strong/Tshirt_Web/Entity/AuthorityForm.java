package com.Strong.Tshirt_Web.Entity;

import java.util.List;

public class AuthorityForm {
    // For Getting All Authorites from an AuthUser
    private List<Authorities> authorities;

    // Post the Selected Authorites from the html form to Entity by creating object
    // (AuthorityController)
    private List<String> selectedAuthorities;

    public AuthorityForm() {

    }

    public List<Authorities> getAuthorities() {
        return authorities;
    }

    public void setAuthorities(List<Authorities> authorities) {
        this.authorities = authorities;
    }

    public List<String> getSelectedAuthorities() {
        return selectedAuthorities;
    }

    public void setSelectedAuthorities(List<String> selectedAuthorities) {
        this.selectedAuthorities = selectedAuthorities;
    }

    
}
