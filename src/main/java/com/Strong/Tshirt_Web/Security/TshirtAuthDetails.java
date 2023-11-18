package com.Strong.Tshirt_Web.Security;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.Strong.Tshirt_Web.Entity.AuthUsers;
import com.Strong.Tshirt_Web.Repository.AuthUsersRepo;

@Service
public class TshirtAuthDetails implements UserDetailsService {

    @Autowired
    AuthUsersRepo authUsersRepo;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        String userName, password = null;
        List<GrantedAuthority> authority = null;
        List<AuthUsers> authUsers = authUsersRepo.findByEmail(username);
        if (authUsers.size() == 0) {
            throw new UsernameNotFoundException("User Details Not Found for the User " + username);
        } else {
            userName = authUsers.get(0).getEmail();
            password = authUsers.get(0).getPassowrd_hash();
            authority = new ArrayList<>();
            authority.add(new SimpleGrantedAuthority("ADMIN"));
        }
        return new User(userName, password, authority);
    }

}
