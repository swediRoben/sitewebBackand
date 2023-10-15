package com.site.siteweb.dto;
 
import lombok.Data;
@Data
public class AdresseDto {
    private Long id;
    private String mail;
    private int typemail;
    private String telephone;  
    private String adresse;
    private String datedebut;
    private String datfin;
}
