package com.site.siteweb.service;
 
import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardCopyOption;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import javax.imageio.ImageIO;

import org.springframework.core.io.ClassPathResource;
import org.springframework.util.StreamUtils;
import org.springframework.web.multipart.MultipartFile;

import com.site.siteweb.entity.ImageEntity;

import jakarta.servlet.http.HttpServletResponse; 
    import java.awt.image.BufferedImage; 
public class Uploadfile {

    public static Uploadfile getInstance() {
        return new Uploadfile();
    } 
    public String uploard(MultipartFile file,Long id) throws IOException { 
        String filename = file.getOriginalFilename(); 
            String pathAdd = filename;
            try (InputStream inputStream = file.getInputStream()) {
            Path path = Files.createDirectories(Paths.get("src/main/resources/images/" + id)); 
            Path pathComplet = path.resolve(pathAdd);
            Files.copy(inputStream, pathComplet, StandardCopyOption.REPLACE_EXISTING); 
            resize(file,id+"/"+filename);
            return "download";
        } catch (IOException e) {
            return "error download";
        }

    } 
    public String deleteFile(Long id,String filename) {  
        Path path = Paths.get("src/main/resources/images/" + id + "/" + filename);
        try {
            Files.deleteIfExists(path);
            return "delete";
        } catch (IOException e) {

            return "error delete";
        }
    } 
       public String deleteMultiFile(Long id,List<String> filename) {   
        try {
          for (String f : filename) {
         Path path = Paths.get("src/main/resources/images/" + id + "/" + f);
             Files.deleteIfExists(path);
           }
            return "delete";
        } catch (IOException e) {

            return "error delete";
        }
    }
 
    public List<ImageEntity> viewFile(Long id,List<ImageEntity> image) { 
        List<ImageEntity> file=new ArrayList<>();
        try {
        for (ImageEntity img : image) {
           String path = id+"/"+img.getUrl(); 
           img.setPath(path);
           file.add(img); 
        }
          return file;
        } catch (Exception e) {
            return Collections.emptyList();
        }
    }
 
    public void fromClasspathAsHttpServResp(HttpServletResponse response,Long id,String fileName)  throws IOException { 
        String path = "src/main/resources/images/" + id + "/" + fileName;
        ClassPathResource imageFile = new ClassPathResource(path); 
        StreamUtils.copy(imageFile.getInputStream(), response.getOutputStream());
    }

    //enregistrer plusieur fichers en meme temps 
    public List<String> uploardMulti(MultipartFile[] file,Long id) throws IOException  {
        Path path = Files.createDirectories(Paths.get("src/main/resources/images/" + id));//pour creer le nouveau dossier avec l'id de utilisateur
        List<String> list = new ArrayList<>();
        try {

            for (MultipartFile fil : file) {
                InputStream inputStream = fil.getInputStream();
                String filename = fil.getOriginalFilename();
                String pathAdd = filename;  
                Path pathComplet = path.resolve(pathAdd);//completer les nom du fichier ou image
                Files.copy(inputStream, pathComplet, StandardCopyOption.REPLACE_EXISTING);
                resize(fil,id+"/"+filename);
                list.add(filename); //pour retourner les resultats
            }
            return list;
        } catch (IOException e) {
            return Collections.emptyList();
        }
    }

    public void resize(MultipartFile file,String idFilename) { 
        String fileName = ""+file.getOriginalFilename();
        String[] fileNameParts = fileName.split("\\."); 
        if (file.getSize()>100000) { 
             resized(idFilename,fileNameParts[1]);    
            }   
      } 
    
    public void resized(String idfndilename,String type) {
        try {
            // Charger l'image
            BufferedImage image = ImageIO.read(new File("src/main/resources/images/"+idfndilename));
            // Réduire la taille de l'image
            int width = image.getWidth() / 4;
            int height = image.getHeight() / 4;
            BufferedImage resizedImage = new BufferedImage(width, height, BufferedImage.TYPE_INT_RGB);
            for (int y = 0; y < height; y++) {
                for (int x = 0; x < width; x++) {
                    int color = image.getRGB(x * 4, y * 4);
                    resizedImage.setRGB(x, y, color);
                }
            }

            // Enregistrer l'image réduite
            ImageIO.write(resizedImage, type, new File("src/main/resources/images/"+idfndilename));
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public Long size(String string) {
        File file = new File("src/main/resources/images/"+string);
        long length = file.length();
        System.out.println("Length: " + length);
        return length;
     }
    
}
