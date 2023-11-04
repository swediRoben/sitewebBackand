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
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.site.siteweb.dto.EmploiDto;
import com.site.siteweb.helpers.MessageHelper;
import com.site.siteweb.helpers.ResponseHelper;
import com.site.siteweb.service.EmploiService;

@RestController
@RequestMapping("/emploi")
@CrossOrigin(origins = "*")
public class EmploiController {
        @Autowired
    private EmploiService service;

        @GetMapping("/")
        public ResponseEntity<Object> getAll(  
                        @RequestParam(required = false) String name,
                        @RequestParam(required = false) Integer type,   
                        @RequestParam(defaultValue = "0") int page, 
                        @RequestParam(defaultValue = "0") int size,
                        @RequestHeader(name = "Accept-Language", required = false) String localeString,
                        @RequestParam(defaultValue = "id,desc") String[] sort) {
                if (size == 0)
                        size = Integer.MAX_VALUE;
 
                Map<String, Object> data = service.getAlls(name,type, page, size, sort);
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


         @PostMapping("/")
        public ResponseEntity<Object> add(@RequestHeader(name = "Accept-Language", required = false) String localeString,@RequestBody EmploiDto emploiDto ) { 
                boolean data = service.add(emploiDto);  
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

        @PostMapping("/{id}")
        public ResponseEntity<Object> upDate(@PathVariable("id") Long id,@RequestHeader(name = "Accept-Language", required = false) String localeString,@RequestBody EmploiDto emploiDto ) { 
                boolean data = service.upDate(id,emploiDto);  
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
