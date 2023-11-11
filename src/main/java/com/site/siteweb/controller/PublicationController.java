package com.site.siteweb.controller;
  
import java.io.IOException; 
import java.util.Collections; 
import java.util.Locale;
import java.util.Map; 
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.ClassPathResource; 
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.util.StreamUtils;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam; 
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import com.site.siteweb.dto.ArticleDto;
import com.site.siteweb.helpers.MessageHelper;
import com.site.siteweb.helpers.ResponseHelper;
import com.site.siteweb.service.ArticleService;

import jakarta.servlet.http.HttpServletResponse; 

@RestController
@RequestMapping("/publication")
@CrossOrigin(origins = "*")
public class PublicationController {

    @Autowired
    private ArticleService service;

        @GetMapping("/")
        public ResponseEntity<Object> getAll(
                        @RequestParam(required = false) Long id, 
                        @RequestParam(required = false) Integer type,
                        @RequestParam(required = false) Integer typeFichier,
                        @RequestParam(required = false) Integer langue,
                        @RequestParam(required = false) String description, 
                        @RequestParam(defaultValue = "0") int page, 
                        @RequestParam(defaultValue = "0") int size,
                        @RequestHeader(name = "Accept-Language", required = false) String localeString,
                        @RequestParam(defaultValue = "id,desc") String[] sort) {
                if (size == 0)
                        size = Integer.MAX_VALUE;
 
                Map<String, Object> data = service.getAlls(id,type,typeFichier,langue,description, page, size, sort);
                Locale locale = new Locale(localeString);

                if (data.size() > 0) {
                        return new ResponseEntity<>(new ResponseHelper(MessageHelper.success(locale), data, true),
                                        HttpStatus.OK);
                } else {
                        return new ResponseEntity<>(
                                        new ResponseHelper(MessageHelper.success(locale),
                                                        data.put("Is empty", Collections.emptyList()), false),
                                        HttpStatus.OK);
                }

        } 

        @GetMapping(value = "/file/{id}/{filename}")
        public void getfile(HttpServletResponse response,@PathVariable("id") String id,@PathVariable("filename") String filename) throws IOException { 
        String path = "/images/" + id + "/" + filename; 
        ClassPathResource imageFile = new ClassPathResource(path);    
        StreamUtils.copy(imageFile.getInputStream(), response.getOutputStream());
        }


        @PostMapping(value = "/")
        public ResponseEntity<Object> add(
                @RequestParam("file[]") MultipartFile[] file,
                @RequestHeader(name = "Accept-Language", required = false) String localeString,
                @ModelAttribute ArticleDto article)  throws IOException {  
                boolean data = service.add(article,file);  
       
                if (data) {
                    
                        return new ResponseEntity<>(
                                        new ResponseHelper(MessageHelper.createdSuccessfully(new Locale(localeString)),
                                                        true),
                                        HttpStatus.CREATED);
                } else {
                        return new ResponseEntity<>(
                                        new ResponseHelper(MessageHelper.internalServer(new Locale(localeString)),
                                                        false),
                                        HttpStatus.INTERNAL_SERVER_ERROR);
                }

        }

        @PutMapping("/{id}")
        public ResponseEntity<Object> upDate(
        @RequestParam("file") MultipartFile[] file,
        @PathVariable("id") Long id,
        @RequestHeader(name = "Accept-Language", required = false) String localeString,
        @ModelAttribute ArticleDto article ) throws IOException  { 
                boolean data = service.upDate(id,article,file);  
                if (data) {
                    
                        return new ResponseEntity<>(
                                        new ResponseHelper(MessageHelper.updatedSuccessFully(new Locale(localeString)),
                                                        true),
                                        HttpStatus.CREATED);
                } else {
                        return new ResponseEntity<>(
                                        new ResponseHelper(MessageHelper.internalServer(new Locale(localeString)),
                                                        false),
                                        HttpStatus.INTERNAL_SERVER_ERROR);
                }

        }

        @DeleteMapping("/{id}")
        public ResponseEntity<Object> daelete(@PathVariable("id") Long id,@RequestHeader(name = "Accept-Language", required = false) String localeString ) { 
                boolean data = service.delete(id);  
                if (data) {
                    
                        return new ResponseEntity<>(
                                        new ResponseHelper(MessageHelper.deletedSuccessFully(new Locale(localeString)),
                                                        true),
                                        HttpStatus.CREATED);
                } else {
                        return new ResponseEntity<>(
                                        new ResponseHelper(MessageHelper.deletedElementUsed(new Locale(localeString)),
                                                        false),
                                        HttpStatus.INTERNAL_SERVER_ERROR);
                }

        }

}
