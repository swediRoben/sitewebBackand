package com.site.siteweb.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.site.siteweb.entity.ArticleEntity;
 
@Repository
public interface ArticleRepository  extends JpaRepository<ArticleEntity, Long> {
    
}
