package com.site.siteweb.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.site.siteweb.dto.LoginContent; 
import com.site.siteweb.repository.UsersRepository; 

@Service
public class UserService {
 @Autowired
 private UsersRepository repository;
    public boolean login(LoginContent login) { 
        System.out.println("mail :"+login.getEmail());
        if (login.getEmail().equals("faraja2012@gmail.com") && login.getPassword().equals("faraja2012")) {
            return true; 
        }else{
            return false;
        }  
        
    }
    
}
