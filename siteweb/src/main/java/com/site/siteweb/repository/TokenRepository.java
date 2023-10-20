package com.site.siteweb.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.site.siteweb.entity.TokenEntity;

@Repository
public interface TokenRepository extends JpaRepository<TokenEntity, Long> {

    TokenEntity findByEmailAndPassword(String email, String password);

    TokenEntity findByPasswordrolehash(String token);  

    @Query("SELECT c FROM TokenEntity c  WHERE c.email=?1 and c.password=?2")
    List<TokenEntity> getByEmailAndPasswords(String email, String password); 
}
