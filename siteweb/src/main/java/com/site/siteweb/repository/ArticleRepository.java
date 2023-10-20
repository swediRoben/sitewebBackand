package com.site.siteweb.repository;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.site.siteweb.entity.ArticleEntity;
 
@Repository
public interface ArticleRepository  extends JpaRepository<ArticleEntity, Long> {

    Page<ArticleEntity> findById(Long id, Pageable pagingSort);

    Page<ArticleEntity> findByType(Integer type, Integer langue, Pageable pagingSort);

    Page<ArticleEntity> findByTypeAndTypeFichier(Integer type, Integer typeFichier, Integer typeFichier2, Pageable pagingSort);

    Page<ArticleEntity> getbyTypeAndDescription(Integer type, Integer langue, String description, Pageable pagingSort);

    Page<ArticleEntity> getbyTypeAndTipeFichierAndDescription(Integer type, Integer typeFichier, Integer langue, String description,
            Pageable pagingSort);
    
}
