package com.site.siteweb.service;
 
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import com.site.siteweb.convert.TokenConvert;
import com.site.siteweb.dto.LoginContent;
import com.site.siteweb.dto.TokenDto;
import com.site.siteweb.entity.TokenEntity;
import com.site.siteweb.helpers.DateHelper;
import com.site.siteweb.repository.TokenRepository;

@Service
public class TokenService {
     @Autowired
     private TokenRepository repoTocken;

    public TokenDto createTocken(LoginContent login) {
         List<TokenEntity> ckeck=repoTocken.getByEmailAndPasswords(login.getEmail(),login.getPassword());
        if (!ckeck.isEmpty()) {
               for (TokenEntity tokenEntity : ckeck) {
                 repoTocken.deleteById(tokenEntity.getId()); 
               }
              TokenEntity token=new TokenEntity();
       
                Date today = new Date();
                Date tomorrow = new Date(today.getTime() + (1000 * 60 * 60 * 24));
                String time=""+today.getTime();
              
                String encodedPassword = new BCryptPasswordEncoder().encode(login.getPassword()+""+login.getEmail()+"faraja"+time);
                token.setDatedebut(today);
                token.setDatfin(tomorrow); 
                token.setEmail(login.getEmail());
                token.setPassword(login.getPassword());
                token.setPasswordrolehash(encodedPassword);
                TokenEntity tokens=repoTocken.save(token);
                return TokenConvert.getInstance().toDto(tokens);
        }else{
              TokenEntity token=new TokenEntity();
       
                Date today = new Date();
                Date tomorrow = new Date(today.getTime() + (1000 * 60 * 60 * 24));
                String time=""+today.getTime();
                
                String encodedPassword = new BCryptPasswordEncoder().encode(login.getPassword()+""+login.getEmail()+"faraja"+time);
                token.setDatedebut(today);
                token.setDatfin(tomorrow); 
                token.setEmail(login.getEmail());
                token.setPassword(login.getPassword());
                token.setPasswordrolehash(encodedPassword);
                TokenEntity tokens=repoTocken.save(token);
                return TokenConvert.getInstance().toDto(tokens);
        }
      
    }

     public boolean checkTocken(String token) {
      String tokens = token;
      String[] parts = tokens.split(" "); 
      String value = parts[1]; 
         String dateFin ;
        TokenEntity tok=repoTocken.findByPasswordrolehash(value); 
        if (tok!=null) {
           dateFin = DateHelper.toText(tok.getDatfin());
        }else{
          dateFin="2000-01-01";
        }
         Date date = new Date();
         SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
        String today = dateFormat.format(date); 
       

       System.out.println("date debut :"+today +" date fin :"+dateFin);
         return DateHelper.verifyDate(today, dateFin); 
    } 
        
}
