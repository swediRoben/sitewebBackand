package com.site.siteweb.repository;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.site.siteweb.entity.ArticleEntity;
 
@Repository
public interface ArticleRepository  extends JpaRepository<ArticleEntity, Long> { 
    @Query("select e FROM ArticleEntity e  WHERE e.type=?1 and e.langue=?2 and (e.titre like '%' || ?3  || '%' or e.content  like '%' || ?3  || '%') ")
    Page<ArticleEntity> getbyTypeAndDescription(Integer type, Integer langue, String description, Pageable pagingSort);

   
    Page<ArticleEntity> findByIdAndLangue(Long id, Integer langue, Pageable pagingSort);

    Page<ArticleEntity> findByTypeAndLangue(Integer type, Integer langue, Pageable pagingSort);
 
    Page<ArticleEntity> findByLangue(Integer langue, Pageable pagingSort);

    Page<ArticleEntity> findByTypeAndLangueAndTypefichier(Integer type, Integer langue, Integer typeFichier,
            Pageable pagingSort);

     @Query("select e FROM ArticleEntity e WHERE e.type=?1 and e.langue=?2 and e.typefichier=?3 and (e.titre like '%' || ?4  || '%' or e.content  like '%' || ?4  || '%') ")
    Page<ArticleEntity> getbyTypeAndTypeFichierAndDescriptions(Integer type, Integer langue, Integer typeFichier,String description, Pageable pagingSort);
    
}
