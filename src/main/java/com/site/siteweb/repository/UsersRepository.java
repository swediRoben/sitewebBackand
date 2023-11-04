package com.site.siteweb.repository;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.site.siteweb.entity.UsersEntity; 

@Repository
public interface UsersRepository  extends JpaRepository<UsersEntity, Long> {
    UsersEntity findByMailAndPassword(String email,String password);

    Page<UsersEntity> findById(Long id, Pageable pagingSort);

    @Query("select e from UsersEntity e  where  e.nom like '%' || ?1  || '%' or e.mail  like '%' || ?1  || '%' ")
    Page<UsersEntity> getByEmail(String username, Pageable pagingSort);
}
