package com.site.siteweb.service;

import java.text.SimpleDateFormat;
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
        
        String encodedPassword = new BCryptPasswordEncoder().encode(login.getPassword()+""+login.getEmail()+"faraja");
        token.setDatedebut(today);
        token.setDatedebut(tomorrow);
        token.setEmail(login.getEmail());
        token.setPassword(login.getPassword());
        token.setPasswordrolehash(encodedPassword);
        TokenEntity tokens=repoTocken.save(token);
        return TokenConvert.getInstance().toDto(tokens);
    }

     public boolean checkTocken(String login) {
        Date today = new Date(); 
        return repoTocken.checkToken(login,today);
    }

    public boolean deleteTocken(LoginContent login) {
         Date today = new Date(); 
         TokenEntity tokens=repoTocken.findByEmailAndPassword(login.getEmail(),login.getPassword()); 
            SimpleDateFormat sdf = new SimpleDateFormat("d"); 

         if (tokens!=null) {
             String dayToday = sdf.format(today);
             String daydataBase = sdf.format(tokens.getDatfin());
               System.out.println("day est :"+dayToday);
               System.out.println("dayDatabase est :"+daydataBase);
             if (dayToday==daydataBase) {
                repoTocken.deleteById(tokens.getId());
                return true;
             }else{
                return false;
             }
         }else{
            return false;
         }
    }


        public boolean deleteByToken(String token) {
         Date today = new Date(); 
         TokenEntity tokens=repoTocken.findByPasswordrolehash(token); 
            SimpleDateFormat sdf = new SimpleDateFormat("d"); 

         if (tokens!=null) {
             String dayToday = sdf.format(today);
             String daydataBase = sdf.format(tokens.getDatfin());
               System.out.println("day est :"+dayToday);
               System.out.println("dayDatabase est :"+daydataBase);
             if (dayToday==daydataBase) {
                repoTocken.deleteById(tokens.getId());
                return true;
             }else{
                return false;
             }
         }else{
            return false;
         }
    }
        
}
