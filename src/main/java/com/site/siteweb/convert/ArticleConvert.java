package com.site.siteweb.convert;

import com.site.siteweb.constante.StaticListOfValues;
import com.site.siteweb.constante.StaticValue;
import com.site.siteweb.dto.ArticleDto;
import com.site.siteweb.entity.ArticleEntity;
import com.site.siteweb.helpers.DateHelper;

public class ArticleConvert { 
    public static ArticleConvert getInstance() {
        return new ArticleConvert();
    }

     public ArticleDto toDto(ArticleEntity art) {
        ArticleDto dto = new ArticleDto();
        dto.setId(art.getId());
        dto.setType(art.getType()); 
			StaticListOfValues slove = new StaticListOfValues();
         if (art.getType()!=null) {
           		StaticValue sv = slove.getType().get(art.getType());
			dto.setTypes(sv);  
         } 
          if (art.getTypefichier()!=null) {
           		StaticValue sv = slove.getTypeFichier().get(art.getTypefichier());
			dto.setTypefichiers(sv); 
         } 
             if (art.getLangue()!=null) {
           		StaticValue sv = slove.getLangue().get(art.getLangue());
			dto.setLangues(sv); 
         } 
        dto.setIdusercreate(art.getIdusercreate());
        dto.setIdusermodif(art.getIdusermodif()); 
        dto.setTypefichier(art.getTypefichier());
        dto.setTitre(art.getTitre());
        dto.setContent(art.getContent());
        dto.setLangue(art.getLangue()); 
        dto.setDatecreate(DateHelper.toText(art.getDatecreate())); 
        dto.setDateupdate(DateHelper.toText(art.getDateupdate())); 

        return dto;
     }

        public ArticleEntity toEntity(ArticleDto art) {
        ArticleEntity entity = new ArticleEntity();
        entity.setId(art.getId());
        entity.setType(art.getType()); 
        entity.setTypefichier(art.getTypefichier());
        entity.setTitre(art.getTitre());
        entity.setContent(art.getContent());
        entity.setLangue(art.getLangue());  

        return entity;
     }
}
