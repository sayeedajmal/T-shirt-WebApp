package com.Strong.Tshirt_Web.Controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("admin")
public class OrdersController {

    @GetMapping("/orders")
    public String ShowOrders() {

        return "orders";
    }
}
