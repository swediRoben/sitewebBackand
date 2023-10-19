package com.site.siteweb.controller;

import java.util.Locale;

import org.apache.tomcat.util.descriptor.web.LoginConfig;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.http.StreamingHttpOutputMessage.Body;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.site.siteweb.dto.ArticleDto;
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
                if (data) {
                     TokenDto tok=token.createTocken(login);
                        return new ResponseEntity<>(
                                        new ResponseHelper(MessageHelper.loginSuccess(new Locale(localeString)),tok,
                                                        true),
                                        HttpStatus.CREATED);
                } else {
                        return new ResponseEntity<>(
                                        new ResponseHelper(MessageHelper.loginFail(new Locale(localeString)),
                                                        false),
                                        HttpStatus.INTERNAL_SERVER_ERROR);
                }

        }
}
