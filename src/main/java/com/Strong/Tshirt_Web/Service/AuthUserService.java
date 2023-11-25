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

    public AuthUsers updateAuthUserAuthorities(AuthUsers user) {
        AuthUsers existingUser = findByName(user.getName());
        if (existingUser != null) {
            existingUser.setAuthorities(user.getAuthorities());
            return authorityRepo.save(existingUser);
        } else {
            throw new TShirtException("User not found with name: " + user.getName(), new Throwable());
        }
    }

    AuthUsers findByName(String UserName) {
        AuthUsers username = authorityRepo.findByName(UserName);
        return username;
    }

    public List<AuthUsers> findAll() {
        return authorityRepo.findAll();
    }

    public AuthUsers findById(Integer id) {
        return authorityRepo.findById(id).orElse(null);
    }
}
