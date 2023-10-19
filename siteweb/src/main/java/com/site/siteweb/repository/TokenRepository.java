package com.site.siteweb.repository;

import java.util.Date;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.site.siteweb.entity.TokenEntity;

@Repository
public interface TokenRepository extends JpaRepository<TokenEntity, Long> {

    TokenEntity findByEmailAndPassword(String email, String password);

    TokenEntity findByPasswordrolehash(String token);
    
    @Query("SELECT count(c) > 0 FROM TokenEntity c  WHERE c.passwordrolehash=?1 and c.datfin>?2 ")
    boolean checkToken(String login, Date today);

   @Query("SELECT c FROM TokenEntity c  WHERE c.email=?1 and c.password=?2  and c.datfin<=?3 ")
    TokenEntity getByEmailAndPassword(String email, String password, Date today);

    @Query("SELECT c FROM TokenEntity c  WHERE c.email=?1 and c.password=?2")
    List<TokenEntity> getByEmailAndPasswords(String email, String password); 
}
