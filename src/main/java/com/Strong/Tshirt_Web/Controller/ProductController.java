package com.Strong.Tshirt_Web.Controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.Strong.Tshirt_Web.Entity.Categories;
import com.Strong.Tshirt_Web.Entity.Products;
import com.Strong.Tshirt_Web.Service.ProductService;

@Controller
public class ProductController {
    @Autowired
    private ProductService productService;

    @GetMapping("/TshirtView/{productId}")
    public ModelAndView getProductWithImages(@PathVariable Integer productId) {
        Products product = productService.getProductWithImages(productId);
        if (product != null) {
            return new ModelAndView("TshirtView", "product", product);
        } else {
            return new ModelAndView("error-404");
        }
    }

    @GetMapping("/ShowProducts")
    public ModelAndView ShowProducts() {
        List<Products> products = productService.getAllProducts();
        return new ModelAndView("ShowProducts", "AllProducts", products);
    }

    @PostMapping("/AddProduct")
    // HttpServletRequest request , @RequestParam("category_id") int categoryId
    public String addProduct(@ModelAttribute("product") Products product, @RequestParam("category_id") int categoryId) {
        Categories category = productService.getCategoryById(categoryId);
        if (category != null) {
            product.setCategories(category);
            productService.SaveProduct(product);
        }
        return "redirect:/ShowProducts";
    }

    /* Getting All Categories For Adding Product */
    @GetMapping("/AddProduct")
    public ModelAndView listCategories() {
        List<Categories> categories = productService.getAllCategories();
        return new ModelAndView("AddProduct", "categories", categories);
    }
}
