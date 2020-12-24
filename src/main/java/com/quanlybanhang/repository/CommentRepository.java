package com.quanlybanhang.repository;

import com.quanlybanhang.dto.ItemDTO;
import com.quanlybanhang.entites.CommentEntity;
import com.quanlybanhang.entites.ItemEntity;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface CommentRepository extends JpaRepository<CommentEntity, Long> {

    List<CommentEntity> findAllByCodeAndItem(Integer code, ItemEntity itemEntity);

    CommentEntity findOneById(Long id);
}
