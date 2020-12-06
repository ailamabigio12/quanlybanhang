package com.quanlybanhang.repository;

import com.quanlybanhang.entites.InfoEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface InfoRepository extends JpaRepository<InfoEntity, Long> {

    public InfoEntity findOneById(Long id);
}
