package com.quanlybanhang.service;

import com.quanlybanhang.dto.UserDTO;
import com.quanlybanhang.entites.UserEntity;
import org.springframework.security.core.userdetails.UserDetailsService;

import java.util.List;

public interface IUserService extends UserDetailsService {

    UserEntity registerUser(UserDTO userDTO);

    List<UserDTO> findAll();

    void setCodeZero(Long id);
}
