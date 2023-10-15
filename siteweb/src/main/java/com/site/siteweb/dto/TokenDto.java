package com.site.siteweb.dto; 
import lombok.Data;
@Data
public class TokenDto {
    private Long id;
    private Long iduser;
    private String passwordrolehash;   
    private String datedebut;
    private String datfin;
}
