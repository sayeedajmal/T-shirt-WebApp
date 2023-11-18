package com.Strong.Tshirt_Web.Service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.Strong.Tshirt_Web.Entity.Categories;
import com.Strong.Tshirt_Web.Entity.Products;
import com.Strong.Tshirt_Web.Repository.CategoryRepo;
import com.Strong.Tshirt_Web.Repository.ProductRepo;
import com.Strong.Tshirt_Web.Repository.ProductWithImage;
import com.Strong.Tshirt_Web.Utils.TShirtException;

@Service
public class ProductService {

    @Autowired
    private ProductRepo productRepo;
    @Autowired
    private CategoryRepo categoryRepo;

    public Products getProductWithImages(Integer productId) {
        return productRepo.findProductWithImages(productId);
    }

    Products findByName(String name) {
        return productRepo.findByName(name);
    }

    public List<ProductWithImage> getProductWithImage() {
        return productRepo.findProductsWithImage();
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

    public Products SaveProduct(Products product) {
        Products findByName = productRepo.findByName(product.getName());
        if (findByName == null) {
            return productRepo.save(product);
        } else
            throw new TShirtException("Already TShirt Name Defined: " + product.getName(), new Throwable());
    }

    public void DeleteProductById(int product_id) {
        productRepo.deleteById(product_id);
    }
}
