package com.Strong.Tshirt_Web.Repository;

import com.Strong.Tshirt_Web.Entity.Categories;
import com.Strong.Tshirt_Web.Entity.Images;
import com.Strong.Tshirt_Web.Entity.Products;

public class ProductWithImage {
    private Products product;

    private Images image;

    private String image_url;

    private Integer product_id;

    private String name;

    private String description;

    private Float price;

    private Integer stock_quentity;

    private Categories categories;

    public ProductWithImage() {

    }

    public ProductWithImage(Products product, Images selectedImage) {
        this.product = product;
        this.image = selectedImage;
    }

    public Products getProduct() {
        return product;
    }

    public void setProduct(Products product) {
        this.product = product;
    }

    public Images getImage() {
        return image;
    }

    public void setImage(Images image) {
        this.image = image;
    }

    public Integer getProduct_id() {
        return product_id;
    }

    public void setProduct_id(Integer product_id) {
        this.product_id = product_id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Float getPrice() {
        return price;
    }

    public void setPrice(Float price) {
        this.price = price;
    }

    public Integer getStock_quentity() {
        return stock_quentity;
    }

    public void setStock_quentity(Integer stock_quentity) {
        this.stock_quentity = stock_quentity;
    }

    public Categories getCategories() {
        return categories;
    }

    public void setCategories(Categories categories) {
        this.categories = categories;
    }

    public String getImage_url() {
        return image_url;
    }

    public void setImage_url(String image_url) {
        this.image_url = image_url;
    }
}
