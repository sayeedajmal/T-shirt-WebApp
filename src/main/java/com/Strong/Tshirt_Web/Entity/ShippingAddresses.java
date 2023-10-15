package com.Strong.Tshirt_Web.Entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;

@Entity
public class ShippingAddresses {
    @Id
    @GeneratedValue
    private Integer shipping_address_id;

    @ManyToOne
    @JoinColumn(name = "order_id", nullable = false)
    private Orders order_id;

    @Column(nullable = false)
    private String recipient_name;

    @Column(nullable = false)
    private String street_address;

    @Column(nullable = false)
    private String city;

    @Column(nullable = false)
    private String state;

    @Column(nullable = false)
    private String postal_code;

    @Column(nullable = false)
    private String country;

    public ShippingAddresses() {

    }

    public ShippingAddresses(Orders order_id, String recipient_name, String street_address, String city, String state,
            String postal_code, String country) {
        this.order_id = order_id;
        this.recipient_name = recipient_name;
        this.street_address = street_address;
        this.city = city;
        this.state = state;
        this.postal_code = postal_code;
        this.country = country;
    }

    public Integer getShipping_address_id() {
        return shipping_address_id;
    }

    public void setShipping_address_id(Integer shipping_address_id) {
        this.shipping_address_id = shipping_address_id;
    }

    public Orders getOrder_id() {
        return order_id;
    }

    public void setOrder_id(Orders order_id) {
        this.order_id = order_id;
    }

    public String getRecipient_name() {
        return recipient_name;
    }

    public void setRecipient_name(String recipient_name) {
        this.recipient_name = recipient_name;
    }

    public String getStreet_address() {
        return street_address;
    }

    public void setStreet_address(String street_address) {
        this.street_address = street_address;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getState() {
        return state;
    }

    public void setState(String state) {
        this.state = state;
    }

    public String getPostal_code() {
        return postal_code;
    }

    public void setPostal_code(String postal_code) {
        this.postal_code = postal_code;
    }

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }

}
