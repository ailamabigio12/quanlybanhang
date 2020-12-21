package com.quanlybanhang.repository;

import com.quanlybanhang.entites.CompanyEntity;
import com.quanlybanhang.entites.ItemEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface ItemRepository extends JpaRepository<ItemEntity, Long> {

    ItemEntity findOneById(Long id);

    List<ItemEntity> findAllByCompany(CompanyEntity company);

    List<ItemEntity> findAllByCode(Integer code);
}
