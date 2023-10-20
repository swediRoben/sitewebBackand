package com.site.siteweb.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import com.site.siteweb.convert.ArticleConvert;
import com.site.siteweb.dto.ArticleDto;
import com.site.siteweb.entity.ArticleEntity;
import com.site.siteweb.helpers.PagingAndSortingHelper;
import com.site.siteweb.repository.ArticleRepository;

@Service
public class ArticleService {
   @Autowired
   private ArticleRepository articleRepository;

    public Map<String, Object> getAlls(Long id, Integer type, Integer typeFichier,Integer langue,String description, int page, int size, 
            String[] sort) {
         List<ArticleDto> list = new ArrayList<>();
        Pageable pagingSort = PagingAndSortingHelper.pagination(sort, page, size);
        Page<ArticleEntity> pg = null; 

        if (id != null && type == null && typeFichier == null && description == null) {
            pg = articleRepository.findByIdAndLangue(id,langue, pagingSort);
        } else if (id == null && type != null && typeFichier == null && description == null) {
            pg = articleRepository.findByTypeAndLangue(type,langue, pagingSort);
        } else if (id == null && type != null && typeFichier != null && description == null) {
            pg = articleRepository.findByTypeAndLangueAndTypefichier(type,langue, typeFichier, pagingSort);
        } else if (id == null && type != null && typeFichier == null && description != null) {
            pg = articleRepository.getbyTypeAndDescription(type,langue, description, pagingSort);
        }else if (id == null && type != null && typeFichier != null && description != null) {
             pg = articleRepository.getbyTypeAndTypeFichierAndDescriptions(type,langue,typeFichier, description, pagingSort);
        } else {
            pg = articleRepository.findByLangue(langue,pagingSort);
        }

        List<ArticleEntity> dataEntity = pg.getContent(); 
        for (ArticleEntity g : dataEntity) { 
            ArticleDto articleDto=ArticleConvert.getInstance().toDto(g);  
           list.add(articleDto); 
        }
     
        return PagingAndSortingHelper.filteredAndSortedResult(pg.getNumber(), pg.getTotalElements(),
                pg.getTotalPages(), list);
    }

    public boolean add(ArticleDto article) {
        ArticleEntity data = ArticleConvert.getInstance().toEntity(article);
        try {
          articleRepository.save(data);
          return true;  
        } catch (Exception e) {
          return false;
        }
        
    }

    public boolean upDate(Long id, ArticleDto article) {
         article.setId(id);
         ArticleEntity data = ArticleConvert.getInstance().toEntity(article);
        try {
          articleRepository.save(data);
          return true;  
        } catch (Exception e) {
          return false;
        }
    }

    public boolean delete(Long id) {
       try {
        articleRepository.deleteById(id);
         return true;
       } catch (Exception e) {
         return false;
       }
    }    
    
}
