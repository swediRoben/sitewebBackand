
package com.site.siteweb.convert;

import com.site.siteweb.dto.AdresseDto;
import com.site.siteweb.entity.AdresseEntity;
import com.site.siteweb.helpers.DateHelper;

public class AdresseConvert {
    public static AdresseConvert getInstance() {
        return new AdresseConvert();
    }

     public AdresseDto toDto(AdresseEntity adresse) {
        AdresseDto dto = new AdresseDto();
        dto.setId(adresse.getId());
        dto.setMail(adresse.getMail());
        dto.setTelephone(adresse.getTelephone());
        dto.setTypemail(adresse.getTypemail());
        dto.setAdresse(adresse.getAdresse());
        dto.setDatedebut(DateHelper.toText(adresse.getDatedebut()));
        dto.setDatefin(DateHelper.toText(adresse.getDatefin())); 
        return dto;
     }

        public AdresseEntity toEntity(AdresseDto adresse) {
        AdresseEntity entity = new AdresseEntity();
        entity.setId(adresse.getId());
        entity.setMail(adresse.getMail());
        entity.setTelephone(adresse.getTelephone());
        entity.setTypemail(adresse.getTypemail());
        entity.setAdresse(adresse.getAdresse());
        entity.setDatedebut(DateHelper.toDate(adresse.getDatedebut()));
        entity.setDatefin(DateHelper.toDate(adresse.getDatefin())); 
        return entity;
     }
}
