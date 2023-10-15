package com.Strong.Tshirt_Web.Entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;

@Entity
public class OrderItems {
    @Id
    @GeneratedValue
    private Integer order_item_id;

    @ManyToOne
    @JoinColumn(name = "order_id", nullable = false)
    private Orders order_id;

    @ManyToOne
    @JoinColumn(name = "product_id", nullable = false)
    private Products product_id;

    @Column(nullable = false)
    private Integer quantity;

    @Column(nullable = false)
    private Float unit_price;

    public OrderItems(){
        
    }
    public OrderItems(Orders order_id, Products product_id, Integer quantity, Float unit_price) {
        this.order_id = order_id;
        this.product_id = product_id;
        this.quantity = quantity;
        this.unit_price = unit_price;
    }

    public Integer getOrder_item_id() {
        return order_item_id;
    }

    public void setOrder_item_id(Integer order_item_id) {
        this.order_item_id = order_item_id;
    }

    public Orders getOrder_id() {
        return order_id;
    }

    public void setOrder_id(Orders order_id) {
        this.order_id = order_id;
    }

    public Products getProduct_id() {
        return product_id;
    }

    public void setProduct_id(Products product_id) {
        this.product_id = product_id;
    }

    public Integer getQuantity() {
        return quantity;
    }

    public void setQuantity(Integer quantity) {
        this.quantity = quantity;
    }

    public Float getUnit_price() {
        return unit_price;
    }

    public void setUnit_price(Float unit_Price) {
        this.unit_price = unit_Price;
    }

}
