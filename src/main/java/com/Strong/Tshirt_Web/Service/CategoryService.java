package com.Strong.Tshirt_Web.Service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.Strong.Tshirt_Web.Entity.Categories;
import com.Strong.Tshirt_Web.Repository.CategoryRepo;

@Service
public class CategoryService {

    @Autowired
    CategoryRepo categoryRepo;

    public void SaveCategory(Categories category) {
        categoryRepo.save(category);
    }

    public Categories getCategoryById(int category_id) {
        return categoryRepo.findById(category_id).orElse(null);
    }

    public List<Categories> getAllCategories() {
        return categoryRepo.findAll();
    }

    public void DeleteById(Integer categoryId) {
        categoryRepo.deleteById(categoryId);
    }
}
