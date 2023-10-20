package com.site.siteweb.dto;
 
import com.site.siteweb.constante.StaticValue;

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
    private String urlfile; 
    private Integer typefichier;
    private String titre; 
    private String content;
    private Integer langue;  
    private String datecreate;
    private String dateupdate;   
}
