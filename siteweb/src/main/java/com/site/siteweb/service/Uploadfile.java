package com.site.siteweb.service;
 
import java.io.*; 
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardCopyOption; 
import java.util.*; 
 
import org.springframework.core.io.ClassPathResource; 
import org.springframework.util.StreamUtils;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import jakarta.servlet.http.HttpServletResponse; 
public class Uploadfile {


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
 
    public String viewFile(Long id,String filename) { 
        String path = "src/main/resources/images/" + id + "/" + filename; 
        try {
           return path;
        } catch (Exception e) {

            return null;
        }
    }
 
    public void fromClasspathAsHttpServResp(HttpServletResponse response,Long id,String fileName) throws IOException { 
        String path = "src/main/resources/images/" + id + "/" + fileName;
        ClassPathResource imageFile = new ClassPathResource(path); 
        StreamUtils.copy(imageFile.getInputStream(), response.getOutputStream());
    }

    //enregistrer plusieur fichers en meme temps 
    public String uploardMulti(@RequestParam("file") MultipartFile[] file) throws IOException {
        int id = 1;
        Path path = Files.createDirectories(Paths.get("src/main/resources/images/" + id));//pour creer le nouveau dossier avec l'id de utilisateur
        List<Path> list = new ArrayList<>();
        try {

            for (MultipartFile fil : file) {
                InputStream inputStream = fil.getInputStream();
                String filename = fil.getOriginalFilename();
                // Path path= Paths.get("src/main/resources/images/"); //les chemair de recources/images
                String pathAdd = filename; //les fichier qu'on va ajouter dans les path. on peut utiliser id ou pas

                Path pathComplet = path.resolve(pathAdd);//completer les nom du fichier ou image
                //   File fil=new File(id);
                //   fil.createNewFile();
                Files.copy(inputStream, pathComplet, StandardCopyOption.REPLACE_EXISTING);
                list.add(pathComplet); //pour retourner les resultats
            }
            return "downloard";

        } catch (IOException e) {
            // throw new IOException("erreur "+filename,e);
            return "error to down load";
        }
    }
}
