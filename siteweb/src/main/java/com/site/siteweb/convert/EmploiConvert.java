package com.site.siteweb.convert;
 
import com.site.siteweb.dto.EmploiDto; 
import com.site.siteweb.entity.EmploiEntity;
import com.site.siteweb.helpers.DateHelper;

public class EmploiConvert {
        public static EmploiConvert getInstance() {
        return new EmploiConvert();
    }

    public EmploiDto toDto(EmploiEntity emp) {
      EmploiDto dto = new EmploiDto();
      dto.setId(emp.getId());
      dto.setMail(emp.getMail()); 
      dto.setTelephone(emp.getTelephone());
      dto.setNom(emp.getNom());
      dto.setDatenaissance(DateHelper.toText(emp.getDatenaissance()));
      dto.setCv(emp.getCv());
      dto.setTypedemende(emp.getTypedemende());
      dto.setDisponibilite(emp.getDisponibilite());
      dto.setPost(emp.getPost());
      dto.setDate(DateHelper.toText(emp.getDate()));  

      return dto;
   }

   public EmploiEntity toEntity(EmploiDto emp) {
      EmploiEntity entity = new EmploiEntity();
      entity.setId(emp.getId());
      entity.setMail(emp.getMail()); 
      entity.setTelephone(emp.getTelephone());
      entity.setNom(emp.getNom());
      entity.setDatenaissance(DateHelper.toDate(emp.getDatenaissance()));
      entity.setCv(emp.getCv());
      entity.setTypedemende(emp.getTypedemende());
      entity.setDisponibilite(emp.getDisponibilite());
      entity.setPost(emp.getPost());
      entity.setDate(DateHelper.toDate(emp.getDate()));  

      return entity;
   }
}
  
