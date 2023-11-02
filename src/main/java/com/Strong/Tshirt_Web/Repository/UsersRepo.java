package com.Strong.Tshirt_Web.Repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.Strong.Tshirt_Web.Entity.Users;

import jakarta.transaction.Transactional;

@Repository
@Transactional
public interface UsersRepo extends JpaRepository<Users, Integer> {

}
