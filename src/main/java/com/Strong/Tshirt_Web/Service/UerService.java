package com.Strong.Tshirt_Web.Service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.Strong.Tshirt_Web.Entity.Users;
import com.Strong.Tshirt_Web.Repository.UsersRepo;

@Service
public class UerService {

    @Autowired
    private UsersRepo usersRepo;

    public void AddUser(Users user) {
        usersRepo.save(user);
    }

    public List<Users> getAllUsers() {
        return usersRepo.findAll();
    }
}