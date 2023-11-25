package com.Strong.Tshirt_Web.Controller;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.Strong.Tshirt_Web.Entity.AuthUsers;
import com.Strong.Tshirt_Web.Entity.Authorities;
import com.Strong.Tshirt_Web.Entity.AuthorityForm;
import com.Strong.Tshirt_Web.Service.AuthUserService;
import com.Strong.Tshirt_Web.Service.AuthoritiesService;

@RequestMapping("admin")
@Controller
public class AuthorityController {

    @Autowired
    private AuthUserService authUserService;

    @Autowired
    private AuthoritiesService authoritiesService;

    @GetMapping("/ShowAuthority")
    public ModelAndView ShowAuthority() {
        List<AuthUsers> authority = authUserService.findAll();
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

    @GetMapping("/GiveAuthority")
    public ModelAndView GiveAuthority(@RequestParam("id") Integer id, @RequestParam("name") String name, Model model) {
        List<Authorities> authorities = authoritiesService.findAllAuthority();
        AuthUsers user = authUserService.findById(id);
        AuthorityForm authorityForm = new AuthorityForm();
        /* Here we have to get the list of authorities from getting the AuthUserId */
        List<Authorities> authority_Id = user.getAuthorities();
        List<String> existing = new ArrayList<>();
        for (Authorities existingAuthoritesID : authority_Id) {
            existing.add(existingAuthoritesID.getAuthority());
        }
        authorityForm.setAuthorities(authorities);
        model.addAttribute("name", name);
        model.addAttribute("attributes", authorities);
        model.addAttribute("id", id);
        model.addAttribute("authorityForm", authorityForm);
        model.addAttribute("exist", existing);

        return new ModelAndView("GiveAuthority", "model", authorities);

    }

    @PostMapping("/GiveAuthority")
    public String GiveAuthority(@ModelAttribute("authorityForm") AuthorityForm authorityForm,
            @RequestParam("id") Integer id) {
        // Getting A list of selected Checkbox in the form of string
        List<String> selectedAuthoritesName = authorityForm.getSelectedAuthorities();
        // getting user id by passing the data from previous form
        AuthUsers user = authUserService.findById(id);
        // have to store in a object
        List<Authorities> authorities = new ArrayList<>();
        // Loop a list for getting the id of single authorities and add to above object
        for (String singleAuth : selectedAuthoritesName) {
            Authorities authority = authoritiesService.findByAuthority(singleAuth);
            authorities.add(authority);
        }
        // Here in @ManyToMany relationship in AuthUsers we have to update the user with
        // the authorities with adding the list of authorities in AuthUsers
        user.setAuthorities(authorities);
        authUserService.updateAuthUserAuthorities(user);
        return "redirect:/admin/ShowAuthority";
    }

}
