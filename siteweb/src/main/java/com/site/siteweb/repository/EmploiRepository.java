package com.site.siteweb.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.site.siteweb.entity.EmploiEntity;

@Repository
public interface EmploiRepository extends JpaRepository<EmploiEntity, Long>  {
    
}
