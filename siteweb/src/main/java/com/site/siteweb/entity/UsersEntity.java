package com.site.siteweb.entity;

import java.util.Date;

import jakarta.persistence.Column;import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Data; 
@Data
@Entity
@Table(name = "users")
public class UsersEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", length = 11)
    private Long id;
    private String nom;
    private String mail;
    private String password;  
    private int role;
    private Date datedebut;
    private Date datfin;
}
