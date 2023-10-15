package com.site.siteweb.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.site.siteweb.entity.ArticleEntity;
 

public interface ArticleRepository  extends JpaRepository<ArticleEntity, Long> {
    
}
