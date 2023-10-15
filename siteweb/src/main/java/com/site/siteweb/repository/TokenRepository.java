package com.site.siteweb.repository;

import org.springframework.data.jpa.repository.JpaRepository;
 
import com.site.siteweb.entity.TokenEntity;

public interface TokenRepository extends JpaRepository<TokenEntity, Long> {
    
}
