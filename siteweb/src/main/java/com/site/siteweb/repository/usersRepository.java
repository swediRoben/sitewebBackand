package com.site.siteweb.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.site.siteweb.entity.UsersEntity; 

@Repository
public interface UsersRepository  extends JpaRepository<UsersEntity, Long> {
    UsersEntity findByMailAndPassword(String email,String password);
}
