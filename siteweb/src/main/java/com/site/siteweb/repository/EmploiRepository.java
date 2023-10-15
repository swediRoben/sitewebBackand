package com.site.siteweb.repository;

import org.springframework.data.jpa.repository.JpaRepository; 
import com.site.siteweb.entity.EmploiEntity;

public interface EmploiRepository extends JpaRepository<EmploiEntity, Long>  {
    
}
