package com.quanlybanhang.repository;

import com.quanlybanhang.entites.BannerEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface BannerRepository extends JpaRepository<BannerEntity, Long> {

    List<BannerEntity> findAllByCode(Integer code);

    BannerEntity findOneById(Long id);
}
