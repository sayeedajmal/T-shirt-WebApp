package com.Strong.Tshirt_Web.Security;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationProvider;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import com.Strong.Tshirt_Web.Entity.AuthUsers;
import com.Strong.Tshirt_Web.Entity.Authorities;
import com.Strong.Tshirt_Web.Repository.AuthUsersRepo;

@Service
public class TshirtAuthenProvider implements AuthenticationProvider {

    @Autowired
    private AuthUsersRepo authUsersRepo;
    @Autowired
    private PasswordEncoder passwordEncoder;
    private List<GrantedAuthority> authoritiesForUser;

    /*
     * HERE WE HAVE TO CREATE AN METHOD FOR AUTHENTICATION BY POSTING Email Id. and
     * getting the match with the authUser Repository and match the password with
     * encrypt and decrypt the password of both side and match. and aprove
     */
    @Override
    public Authentication authenticate(Authentication authentication) throws AuthenticationException {
        String email = authentication.getName();
        String password = authentication.getCredentials().toString();
        List<AuthUsers> authusers = authUsersRepo.findByEmail(email);
        if (authusers.size() <= 0) {
            throw new UsernameNotFoundException("Invalid User");
        }
        AuthUsers user = authUsersRepo.findByName(authusers.get(0).getName());
        if (authusers.size() > 0) {
            if (passwordEncoder.matches(password, authusers.get(0).getPassowrd_hash())) {
                authoritiesForUser = getAuthoritiesForUser(user);
                return new UsernamePasswordAuthenticationToken(email, password, authoritiesForUser);
            } else {
                throw new BadCredentialsException("Invalid Password");
            }
        } else {
            throw new BadCredentialsException("No User Registered With this Credentials");
        }
    }

    public List<GrantedAuthority> getAuthoritiesForUser(AuthUsers user) {
        List<Authorities> userAuthorities = user.getAuthorities();
        return userAuthorities.stream()
                .map(authority -> new SimpleGrantedAuthority(authority.getAuthority()))
                .collect(Collectors.toList());
    }

    @Override
    public boolean supports(Class<?> authentication) {
        return (UsernamePasswordAuthenticationToken.class.isAssignableFrom(authentication));
    }

}