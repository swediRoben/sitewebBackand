package com.site.siteweb.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.site.siteweb.entity.ImageEntity;

@Repository
public interface ImageRepository extends JpaRepository<ImageEntity,Long>{

    List<ImageEntity> findByIdArticle(Long idArticle);

    ImageEntity findByUrl(String imag);

    void deleteAllByIdArticle(Long idArticle);
    
}
