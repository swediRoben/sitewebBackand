package com.site.siteweb.controller;
 
import java.util.HashMap;
import java.util.Locale;
import java.util.Map;
 
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity; 
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
 
import com.site.siteweb.dto.LoginContent;
import com.site.siteweb.dto.TokenDto;
import com.site.siteweb.helpers.MessageHelper;
import com.site.siteweb.helpers.ResponseHelper;
import com.site.siteweb.service.TokenService;
import com.site.siteweb.service.UserService; 

@RestController
@RequestMapping("/login")
@CrossOrigin(origins = "*")
public class ConnectionController {
    @Autowired
    private UserService service;

    @Autowired
    private TokenService token;
    
      @PostMapping("/")
      public ResponseEntity<Object> add(@RequestHeader(name = "Accept-Language", required = false) String localeString,@RequestBody LoginContent login) { 
                boolean data = service.login(login);  
                Map<String,String> tokenMap=new HashMap<>(); 
                if (data) {
                     TokenDto tok=token.createTocken(login);
                     tokenMap.put("token", tok.getPasswordrolehash());
                        return new ResponseEntity<>(
                                        new ResponseHelper(MessageHelper.loginSuccess(new Locale(localeString)),tokenMap,
                                                        true),
                                        HttpStatus.CREATED);
                } else {
                        return new ResponseEntity<>(
                                        new ResponseHelper(MessageHelper.loginFail(new Locale(localeString)),
                                                        false),
                                        HttpStatus.INTERNAL_SERVER_ERROR);
                }

        }

      @GetMapping("/check/")
      public String checkpassword(@RequestHeader("Authorization") String jeton) {
        System.out.println(jeton);
        boolean d=token.checkTocken(jeton);
        if (d) {
           return "ca passe"; 
        } else {
           return "ca passe pas"; 
        }
      }  
}
