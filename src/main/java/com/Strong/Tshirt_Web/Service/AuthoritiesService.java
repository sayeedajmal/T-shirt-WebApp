package com.Strong.Tshirt_Web.Service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.Strong.Tshirt_Web.Entity.Authorities;
import com.Strong.Tshirt_Web.Repository.AuthoritiesRepo;
import com.Strong.Tshirt_Web.Utils.TShirtException;

@Service
public class AuthoritiesService {

    @Autowired
    private AuthoritiesRepo authoritiesRepo;

    public Authorities SaveAuthority(Authorities authority) {
        Authorities findByName = findByAuthority(authority.getAuthority());
        String Capital = authority.getAuthority().toUpperCase();
        authority.setAuthority(Capital);
        if (findByName == null) {
            return authoritiesRepo.save(authority);
        } else
            throw new TShirtException("Already Authority Named " + authority.getAuthority() + " is Saved.",
                    new Throwable());
    }

    public Authorities findByAuthority(String authority) {
        return authoritiesRepo.findByAuthority(authority);
    }

    public void DeleteAuthority(Authorities authority) {
        authoritiesRepo.delete(authority);
    }
}
