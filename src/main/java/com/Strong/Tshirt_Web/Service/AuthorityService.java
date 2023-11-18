package com.Strong.Tshirt_Web.Service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.Strong.Tshirt_Web.Entity.AuthUsers;
import com.Strong.Tshirt_Web.Repository.AuthUsersRepo;
import com.Strong.Tshirt_Web.Utils.TShirtException;

@Service
public class AuthorityService {

    @Autowired
    private AuthUsersRepo authorityRepo;

    public AuthUsers SaveAuthority(AuthUsers authority) {
        AuthUsers findByName = findByName(authority.getAuthName());
        if (findByName == null) {
            return authorityRepo.save(authority);
        } else
            throw new TShirtException("Auth Name Already Defined:- "+authority.getAuthName(), new Throwable());
    }

    AuthUsers findByName(String UserName) {
        AuthUsers username = authorityRepo.findByauthName(UserName);
        return username;
    }

    public List<AuthUsers> findAll() {
        return authorityRepo.findAll();
    }
}
