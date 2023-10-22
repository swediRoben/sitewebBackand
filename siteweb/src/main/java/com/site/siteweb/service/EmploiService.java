package com.site.siteweb.service;

import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.site.siteweb.convert.EmploiConvert;
import com.site.siteweb.dto.EmploiDto;
import com.site.siteweb.entity.EmploiEntity;
import com.site.siteweb.repository.EmploiRepository;

@Service
public class EmploiService {
     @Autowired
     private EmploiRepository repo;
    public Map<String, Object> getAlls(Long id, Integer type, int page, int size, String[] sort) {
        return null;
    }

    public boolean add(EmploiDto emploiDto) {
        EmploiEntity p=EmploiConvert.getInstance().toEntity(emploiDto);
        try {
            repo.save(p);
            return true;
        } catch (Exception e) {
            return false;
        }
    }

    public boolean upDate(Long id, EmploiDto emploiDto) {
        emploiDto.setId(id);
         EmploiEntity p=EmploiConvert.getInstance().toEntity(emploiDto);
        try {
            repo.save(p);
            return true;
        } catch (Exception e) {
            return false;
        }
    }

    public boolean delete(Long id) { 
        try {
            repo.deleteById(id);
            return true;
        } catch (Exception e) {
            return false;
        }
    }
    
}
