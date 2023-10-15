package com.Strong.Tshirt_Web.Entity;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonIgnore;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;

@Entity
public class Products {
    @Id
    @GeneratedValue
    private Integer product_id;

    @Column(nullable = false)
    private String name;

    @Column(nullable = false)
    private String description;

    @Column(nullable = false)
    private Float price;

    @Column(nullable = false)
    private Integer stock_quentity;

    @ManyToOne()
    @JsonIgnore
    @JoinColumn(name = "category_id", nullable = false)
    private Categories categories;

    // Here's to Call The Images of a specific proudct
    @OneToMany(mappedBy = "product", fetch = FetchType.EAGER)
    public List<Images> images;

    public Products() {

    }

    public Products(String name, String description, Float price, Integer stock_quentity, Categories categories) {
        this.name = name;
        this.description = description;
        this.price = price;
        this.stock_quentity = stock_quentity;
        this.categories = categories;
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

    @Override
    public String toString() {
        return "Products [product_id=" + product_id + ", name=" + name + ", description=" + description + ", price="
                + price + ", stock_quentity=" + stock_quentity + ", categories=" + categories + "]";
    }

}
