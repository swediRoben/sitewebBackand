package com.site.siteweb.repository;

import java.util.Date;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.site.siteweb.entity.TokenEntity;

public interface TokenRepository extends JpaRepository<TokenEntity, Long> {

    TokenEntity findByEmailAndPassword(String email, String password);

    TokenEntity findByPasswordrolehash(String token);
    
    @Query("SELECT count(c) > 0 FROM TokenEntity c  WHERE c.passwordrolehash=?1 and c.datfin=?2 ")
    boolean checkToken(String login, Date today); 
    
}
