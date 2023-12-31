package com.site.siteweb.convert;
 
import com.site.siteweb.dto.TokenDto;
import com.site.siteweb.entity.TokenEntity;
import com.site.siteweb.helpers.DateHelper;

public class TokenConvert {
     public static TokenConvert getInstance() {
        return new TokenConvert();
    }

     public TokenDto toDto(TokenEntity t) {
        TokenDto dto = new TokenDto();
        dto.setId(t.getId()); 
        dto.setPasswordrolehash(t.getPasswordrolehash());  
        return dto;
     }   

        public TokenEntity toDto(TokenDto t) {
        TokenEntity entity= new TokenEntity();
        entity.setId(t.getId()); 
        entity.setPasswordrolehash(t.getPasswordrolehash());
        entity.setEmail(t.getEmail());
        entity.setPassword(t.getPassword());
        entity.setDatedebut(DateHelper.toDate(t.getDatedebut())); 
        entity.setDatfin(DateHelper.toDate(t.getDatfin()));  

        return entity;
     } 
}
