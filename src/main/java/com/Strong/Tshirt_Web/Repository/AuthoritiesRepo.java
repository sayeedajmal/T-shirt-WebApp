package com.Strong.Tshirt_Web.Repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.Strong.Tshirt_Web.Entity.Authorities;

@Repository
public interface AuthoritiesRepo extends JpaRepository<Authorities, Integer> {

    Authorities findByAuthority(String authority);
}
