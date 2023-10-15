package com.Strong.Tshirt_Web.Controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import com.Strong.Tshirt_Web.Entity.Users;
import com.Strong.Tshirt_Web.Service.UerService;;

@Controller
public class UserController {

    @Autowired
    private UerService userService;

    @GetMapping("/Login")
    public String Login() {
        return "Login";
    }

    @GetMapping("/Signup")
    public String Signup() {
        return "Signup";
    }

    @PostMapping("/AddUser")
    public String AddUsers(@ModelAttribute Users user) {
        userService.AddUser(user);
        return "redirect:/AllUsers";
    }

    @GetMapping("/")
    public ModelAndView AllUsers() {
        List<Users> getAllUsers = userService.getAllUsers();
        return new ModelAndView("index", "Users", getAllUsers);
    }
}
