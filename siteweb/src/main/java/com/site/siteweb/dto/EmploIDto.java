package com.site.siteweb.dto; 
 
import lombok.Data;
@Data 
public class EmploiDto { 
    private Long id;
    private String nom; 
    private String mail; 
    private String telephone;
    private String datenaissance; 
    private String adresse; 
    private String cv; 
    private int typedemende; 
    private String disponibilite;
    private String post; 
    private String message;
    private String date; 
}
