package com.Strong.Tshirt_Web.Repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.Strong.Tshirt_Web.Entity.AuthUsers;

@Repository
public interface AuthUsersRepo extends JpaRepository<AuthUsers, Integer> {

    AuthUsers findByName(String name);

    List<AuthUsers> findByEmail(String authName);
}