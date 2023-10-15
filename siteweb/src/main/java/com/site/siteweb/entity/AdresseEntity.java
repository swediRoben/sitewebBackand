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
@Table(name = "adresse")
public class AdresseEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", length = 11)
    private Long id;
    private String mail;
    private int typemail;
    private String telephone;  
    private String adresse;
    private Date datedebut;
    private Date datefin;
}
