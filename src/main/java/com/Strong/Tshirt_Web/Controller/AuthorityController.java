package com.Strong.Tshirt_Web.Controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.Strong.Tshirt_Web.Entity.AuthUsers;
import com.Strong.Tshirt_Web.Service.AuthorityService;

@RequestMapping("admin")
@Controller
public class AuthorityController {

    @Autowired
    private AuthorityService authorityService;

    @GetMapping("/ShowAuthority")
    public ModelAndView ShowAuthority() {
        List<AuthUsers> authority = authorityService.findAll();
        return new ModelAndView("ShowAuthority", "AllAuthority", authority);
    }
}
