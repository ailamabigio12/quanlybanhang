package com.quanlybanhang.repository;

import com.quanlybanhang.entites.RoleEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface RoleRepository extends JpaRepository<RoleEntity, Long> {

    RoleEntity findOneById(Long id);

    RoleEntity findOneByName(String name);
}
