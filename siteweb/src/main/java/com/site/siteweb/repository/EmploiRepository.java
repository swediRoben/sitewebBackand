package com.site.siteweb.repository;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.site.siteweb.entity.EmploiEntity;

@Repository
public interface EmploiRepository extends JpaRepository<EmploiEntity, Long>  {

     @Query("select e FROM EmploiEntity e WHERE e.nom like '%' || ?1  || '%' or e.mail  like '%' || ?1  || '%' ")
     Page<EmploiEntity> getByName(String name, Pageable pagingSort);

     @Query("select e FROM EmploiEntity e WHERE (e.nom like '%' || ?1  || '%' or e.mail  like '%' || ?1  || '%') and typedemende=?2 ")
    Page<EmploiEntity> getByNameAndType(String name,Integer type, Pageable pagingSort);

    Page<EmploiEntity> findByTypedemende(Integer type, Pageable pagingSort);
    
}
