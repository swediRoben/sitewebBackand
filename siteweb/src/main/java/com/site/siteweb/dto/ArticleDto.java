package com.site.siteweb.dto;

import java.sql.Date;
import lombok.Data;
@Data
public class ArticleDto {
    private Long id;
    private int type;
    private String idusercreate; 
    private String idusermodif;   
    private String urlfile; 
    private int typefichier;
    private String titre; 
    private String content;
    private int langue;  
    private Date datecreate;
    private Date dateupdate;   
}
