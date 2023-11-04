package com.site.siteweb.dto; 
import lombok.Data;
@Data
public class UsersDto {
    private Long id;
    private String nom;
    private String mail;
    private String password;  
    private int role;
    private String datedebut;
    private String datfin;
}
