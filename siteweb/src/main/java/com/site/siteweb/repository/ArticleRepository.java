package com.site.siteweb.repository;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.site.siteweb.entity.ArticleEntity;
 
@Repository
public interface ArticleRepository  extends JpaRepository<ArticleEntity, Long> {

    Page<ArticleEntity> findById(Long id, Pageable pagingSort);

    Page<ArticleEntity> findByType(Integer type, Integer langue, Pageable pagingSort);

    Page<ArticleEntity> findByTypeAndTypeFichier(Integer type, Integer typeFichier, Integer typeFichier2, Pageable pagingSort);

    @Query("select e from ArticleEntity e  where e.type=?1 and e.langue=?2 and e.titre like '%' || ?3  || '%' or e.content  like '%' || ?3  || '%' ")
    Page<ArticleEntity> getbyTypeAndDescription(Integer type, Integer langue, String description, Pageable pagingSort);

    @Query("select e from ArticleEntity e  where e.type=?1 and and e.typeFichier=?2 and e.langue=?3 and e.titre like '%' || ?4  || '%' or e.content  like '%' || ?4  || '%' ")
    Page<ArticleEntity> getbyTypeAndTipeFichierAndDescription(Integer type, Integer typeFichier, Integer langue, String description,
            Pageable pagingSort);
    
}
