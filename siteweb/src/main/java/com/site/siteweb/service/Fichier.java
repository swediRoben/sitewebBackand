package com.site.siteweb.service;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

import org.springframework.core.io.Resource;
import org.springframework.core.io.UrlResource;
import org.springframework.web.multipart.MultipartFile; 

public class Fichier{
    private static final String UPLOAD_DIR = "src/main/resources/image"; 

       public static Fichier getInstance() {
        return new Fichier();
    }
    public String storeImage(MultipartFile file,Long id) throws IOException {
        String fileName = file.getOriginalFilename();
        Path uploadPath = Paths.get(UPLOAD_DIR+"/"+id+"/", fileName);
        Files.write(uploadPath, file.getBytes());
        return "/image/"+id+"/" + fileName;
    }

    
    public Resource loadImage(String imageUrl) throws IOException {
        Path filePath = Paths.get(imageUrl);
        Resource resource = new UrlResource(filePath.toUri());
        if (!resource.exists()) {
            throw new IOException("File not found: " + imageUrl);
        }
        return resource;
    }
}
