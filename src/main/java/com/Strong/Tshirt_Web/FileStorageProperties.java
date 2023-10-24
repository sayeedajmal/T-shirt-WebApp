package com.Strong.Tshirt_Web;

import java.io.File;
import java.io.IOException;

import org.apache.commons.io.FilenameUtils;
import org.springframework.web.multipart.MultipartFile;

public class FileStorageProperties {
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
