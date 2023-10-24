package com.Strong.Tshirt_Web;

import java.io.IOException;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.io.FileSystemResource;
import org.springframework.core.io.Resource;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@Configuration
public class MvcConfig implements WebMvcConfigurer {

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
}
