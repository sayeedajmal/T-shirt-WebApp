package com.Strong.Tshirt_Web.Controller;

import java.io.File;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;

import com.Strong.Tshirt_Web.Entity.Images;
import com.Strong.Tshirt_Web.Entity.Products;
import com.Strong.Tshirt_Web.Service.ImagesService;
import com.Strong.Tshirt_Web.Service.ProductService;
import com.Strong.Tshirt_Web.Utils.StorageConfig;

@Controller
@RequestMapping("manage")
public class ImagesController {

    @Autowired
    ImagesService imagesService;
    @Autowired
    ProductService productService;

    /* GET MAPPING */
    // Listing Products Id with Names
    @GetMapping("/AddImages")
    public ModelAndView listProducts() {
        List<Products> products = productService.getAllProducts();
        return new ModelAndView("AddImages", "allProducts", products);
    }

    @GetMapping("/ShowImages")
    public ModelAndView ListImages() {
        List<Images> allImages = imagesService.getAllImages();
        // Get The Directory where all images are stored..
        return new ModelAndView("ShowImages", "AllImages", allImages);
    }

    @Value("${image.upload.directory}")
    private String imageDir;

    @GetMapping("/DeleteImage")
    public String DeleteImage(@Param("image_id") Integer image_id, @Param("image_url") String image_url,
            Images images) {
        File file = new File(System.getProperty("user.home") + imageDir + image_url);

        if (file.delete()) {
            imagesService.DeleteImageById(image_id);
        }
        return "redirect:/manage/ShowImages";
    }

    /* POST MAPPING */

    /**
     * @param product_id
     * @param images
     * @param file
     * @return
     */
    @PostMapping("/AddImage")
    public String AddImage(@Param("product_id") Integer product_id, Images images,
            @RequestParam("imageFile") MultipartFile file) {
        Products product = productService.getProductById(product_id);

        // Passed The file to FireStorageProperties.Upload() to upload in it's directory
        // and return the file name
        String FileName = StorageConfig.UploadImage(file);
        if (FileName.contains("Error")) {
            System.out.println("ERROR : Check FileStorageProperties.UploadImage()");
            return "redirect:/error-404";
        } else {
            images.setProduct(product);
            images.setImage_url(FileName);
            imagesService.saveImage(images);
            return "redirect:/manage/ShowImages";
        }
    }

}
