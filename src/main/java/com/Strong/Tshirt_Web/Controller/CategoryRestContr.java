package com.Strong.Tshirt_Web.Controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.Strong.Tshirt_Web.Entity.AuthUsers;
import com.Strong.Tshirt_Web.Repository.AuthUsersRepo;

@RestController
@RequestMapping("/api")
public class CategoryRestContr {
    @Autowired
    private AuthUsersRepo authUsersRepo;

    @Autowired
    private PasswordEncoder passwordEncoder;

    @GetMapping
    public ResponseEntity<List<AuthUsers>> listAuths() {
        List<AuthUsers> users = authUsersRepo.findAll();
        return ResponseEntity.ok(users);
    }

    @PostMapping("/createAuthUser")
    public ResponseEntity<String> createAuthUser(@RequestBody AuthUsers authUsers) {
        String pass_hash = passwordEncoder.encode(authUsers.getPassowrd_hash());
        authUsers.setPassowrd_hash(pass_hash);
        authUsersRepo.save(authUsers);
        return new ResponseEntity<>("User created successfully", HttpStatus.CREATED);
    }
}
