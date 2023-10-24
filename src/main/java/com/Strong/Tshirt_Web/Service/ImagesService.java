package com.Strong.Tshirt_Web.Service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.Strong.Tshirt_Web.Entity.Images;
import com.Strong.Tshirt_Web.Repository.ImagesRepo;

@Service
public class ImagesService {

    @Autowired
    ImagesRepo imagesRepo;

    public void saveImage(Images images) {
        imagesRepo.save(images);
    }

    public List<Images> getAllImages() {
        return imagesRepo.findAll();
    }

    public void DeleteImageById(Integer image_id) {
        imagesRepo.deleteById(image_id);
    }
}
