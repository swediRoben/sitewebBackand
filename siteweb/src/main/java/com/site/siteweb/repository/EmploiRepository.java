package com.site.siteweb.repository;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.site.siteweb.entity.EmploiEntity;

@Repository
public interface EmploiRepository extends JpaRepository<EmploiEntity, Long>  {

    Page<EmploiEntity> getByName(String name, Pageable pagingSort);

    Page<EmploiEntity> getByNameAndType(String name, Pageable pagingSort);

    Page<EmploiEntity> findByTypedemende(Integer type, Pageable pagingSort);
    
}
