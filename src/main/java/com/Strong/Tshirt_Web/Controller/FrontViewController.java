package com.Strong.Tshirt_Web.Controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.servlet.ModelAndView;

import com.Strong.Tshirt_Web.Entity.Images;
import com.Strong.Tshirt_Web.Entity.Products;
import com.Strong.Tshirt_Web.Repository.ProductWithImage;
import com.Strong.Tshirt_Web.Service.ProductService;

@Controller
public class FrontViewController {
    @Autowired
    private ProductService productService;

    @GetMapping("/Tshirt-Show/{productId}")
    public ModelAndView getProductWithImages(@PathVariable Integer productId) {
        Products product = productService.getProductWithImages(productId);
        if (product != null) {
            return new ModelAndView("TshirtView", "product", product);
        } else {
            return new ModelAndView("error-404");
        }
    }

    @GetMapping("/")
    public ModelAndView ProductShow() {
        List<ProductWithImage> productsWithImages = productService.getProductWithImage();
        for (ProductWithImage productWithImage : productsWithImages) {
            Images image = productWithImage.getImage();
            if (image != null) {
                String imageUrl = image.getImage_url();
                // Log the value of the imageUrl variable.
                System.out.println("imageUrl: " + imageUrl);
                // Set the imageUrl field in the ProductWithImage object.
                productWithImage.setImage_url(imageUrl);
            }
        }
        return new ModelAndView("index", "Products", productsWithImages);
    }
}
