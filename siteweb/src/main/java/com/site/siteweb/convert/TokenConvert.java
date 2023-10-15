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
        dto.setIduser(t.getIduser()); 
        dto.setPasswordrolehash(t.getPasswordrolehash());
        dto.setDatedebut(DateHelper.toText(t.getDatedebut())); 
        dto.setDatfin(DateHelper.toText(t.getDatfin()));  

        return dto;
     }   

        public TokenEntity toDto(TokenDto t) {
        TokenEntity entity= new TokenEntity();
        entity.setId(t.getId());
        entity.setIduser(t.getIduser()); 
        entity.setPasswordrolehash(t.getPasswordrolehash());
        entity.setDatedebut(DateHelper.toDate(t.getDatedebut())); 
        entity.setDatfin(DateHelper.toDate(t.getDatfin()));  

        return entity;
     } 
}
