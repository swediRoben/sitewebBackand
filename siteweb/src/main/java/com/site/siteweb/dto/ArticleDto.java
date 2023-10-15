package com.site.siteweb.dto;
 
import lombok.Data;
@Data
public class ArticleDto {
    private Long id;
    private int type;
    private Long idusercreate; 
    private Long idusermodif;  
    private String usercreate; 
    private String usermodif;   
    private String urlfile; 
    private int typefichier;
    private String titre; 
    private String content;
    private int langue;  
    private String datecreate;
    private String dateupdate;   
}
