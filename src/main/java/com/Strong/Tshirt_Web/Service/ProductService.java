package com.Strong.Tshirt_Web.Service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.Strong.Tshirt_Web.Entity.Categories;
import com.Strong.Tshirt_Web.Entity.Products;
import com.Strong.Tshirt_Web.Repository.CategoryRepo;
import com.Strong.Tshirt_Web.Repository.ProductRepo;

@Service
public class ProductService {

    @Autowired
    private ProductRepo productRepo;
    @Autowired
    private CategoryRepo categoryRepo;

    public Products getProductWithImages(Integer productId) {
        return productRepo.findProductWithImages(productId);
    }

    public List<Products> getAllProducts() {
        return productRepo.findAll();
    }

    /* Getting List of Categories To show in DropDown */
    public List<Categories> getAllCategories() {
        return categoryRepo.findAll();
    }

    public Categories getCategoryById(Integer id) {
        return categoryRepo.findById(id).orElse(null);
    }

    public void SaveProduct(Products product) {
        productRepo.save(product);
    }
}
