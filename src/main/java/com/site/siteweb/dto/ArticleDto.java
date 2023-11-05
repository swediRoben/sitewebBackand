package com.site.siteweb.dto;
 
import java.util.List;

import com.site.siteweb.constante.StaticValue;
import com.site.siteweb.entity.ImageEntity;

import lombok.Data;
@Data
public class ArticleDto {
    private Long id;
    private Integer type;
    private StaticValue types;
    private Long idusercreate; 
    private Long idusermodif;  
    private String usercreate; 
    private String usermodif;   
    private List<ImageEntity> files; 
    private Integer typefichier;
    private String titre; 
    private String content;
    private Integer langue;  
    private String datecreate;
    private String dateupdate;  
    private String urlFile; 
}
