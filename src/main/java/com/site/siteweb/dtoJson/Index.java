package com.site.siteweb.dtoJson;

import lombok.Data;

@Data
public class Index {
    private Integer id;
    private String titre;
    private String description;
    private String titreContent; 
    private String content;
    private String imageUrl;
    private Integer langue;
}
