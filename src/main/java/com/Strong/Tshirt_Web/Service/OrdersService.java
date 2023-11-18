package com.Strong.Tshirt_Web.Service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.Strong.Tshirt_Web.Entity.Orders;
import com.Strong.Tshirt_Web.Repository.OrdersRepo;

@Service
public class OrdersService {

    @Autowired
    private OrdersRepo ordersRepo;

    public Orders SaveOrder(Orders order) {
        return ordersRepo.save(order);
    }

    public Orders orderFindById(Integer order_id) {
        return ordersRepo.findById(order_id).orElse(null);
    }
}
