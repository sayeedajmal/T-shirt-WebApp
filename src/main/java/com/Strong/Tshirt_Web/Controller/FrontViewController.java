package com.Strong.Tshirt_Web.Controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.Strong.Tshirt_Web.Entity.AuthUsers;
import com.Strong.Tshirt_Web.Entity.Images;
import com.Strong.Tshirt_Web.Entity.OrderItems;
import com.Strong.Tshirt_Web.Entity.Products;
import com.Strong.Tshirt_Web.Repository.ProductWithImage;
import com.Strong.Tshirt_Web.Service.AuthorityService;
import com.Strong.Tshirt_Web.Service.ProductService;
import com.Strong.Tshirt_Web.Utils.TShirtException;

@Controller
public class FrontViewController {
    @Autowired
    private ProductService productService;

    @Autowired
    private AuthorityService authorityService;

    /* ADMINPANEL Panel */
    @GetMapping("/AdminPanel")
    public String goAdmin() {
        return "AdminPanel";
    }

    /* Management Panel */
    @GetMapping("/ManagePanel")
    public String goManage() {
        return "ManagePanel";
    }

    @GetMapping("/PaymentTransactions")
    public String PaymentTransactions() {
        return "PaymentTransactions";
    }

    /* PRODUCT MANAGEMENT */
    @GetMapping("/")
    public ModelAndView ProductShow() {
        List<ProductWithImage> productsWithImages = productService.getProductWithImage();
        for (ProductWithImage productWithImage : productsWithImages) {
            Images image = productWithImage.getImage();
            if (image != null) {
                String imageUrl = image.getImage_url();
                productWithImage.setImage_url(imageUrl);
            }
        }
        return new ModelAndView("index", "Products", productsWithImages);
    }

    @GetMapping("/Tshirt-Show/{productId}")
    public ModelAndView getProductWithImages(@PathVariable Integer productId) {
        Products product = productService.getProductWithImages(productId);
        if (product != null) {
            List<String> imageUrls = new ArrayList<>();
            for (Images image : product.images) {
                imageUrls.add("/images/" + image.getImage_url());
            }
            ModelAndView modelAndView = new ModelAndView("TshirtView");
            modelAndView.addObject("product", product);
            modelAndView.addObject("imageUrls", imageUrls);
            return modelAndView;
        } else {
            return new ModelAndView("error-404");
        }
    }

    /* ORDER MANAGEMENT */
    @PostMapping("DoOrder")
    public String addToCart(@RequestParam("product_id") Integer product_id,
            @RequestParam("quantity") Integer quantity, @ModelAttribute OrderItems orderItems) {
        Products products = productService.getProductById(product_id);
        Float unit_Price = products.getPrice();
        float TotalPrice = unit_Price * quantity;

        // orderItemsService.SaveOrder(orderItems);
        return "redirect:login";
    }

    /* AUTHORITY MANAGEMENT */
    @GetMapping("/Authority")
    public String Authority() {
        return "Authority";
    }

    @PostMapping("/AddAuthority")
    public String AddAuthority(@ModelAttribute AuthUsers authority) throws TShirtException {
        authorityService.SaveAuthority(authority);
        return "redirect:/AdminPanel";
    }
}
