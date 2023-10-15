package com.Strong.Tshirt_Web.Entity;

import java.sql.Date;

import org.hibernate.annotations.CreationTimestamp;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.OneToOne;

@Entity
public class PaymentTransactions {
    @Id
    @GeneratedValue
    private Integer transaction_id;

    @OneToOne
    private Orders order_id;

    @CreationTimestamp
    private Date payment_date;

    public PaymentTransactions() {

    }

    public PaymentTransactions(Orders order_id, Date payment_date, String payment_method, String payment_status) {
        this.order_id = order_id;
        this.payment_date = payment_date;
        this.payment_method = payment_method;
        this.payment_status = payment_status;
    }

    @Column(nullable = false)
    private String payment_method;

    @Column(nullable = false)
    private String payment_status;

    public Integer getTransaction_id() {
        return transaction_id;
    }

    public void setTransaction_id(Integer transaction_id) {
        this.transaction_id = transaction_id;
    }

    public Orders getOrder_id() {
        return order_id;
    }

    public void setOrder_id(Orders order_id) {
        this.order_id = order_id;
    }

    public Date getPayment_date() {
        return payment_date;
    }

    public void setPayment_date(Date payment_date) {
        this.payment_date = payment_date;
    }

    public String getPayment_method() {
        return payment_method;
    }

    public void setPayment_method(String payment_method) {
        this.payment_method = payment_method;
    }

    public String getPayment_status() {
        return payment_status;
    }

    public void setPayment_status(String payment_status) {
        this.payment_status = payment_status;
    }

}
