package com.Strong.Tshirt_Web.Entity;

import java.sql.Date;

import org.hibernate.annotations.CreationTimestamp;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;

@Entity
public class Returns {

    @Id
    @GeneratedValue
    private Integer return_id;

    @ManyToOne
    @JoinColumn(name = "order_id", nullable = false)
    private Orders order_id;

    @CreationTimestamp
    private Date return_date;

    @Column(nullable = false)
    private String reason;

    @Column(nullable = false)
    private String status;

    @Column(nullable = true)
    private Float refund_ammount;

    @Column(nullable = true)
    private String comments;

    public Returns() {

    }

    public Returns(Orders order_id, Date return_date, String reason, String status, Float refund_ammount,
            String comments) {
        this.order_id = order_id;
        this.return_date = return_date;
        this.reason = reason;
        this.status = status;
        this.refund_ammount = refund_ammount;
        this.comments = comments;
    }

    public Integer getReturn_id() {
        return return_id;
    }

    public void setReturn_id(Integer return_id) {
        this.return_id = return_id;
    }

    public Orders getOrder_id() {
        return order_id;
    }

    public void setOrder_id(Orders order_id) {
        this.order_id = order_id;
    }

    public Date getReturn_date() {
        return return_date;
    }

    public void setReturn_date(Date return_date) {
        this.return_date = return_date;
    }

    public String getReason() {
        return reason;
    }

    public void setReason(String reason) {
        this.reason = reason;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public Float getRefund_ammount() {
        return refund_ammount;
    }

    public void setRefund_ammount(Float refund_ammount) {
        this.refund_ammount = refund_ammount;
    }

    public String getComments() {
        return comments;
    }

    public void setComments(String comments) {
        this.comments = comments;
    }

}
