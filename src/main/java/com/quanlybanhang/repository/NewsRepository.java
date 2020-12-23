package com.quanlybanhang.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.quanlybanhang.entites.NewsEntity;

import java.util.List;

@Repository
public interface NewsRepository extends JpaRepository<NewsEntity, Long> {

	NewsEntity findOneById(Long id);

	List<NewsEntity> findAllByCode(Integer code);
}
