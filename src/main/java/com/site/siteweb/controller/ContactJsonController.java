package com.site.siteweb.controller;

import java.util.Collections;
import java.util.Locale;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.site.siteweb.dtoJson.Contact;
import com.site.siteweb.helpers.MessageHelper;
import com.site.siteweb.helpers.ResponseHelper; 
import com.site.siteweb.service.ContactJsonService;

@RestController
@RequestMapping("/contact")
@CrossOrigin(origins = "*")
public class ContactJsonController {
     @Autowired
    private ContactJsonService service;

        @GetMapping("/")
        public ResponseEntity<Object> getAll(@RequestHeader(name = "Accept-Language", required = false) String localeString) { 
                Map<String, Object> data = service.getAlls(); 

                if (data.size() > 0) {
                        return new ResponseEntity<>(new ResponseHelper("adresse", data, true),
                                        HttpStatus.OK);
                } else {
                        return new ResponseEntity<>(
                                        new ResponseHelper("empty",
                                                        data.put("Is empty", Collections.emptyList()), false),
                                        HttpStatus.OK);
                }

        }

         @GetMapping("/by")
        public ResponseEntity<Object> getByIdAndLangue(@RequestHeader(name = "Accept-Language", required = false) String localeString,@RequestParam(required = false) Integer id,@RequestParam(required = false) Integer langue) { 
                Map<String, Object> data = service.getByIdAndLangue(id,langue); 

                if (data.size() > 0) {
                        return new ResponseEntity<>(new ResponseHelper("adresse", data, true),
                                        HttpStatus.OK);
                } else {
                        return new ResponseEntity<>(
                                        new ResponseHelper("empty",
                                                        data.put("Is empty", Collections.emptyList()), false),
                                        HttpStatus.OK);
                }

        }

        @GetMapping("/{id}")
        public ResponseEntity<Object> getById(@RequestHeader(name = "Accept-Language", required = false) String localeString,@PathVariable("id") Integer id) { 
                Map<String, Object> data = service.getById(id); 

                if (data.size() > 0) {
                        return new ResponseEntity<>(new ResponseHelper("adresse", data, true),
                                        HttpStatus.OK);
                } else {
                        return new ResponseEntity<>(
                                        new ResponseHelper("empty",
                                                        data.put("Is empty", Collections.emptyList()), false),
                                        HttpStatus.OK);
                }

        }


         @PostMapping("/")
        public ResponseEntity<Object> add(@RequestHeader(name = "Accept-Language", required = false) String localeString,@RequestBody Contact dto) { 
                boolean data = service.add(dto);  
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
        public ResponseEntity<Object> upDate(@PathVariable("id") Integer id,@RequestHeader(name = "Accept-Language", required = false) String localeString,@RequestBody Contact dto) { 
                boolean data = service.upDate(id,dto);  
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
        public ResponseEntity<Object> daelete(@PathVariable("id") Integer id,@RequestHeader(name = "Accept-Language", required = false) String localeString ) { 
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
