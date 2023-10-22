package com.site.siteweb.controller;
 
import static org.mockito.Mockito.description;

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
import com.site.siteweb.dto.UsersDto;
import com.site.siteweb.helpers.MessageHelper;
import com.site.siteweb.helpers.ResponseHelper;
import com.site.siteweb.service.UserService;

@RestController
@RequestMapping("/users")
@CrossOrigin(origins = "*")
public class UsersController {
    @Autowired
    private UserService service; 

    
        @GetMapping("/")
        public ResponseEntity<Object> getAll(
                        @RequestParam(required = false) Integer username,   
                        @RequestParam(defaultValue = "0") int page, 
                        @RequestParam(defaultValue = "0") int size,
                        @RequestHeader(name = "Accept-Language", required = false) String localeString,
                        @RequestParam(defaultValue = "id,desc") String[] sort){
                        if (size == 0)
                        size = Integer.MAX_VALUE;
 
                Map<String, Object> data = service.getAlls(username, page, size, sort);
                Locale locale = new Locale(localeString);

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
      public ResponseEntity<Object> add(@RequestHeader(name = "Accept-Language", required = false) String localeString,@RequestBody UsersDto user) { 
                boolean data = service.create(user);   
                if (data) { 
                        return new ResponseEntity<>(
                                        new ResponseHelper(MessageHelper.success(new Locale(localeString)),true),HttpStatus.CREATED);
                } else {
                        return new ResponseEntity<>(
                                        new ResponseHelper(MessageHelper.success(new Locale(localeString)),
                                                        false),
                                        HttpStatus.INTERNAL_SERVER_ERROR);
                }

        }

       @PutMapping("/{id}")
      public ResponseEntity<Object> update(@RequestHeader(name = "Accept-Language", required = false) String localeString,@PathVariable("id") Long id,@RequestBody UsersDto user) { 
                boolean data = service.upDate(id,user);   
                if (data) { 
                        return new ResponseEntity<>(
                                        new ResponseHelper(MessageHelper.success(new Locale(localeString)),true),HttpStatus.CREATED);
                } else {
                        return new ResponseEntity<>(
                                        new ResponseHelper(MessageHelper.success(new Locale(localeString)),
                                                        false),
                                        HttpStatus.INTERNAL_SERVER_ERROR);
                }

        }

       @PutMapping("/bloque/{id}")
      public ResponseEntity<Object> bloquer(@RequestHeader(name = "Accept-Language", required = false) String localeString,@PathVariable("id") Long id) { 
                boolean data = service.bloquer(id);   
                if (data) { 
                        return new ResponseEntity<>(
                                        new ResponseHelper(MessageHelper.success(new Locale(localeString)),true),HttpStatus.CREATED);
                } else {
                        return new ResponseEntity<>(
                                        new ResponseHelper(MessageHelper.success(new Locale(localeString)),
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
