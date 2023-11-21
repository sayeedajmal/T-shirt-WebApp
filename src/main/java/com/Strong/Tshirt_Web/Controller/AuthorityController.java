package com.Strong.Tshirt_Web.Controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.Strong.Tshirt_Web.Entity.AuthUsers;
import com.Strong.Tshirt_Web.Entity.Authorities;
import com.Strong.Tshirt_Web.Service.AuthUserService;
import com.Strong.Tshirt_Web.Service.AuthoritiesService;

@RequestMapping("admin")
@Controller
public class AuthorityController {

    @Autowired
    private AuthUserService AuthUserService;

    @Autowired
    private AuthoritiesService authoritiesService;

    @GetMapping("/ShowAuthority")
    public ModelAndView ShowAuthority() {
        List<AuthUsers> authority = AuthUserService.findAll();
        return new ModelAndView("ShowAuthority", "AllAuthority", authority);
    }

    @GetMapping("/AddAuthority")
    public String AddAuthority() {
        return "AddAuthority";
    }

    @PostMapping("/AddAuthority")
    public String AddAuthority(Authorities authority) {
        authoritiesService.SaveAuthority(authority);
        return "redirect:/admin/ShowAuthority";
    }
}
