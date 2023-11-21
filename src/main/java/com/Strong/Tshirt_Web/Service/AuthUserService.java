package com.Strong.Tshirt_Web.Service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.Strong.Tshirt_Web.Entity.AuthUsers;
import com.Strong.Tshirt_Web.Repository.AuthUsersRepo;
import com.Strong.Tshirt_Web.Utils.TShirtException;

@Service
public class AuthUserService {

    @Autowired
    private AuthUsersRepo authorityRepo;

    public AuthUsers SaveAuthUser(AuthUsers authority) {
        AuthUsers findByName = findByName(authority.getName());
        if (findByName == null) {
            return authorityRepo.save(authority);
        } else
            throw new TShirtException("Auth Name Already Defined:- " + authority.getName(), new Throwable());
    }

    AuthUsers findByName(String UserName) {
        AuthUsers username = authorityRepo.findByName(UserName);
        return username;
    }

    public List<AuthUsers> findAll() {
        return authorityRepo.findAll();
    }
}
