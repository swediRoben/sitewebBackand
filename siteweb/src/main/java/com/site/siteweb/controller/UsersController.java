package com.site.siteweb.controller;
 
import java.util.Locale; 
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
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
