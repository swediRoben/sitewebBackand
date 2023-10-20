package com.site.siteweb.entity; 

import java.util.Date;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Data;
@Entity
@Data
@Table(name = "article")
public class ArticleEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", length = 11)
    private Long id;
    private Integer type;
    private Long idusercreate; 
    private Long idusermodif;   
    private String urlfile; 
    private Integer typefichier;
    private String titre; 
    private String content;
    private Integer langue;  
    private Date datecreate;
    private Date dateupdate;   
}
