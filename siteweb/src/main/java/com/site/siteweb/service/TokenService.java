package com.site.siteweb.service;

import org.springframework.stereotype.Service;

import com.site.siteweb.dto.LoginContent;
import com.site.siteweb.dto.TokenDto;

@Service
public class TokenService {

    public TokenDto createTocken(LoginContent login) {
        return null;
    }

     public boolean checkTocken(String login) {
        return true;
    }
    
}
