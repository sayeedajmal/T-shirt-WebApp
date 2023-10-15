package com.Strong.Tshirt_Web.Controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class AdminController {

    @GetMapping("/AdminPanel")
    public String goAdmin() {
        return "AdminPanel";
    }

    @GetMapping("/PaymentTransactions")
    public String PaymentTransactions() {
        return "PaymentTransactions";
    }

}
