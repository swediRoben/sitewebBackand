package com.site.siteweb.service;

import java.util.Map;

import org.springframework.stereotype.Service;

import com.site.siteweb.dto.ArticleDto;

@Service
public class ArticleService {
 
    public Map<String, Object> getAlls(Long id, Long type, String description, int page, int size, 
            String[] sort) {
        return null;
    }

    public boolean add(ArticleDto article) {
        return false;
    }

    public boolean upDate(Long id, ArticleDto article) {
        return false;
    }

    public boolean delete(Long id) {
        return false;
    }    
    
}
