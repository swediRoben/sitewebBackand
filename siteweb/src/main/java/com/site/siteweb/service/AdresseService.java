package com.site.siteweb.service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.site.siteweb.convert.AdresseConvert;
import com.site.siteweb.dto.AdresseDto;
import com.site.siteweb.entity.AdresseEntity;
import com.site.siteweb.repository.AdresseRepository;

@Service
public class AdresseService {

    @Autowired
    private AdresseRepository rep;
    public Map<String, Object> getAlls() {
        Map<String,Object> data=new HashMap<>();
        List<AdresseEntity> ad=rep.findAll();
        data.put("content", ad);
        return data;
    }

    public boolean add(AdresseDto adresse) {
        AdresseEntity d=AdresseConvert.getInstance().toEntity(adresse);
         try {
            rep.save(d);
            return true;
         } catch (Exception e) {
           return false;
         }
    }

    public boolean upDate(Long id, AdresseDto adresse) {
          adresse.setId(id);
          AdresseEntity d=AdresseConvert.getInstance().toEntity(adresse);
         try {
            rep.save(d);
            return true;
         } catch (Exception e) {
           return false;
         }
    }

    public boolean delete(Long id) {
       try {
          rep.deleteById(id);
         return true;
       } catch (Exception e) {
        return false;
       }
    }
    
}
