package com.site.siteweb.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.site.siteweb.entity.AdresseEntity;

@Repository
public interface AdresseRepository extends JpaRepository<AdresseEntity, Long> {
    
}
