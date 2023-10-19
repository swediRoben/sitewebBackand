package com.site.siteweb.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.site.siteweb.entity.UsersEntity; 

public interface UsersRepository  extends JpaRepository<UsersEntity, Long> {
    UsersEntity findByMailAndPassword(String email,String password);
}
