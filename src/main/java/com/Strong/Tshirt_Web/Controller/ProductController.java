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

    @PostMapping("/UpdateProduct")
    public String UpdateProduct(@ModelAttribute("product") Products updatedProduct,
            @RequestParam("category_id") int categoryId, @RequestParam("product_id") int product_id) {
        Products existingProduct = productService.getProductById(product_id);
        if (existingProduct != null) {
            existingProduct.setName(updatedProduct.getName());
            existingProduct.setDescription(updatedProduct.getDescription());
            existingProduct.setPrice(updatedProduct.getPrice());
            existingProduct.setStock_quentity(updatedProduct.getStock_quentity());
            Categories category = productService.getCategoryById(categoryId);
            existingProduct.setCategories(category);

            productService.SaveProduct(existingProduct);
        }

        return "redirect:/ShowProducts";
    }

    // Retrive Data from Pickuped Product ID And Add the Category Id to product by
    // retrieve from proudct id
    @GetMapping("/ModifyProduct")
    public ModelAndView ModifyProductById(@RequestParam("product_id") int product_id) {
        Products product = productService.getProductById(product_id);
        Categories category = productService.getCategoryIdByProductId(product_id);
        product.setCategories(category);
        if (product.getProduct_id() != null) {
            return new ModelAndView("ModifyProduct", "Product", product);
        } else
            return new ModelAndView("error-404", "", null);
    }

    @GetMapping("/DeleteProduct")
    public String DeleteProductById(@RequestParam("product_id") int product_id) {
        productService.DeleteProductById(product_id);
        return "redirect:/ShowProducts";
    }

    @GetMapping("/ShowProducts")
    public ModelAndView ShowProducts() {
        List<Products> products = productService.getAllProducts();
        return new ModelAndView("ShowProducts", "AllProducts", products);
    }

    // HttpServletRequest request , @RequestParam("category_id") int categoryId
    @PostMapping("/AddProduct")
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
