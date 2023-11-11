package com.site.siteweb.service;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import com.site.siteweb.convert.ArticleConvert;
import com.site.siteweb.dto.ArticleDto;
import com.site.siteweb.entity.ArticleEntity;
import com.site.siteweb.entity.ImageEntity;
import com.site.siteweb.helpers.PagingAndSortingHelper;
import com.site.siteweb.repository.ArticleRepository;
import com.site.siteweb.repository.ImageRepository;

@Service
public class ArticleService {
   @Autowired
   private ArticleRepository articleRepository;
   
   @Autowired
   private ImageRepository imgRepo;
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
           List<ImageEntity> img=imgRepo.findByIdArticle(g.getId());
            ArticleDto articleDto=ArticleConvert.getInstance().toDto(g); 
            if (articleDto.getTypefichier()!= null) {
              articleDto.setImage(Uploadfile.getInstance().viewFile(articleDto.getId(),img,articleDto.getTypefichier()));
          }
           list.add(articleDto); 
        }
     
        return PagingAndSortingHelper.filteredAndSortedResult(pg.getNumber(), pg.getTotalElements(),
                pg.getTotalPages(), list);
    }

    public boolean add(ArticleDto article,MultipartFile[] image) throws IOException {
        ArticleEntity data = ArticleConvert.getInstance().toEntity(article);

        try {
          Date current=new Date();
          data.setDatecreate(current);
          data.setDateupdate(current);
         ArticleEntity dataSave= articleRepository.save(data);
         if (dataSave.getTypefichier()==1) {
          ImageEntity img=new ImageEntity();
          img.setUrl(article.getUrlFile());
          img.setIdArticle(dataSave.getId());
          imgRepo.save(img);
         } else  if (dataSave.getTypefichier()==2) {
          List<String> listImg=Uploadfile.getInstance().uploardMultiPdf(image, dataSave.getId()); 
         for (String imag : listImg) {
          ImageEntity img=new ImageEntity();
          img.setUrl(imag);
          img.setIdArticle(dataSave.getId());
          imgRepo.save(img);
         } 
         } else {
         List<String> listImg=Uploadfile.getInstance().uploardMulti(image, dataSave.getId()); 
         for (String imag : listImg) {
          ImageEntity img=new ImageEntity();
          img.setUrl(imag);
          img.setIdArticle(dataSave.getId());
          imgRepo.save(img);
         } 
         }
          return true;  
        } catch (Exception e) {
          return false;
        }
        
    }

    public boolean upDate(Long id, ArticleDto article,MultipartFile[] image)  throws IOException {
         article.setId(id);
         ArticleEntity data = ArticleConvert.getInstance().toEntity(article);
        try { 
           Date current=new Date();
          data.setDateupdate(current);
          ArticleEntity dataSave=articleRepository.save(data);
          List<ImageEntity> all=imgRepo.findByIdArticle(dataSave.getId());
          for (ImageEntity f : all) {
           Uploadfile.getInstance().deleteFile(dataSave.getId(), f.getUrl());  
          }
          imgRepo.deleteAll(all);
          
         if (dataSave.getTypefichier()==0) {
          List<String> listImg=Uploadfile.getInstance().uploardMulti(image, dataSave.getId()); 
          for (String imag : listImg) {
          ImageEntity img=imgRepo.findByUrl(imag); 
          if (img==null) {
          ImageEntity im=new ImageEntity();
          im.setUrl(imag);
          im.setIdArticle(article.getId());
          imgRepo.save(im); 
          } 
         }
        }else if(dataSave.getTypefichier()==2) {
           List<String> listImg=Uploadfile.getInstance().uploardMultiPdf(image, dataSave.getId()); 
           for (String imag : listImg) {
          ImageEntity img=imgRepo.findByUrl(imag); 
          if (img==null) {
          ImageEntity im=new ImageEntity();
          im.setUrl(imag);
          im.setIdArticle(article.getId());
          imgRepo.save(im); 
          } 
         }
        }else{ 
          ImageEntity img=imgRepo.findByUrl(article.getUrlFile()); 
          if (img==null) {
          ImageEntity im=new ImageEntity();
          im.setUrl(article.getUrlFile());
          im.setIdArticle(article.getId());
          imgRepo.save(im);  
         }else{
           img.setUrl(article.getUrlFile());
          img.setIdArticle(article.getId());
          imgRepo.save(img);  
         } 
    
         } 
          return true;  
        } catch (Exception e) {
          return false;
        }
    }

    public boolean delete(Long id) {
       try {
          articleRepository.deleteById(id);
          List<ImageEntity> all=imgRepo.findByIdArticle(id);
          for (ImageEntity f : all) {
           Uploadfile.getInstance().deleteFile(id, f.getUrl());  
          }
          imgRepo.deleteAll(all);
         return true;
       } catch (Exception e) {
         return false;
       }
    }   
    
}
