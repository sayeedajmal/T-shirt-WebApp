package com.Strong.Tshirt_Web.Repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;
import org.springframework.stereotype.Repository;

import com.Strong.Tshirt_Web.Entity.Categories;

import jakarta.transaction.Transactional;

@Transactional
@Repository
@RepositoryRestResource(path = "Categories")
public interface CategoryRepo extends JpaRepository<Categories, Integer> {

    Categories findByName(String name);

    @Query(name = "show_Categories", nativeQuery = true)
    List<Categories> showAll();
}
