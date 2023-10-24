package com.Strong.Tshirt_Web.Entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;

@Entity
public class Images {
    @Id
    @GeneratedValue
    private Integer image_id;

    @ManyToOne
    @JoinColumn(name = "Product", nullable = false)
    private Products product;

    @Column(nullable = false)
    private String image_url;

    public Images() {

    }

    public Images(Products product, String image_url) {
        this.product = product;
        this.image_url = image_url;
    }

    public Products getProduct() {
        return product;
    }

    public void setProduct(Products products) {
        this.product = products;
    }

    public String getImage_url() {
        return image_url;
    }

    public void setImage_url(String image_url) {
        this.image_url = image_url;
    }

    public Integer getImage_id() {
        return image_id;
    }

    public void setImage_id(Integer image_id) {
        this.image_id = image_id;
    }
}
