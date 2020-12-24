package com.quanlybanhang.repository;

import com.quanlybanhang.entites.UserEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface UserRepository extends JpaRepository<UserEntity, Long> {

    UserEntity findByUserName(String userName);

    UserEntity findOneById(Long id);

    List<UserEntity> findAllByCode(Integer code);
}
