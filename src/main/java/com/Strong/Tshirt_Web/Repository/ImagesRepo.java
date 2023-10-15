package com.Strong.Tshirt_Web.Repository;


import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.Strong.Tshirt_Web.Entity.Images;

import jakarta.transaction.Transactional;

@Transactional
@Repository
public interface ImagesRepo extends JpaRepository<Images, Integer> {
}
