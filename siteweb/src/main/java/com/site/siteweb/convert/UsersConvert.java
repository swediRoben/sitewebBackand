package com.site.siteweb.convert;
 
import com.site.siteweb.dto.UsersDto; 
import com.site.siteweb.entity.UsersEntity;
import com.site.siteweb.helpers.DateHelper;

public class UsersConvert {
       public static UsersConvert getInstance() {
        return new UsersConvert();
    }

     public UsersDto toDto(UsersEntity u) {
        UsersDto dto = new UsersDto();
        dto.setId(u.getId());
        dto.setNom(u.getNom()); 
        dto.setMail(u.getMail()); 
        dto.setPassword(u.getPassword()); 
        dto.setRole(u.getRole()); 
        dto.setDatedebut(DateHelper.toText(u.getDatedebut())); 
        dto.setDatfin(DateHelper.toText(u.getDatfin()));  

        return dto;
     }
     
         public UsersEntity toEntity(UsersDto u) {
        UsersEntity entity = new UsersEntity();
        entity.setId(u.getId());
        entity.setNom(u.getNom()); 
        entity.setMail(u.getMail()); 
        entity.setPassword(u.getPassword()); 
        entity.setRole(u.getRole()); 
        entity.setDatedebut(DateHelper.toDate(u.getDatedebut())); 
        entity.setDatfin(DateHelper.toDate(u.getDatfin()));  

        return entity;
     }
}
