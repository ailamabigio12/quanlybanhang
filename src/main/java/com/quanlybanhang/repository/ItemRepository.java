package com.quanlybanhang.repository;

import com.quanlybanhang.entites.CompanyEntity;
import com.quanlybanhang.entites.ItemEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface ItemRepository extends JpaRepository<ItemEntity, Long> {

    ItemEntity findOneById(Long id);

    @Query("Select m From ItemEntity m Where m.name LIKE %:keyWord% OR m.basePrice LIKE %:keyWord% OR m.salePrice LIKE %:keyWord%")
    List<ItemEntity> findByKeyWord(@Param("keyWord") String keyWord);

    List<ItemEntity> findAllByCompanyAndCode(CompanyEntity company, Integer code);

    List<ItemEntity> findAllByCode(Integer code);
}
