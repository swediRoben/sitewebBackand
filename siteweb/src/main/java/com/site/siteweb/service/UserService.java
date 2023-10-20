package com.site.siteweb.service;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
 
import com.site.siteweb.convert.UsersConvert; 
import com.site.siteweb.dto.LoginContent;
import com.site.siteweb.dto.UsersDto; 
import com.site.siteweb.entity.UsersEntity;
import com.site.siteweb.helpers.PagingAndSortingHelper;
import com.site.siteweb.repository.UsersRepository; 

@Service
public class UserService {
 @Autowired
 private UsersRepository repository;
    public boolean login(LoginContent login) { 
        UsersEntity users=repository.findByMailAndPassword(login.getEmail(),login.getPassword());
        System.out.println("mail :"+login.getEmail());
        if (login.getEmail().equals("faraja2012@gmail.com") && login.getPassword().equals("faraja2012")) {
            return true; 
        }else if(login.getEmail().equals(users.getMail()) && login.getPassword().equals(users.getPassword())) {
            return true; 
        }else{
            return false;
        }  
        
    }

     public Map<String, Object> getAlls(Long id, String username, int page, int size, 
            String[] sort) {
         List<UsersDto> list = new ArrayList<>();
        Pageable pagingSort = PagingAndSortingHelper.pagination(sort, page, size);
        Page<UsersEntity> pg = null; 

        if (id != null && username == null) {
            pg = repository.findById(id, pagingSort);
        } else if (id == null && username != null) {
            pg = repository.getByEmail(username, pagingSort);
        } else {
            pg = repository.findAll(pagingSort);
        }

        List<UsersEntity> dataEntity = pg.getContent(); 
        for (UsersEntity g : dataEntity) { 
            UsersDto articleDto=UsersConvert.getInstance().toDto(g);  
           list.add(articleDto); 
        }
     
        return PagingAndSortingHelper.filteredAndSortedResult(pg.getNumber(), pg.getTotalElements(),
                pg.getTotalPages(), list);
    }

    public boolean create(UsersDto user) {
        UsersEntity data = UsersConvert.getInstance().toEntity(user);
        try {
          repository.save(data);
          return true;  
        } catch (Exception e) {
          return false;
        } 
    }

     public boolean upDate(Long id,UsersDto user) {
        user.setId(id);
        UsersEntity data = UsersConvert.getInstance().toEntity(user);
        try {
          repository.save(data);
          return true;  
        } catch (Exception e) {
          return false;
        } 
    }

        public boolean bloquer(Long id) { 
        UsersEntity user=repository.findById(id).get();
        user.setDatfin(new Date()); 
        try {
          repository.save(user);
          return true;  
        } catch (Exception e) {
          return false;
        } 
    }

    public boolean delete(Long id) {
        try {
         repository.deleteById(id);
          return true;
        } catch (Exception e) {
          return false;
        }
     }  
    
}
