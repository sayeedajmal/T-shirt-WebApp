package com.Strong.Tshirt_Web.Service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.Strong.Tshirt_Web.Entity.Categories;
import com.Strong.Tshirt_Web.Repository.CategoryRepo;
import com.Strong.Tshirt_Web.Utils.TShirtException;

@Service
public class CategoryService {

    @Autowired
    CategoryRepo categoryRepo;

    public void SaveCategory(Categories category) {
        Categories findByName = findByName(category.getName());
        if (findByName == null) {
            categoryRepo.save(category);
        } else
            throw new TShirtException("Category Name Already Defined:- " + category.getName(), new Throwable());
    }

    public void UpdateCategory(Categories existing) {
        Categories findByName = findByName(existing.getName());
        if (findByName != null && !findByName.getName().isEmpty()) {
            categoryRepo.save(existing);
        } else
            throw new TShirtException("Category Name Can't Be Empty", new Throwable());
    }

    public Categories getCategoryById(int category_id) {
        return categoryRepo.findById(category_id).orElse(null);
    }

    Categories findByName(String name) {
        Categories byName = categoryRepo.findByName(name);
        return byName;
    }

    public List<Categories> getAllCategories() {
        return categoryRepo.findAll();
    }

    public void DeleteById(Integer categoryId) {
        categoryRepo.deleteById(categoryId);
    }
}
