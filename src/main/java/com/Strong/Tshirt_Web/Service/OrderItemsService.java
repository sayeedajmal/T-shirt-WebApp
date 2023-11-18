package com.Strong.Tshirt_Web.Service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.Strong.Tshirt_Web.Entity.OrderItems;
import com.Strong.Tshirt_Web.Repository.OrderItemsRepo;

@Service
public class OrderItemsService {

    @Autowired
    OrderItemsRepo orderItemsRepo;

    public void SaveOrder(OrderItems orderItems) {
        orderItemsRepo.save(orderItems);
    }

    public OrderItems getOrderItemById(Integer orderItemsId) {
        return orderItemsRepo.findById(orderItemsId).orElse(null);
    }

}
