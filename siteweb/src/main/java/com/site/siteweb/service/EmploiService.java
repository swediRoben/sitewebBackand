package com.site.siteweb.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import com.site.siteweb.convert.EmploiConvert; 
import com.site.siteweb.dto.EmploiDto; 
import com.site.siteweb.entity.EmploiEntity; 
import com.site.siteweb.helpers.PagingAndSortingHelper;
import com.site.siteweb.repository.EmploiRepository;

@Service
public class EmploiService {
     @Autowired
     private EmploiRepository repo;
    public Map<String, Object> getAlls(String name, Integer type, int page, int size, String[] sort) {
          List<EmploiDto> list = new ArrayList<>();
        Pageable pagingSort = PagingAndSortingHelper.pagination(sort, page, size);
        Page<EmploiEntity> pg = null; 

        if (name != null || name!="" && type==null) {
            pg = repo.getByName(name, pagingSort);
        }else if (name != null || name!="" && type!=null) {
            pg = repo.getByNameAndType(name, pagingSort);
        } if (name == null || name=="" && type!=null) {
            pg = repo.findByTypedemende(type, pagingSort);
        }  else{
            pg = repo.findAll(pagingSort);
        }

        List<EmploiEntity> dataEntity = pg.getContent(); 
        for (EmploiEntity g : dataEntity) { 
            EmploiDto emp=EmploiConvert.getInstance().toDto(g);  
           list.add(emp); 
        }
        return PagingAndSortingHelper.filteredAndSortedResult(pg.getNumber(), pg.getTotalElements(),
        pg.getTotalPages(), list);
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
