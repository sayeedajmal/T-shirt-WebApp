package com.Strong.Tshirt_Web.Utils;

import java.io.File;
import java.io.IOException;

import org.apache.commons.io.FilenameUtils;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.io.FileSystemResource;
import org.springframework.core.io.Resource;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@Configuration
public class StorageConfig implements WebMvcConfigurer {

    @Value("${image.upload.directory}")
    private String imageUploadDirectory;

    @Override
    public void addResourceHandlers(ResourceHandlerRegistry registry) {
        Resource resource = new FileSystemResource(System.getProperty("user.home") + imageUploadDirectory);
        try {
            registry.addResourceHandler("/images/**")
                    .addResourceLocations(resource.getURL().toString());
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static String UploadImage(MultipartFile file) {
        String timestamp = String.valueOf(System.currentTimeMillis());
        String extension = FilenameUtils.getExtension(file.getOriginalFilename());
        String FileName = timestamp + "." + extension;
        File destinationFile = new File(System.getProperty("user.home") + File.separator + "/Tshirt-Store",
                FileName);
        try {
            file.transferTo(destinationFile);
            return FileName;
        } catch (IllegalStateException | IOException e) {
            return "Error";
        }
    }
}
