package com.site.siteweb.service;
 
import java.util.Date;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import com.site.siteweb.convert.TokenConvert;
import com.site.siteweb.dto.LoginContent;
import com.site.siteweb.dto.TokenDto;
import com.site.siteweb.entity.TokenEntity;
import com.site.siteweb.repository.TokenRepository;

@Service
public class TokenService {
     @Autowired
     private TokenRepository repoTocken;

    public TokenDto createTocken(LoginContent login) {
        TokenEntity token=new TokenEntity();
       
        Date today = new Date();
        Date tomorrow = new Date(today.getTime() + (1000 * 60 * 60 * 24));
        String time=""+today.getTime();
        
        String encodedPassword = new BCryptPasswordEncoder().encode(login.getPassword()+""+login.getEmail()+"faraja"+time);
        token.setDatedebut(today);
        token.setDatedebut(tomorrow);
        token.setEmail(login.getEmail());
        token.setPassword(login.getPassword());
        token.setPasswordrolehash(encodedPassword);
        TokenEntity tokens=repoTocken.save(token);
        return TokenConvert.getInstance().toDto(tokens);
    }

     public boolean checkTocken(String token) {
        Date today = new Date(); 
        return repoTocken.checkToken(token,today);
    }

    public boolean deleteTocken(LoginContent login) {
         Date today = new Date(); 
         TokenEntity tokens=repoTocken.getByEmailAndPassword(login.getEmail(),login.getPassword(),today);  

         if (tokens!=null) {   
                repoTocken.deleteById(tokens.getId());
                return true; 
         }else{
            return false;
         }
    } 
        
}
