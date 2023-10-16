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

    public Categories getCategoryIdByProductId(int product_id) {
        Products product = productRepo.findById(product_id).orElse(null);
        return product.getCategories();
    }

    public Products getProductById(int product_id) {
        return productRepo.findById(product_id).orElse(null);
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

    public void DeleteProductById(int product_id) {
        productRepo.deleteById(product_id);
    }
}
