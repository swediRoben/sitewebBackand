package com.site.siteweb.service;
 
import java.io.IOException;
import java.io.InputStream;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardCopyOption;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import org.springframework.core.io.ClassPathResource;
import org.springframework.util.StreamUtils;
import org.springframework.web.multipart.MultipartFile;

import com.site.siteweb.entity.ImageEntity;

import jakarta.servlet.http.HttpServletResponse; 
public class Uploadfile {

    public static Uploadfile getInstance() {
        return new Uploadfile();
    }
    /* @GetMapping("/file")
   public ResponseEntity<?> uploard(@RequestParam("file") MultipartFile file)
    {
       String filename= file.getOriginalFilename();
        Long size= file.getSize();
        String content= file.getContentType();
        String name= file.getName();
        Map<String,Object> m=new LinkedHashMap<>();
        m.put("images filename",filename);
        m.put("images size",size);
        m.put("images content",content);
        m.put("images name",name);
       return new ResponseEntity<>(m, HttpStatus.OK);
    } */ 
    public String uploard(MultipartFile file,Long id) throws IOException { 
        String filename = file.getOriginalFilename(); 
            String pathAdd = filename;
            try (InputStream inputStream = file.getInputStream()) {
            Path path = Files.createDirectories(Paths.get("src/main/resources/images/" + id)); 
            Path pathComplet = path.resolve(pathAdd);
            Files.copy(inputStream, pathComplet, StandardCopyOption.REPLACE_EXISTING); 
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
           String path = "src/main/resources/images/" + id + "/" + img.getUrl(); 
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
                list.add(filename); //pour retourner les resultats
            }
            return list;
        } catch (IOException e) {
            return Collections.emptyList();
        }
    }
}
