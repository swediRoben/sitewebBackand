package com.site.siteweb.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.site.siteweb.dto.LoginContent;
import com.site.siteweb.entity.UsersEntity;
import com.site.siteweb.repository.UsersRepository; 

@Service
public class UserService {
 @Autowired
 private UsersRepository repository;
    public boolean login(LoginContent login) {
       UsersEntity users= repository.findByMailAndPassword(login.getEmail(),login.getPassword());
        if (login.getEmail()=="faraja2012@gmail.com" && login.getPassword()=="faraja2012" || users.getMail()==login.getEmail() && users.getPassword()==login.getPassword()) {
            return false;
        }
        
    }
    
}
