package com.site.siteweb.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.site.siteweb.entity.UsersEntity; 

public interface usersRepository  extends JpaRepository<UsersEntity, Long> {
    
}
