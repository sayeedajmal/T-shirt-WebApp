package com.Strong.Tshirt_Web.Entity;

import java.sql.Date;
import java.util.ArrayList;
import java.util.List;

import org.hibernate.annotations.CreationTimestamp;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;

@Entity
public class Orders {

    @Id
    @GeneratedValue
    private Integer order_id;

    @ManyToOne
    @JoinColumn(name = "user_id", nullable = false)
    private Users user_id;

    @CreationTimestamp
    private Date order_date;

    public Orders() {

    }

    @OneToMany(mappedBy = "order_id", cascade = CascadeType.ALL) // Use mappedBy to specify the field in ShippingAddresses
    private List<ShippingAddresses> shippingAddresses = new ArrayList<>();

    public Orders(Users user_id, Date order_date, Float total_amount) {
        this.user_id = user_id;
        this.order_date = order_date;
        this.total_amount = total_amount;
    }

    @Column(nullable = false)
    private Float total_amount;

    public Integer getOrder_id() {
        return order_id;
    }

    public void setOrder_id(Integer order_id) {
        this.order_id = order_id;
    }

    public Users getUser_id() {
        return user_id;
    }

    public void setUser_id(Users user) {
        this.user_id = user;
    }

    public Date getOrder_date() {
        return order_date;
    }

    public void setOrder_date(Date order_date) {
        this.order_date = order_date;
    }

    public Float getTotal_amount() {
        return total_amount;
    }

    public void setTotal_amount(Float total_amount) {
        this.total_amount = total_amount;
    }

}