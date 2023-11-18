package com.Strong.Tshirt_Web.Repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.Strong.Tshirt_Web.Entity.AuthUsers;

@Repository
public interface AuthUsersRepo extends JpaRepository<AuthUsers, Integer> {

    AuthUsers findByauthName(String authName);

    List<AuthUsers> findByEmail(String authName);
}