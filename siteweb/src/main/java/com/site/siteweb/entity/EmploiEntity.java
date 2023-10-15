package com.site.siteweb.entity;
import java.util.Date;


import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Data;
@Data
@Entity
@Table(name = "emploi")
public class EmploiEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", length = 11)
    private Long id;
    private String nom; 
    private String mail; 
    private String telephone;
    private Data datenaissance; 
    private String adresse; 
    private String cv; 
    private int typedemende; 
    private String disponibilite;
    private String post;
    @Column(name = "message", length = 500)
    private String message;
    private Date date; 
}
