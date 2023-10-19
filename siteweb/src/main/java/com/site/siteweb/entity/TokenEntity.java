package com.site.siteweb.entity;

import java.util.Date;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import jakarta.persistence.Temporal;
import jakarta.persistence.TemporalType;
import lombok.Data;

@Entity
@Data
@Table(name = "token")
public class TokenEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", length = 11)
    private Long id; 

    @Column(unique=true)
    private String passwordrolehash;

    private String email;   
    private String password;   
     @Temporal(TemporalType.DATE)
    private Date datedebut;
     @Temporal(TemporalType.DATE)
    private Date datfin;
}
