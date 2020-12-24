package com.quanlybanhang.service.impl;

import com.quanlybanhang.dto.UserDTO;
import com.quanlybanhang.entites.RoleEntity;
import com.quanlybanhang.entites.UserEntity;
import com.quanlybanhang.repository.RoleRepository;
import com.quanlybanhang.repository.UserRepository;
import com.quanlybanhang.service.IUserService;
import com.quanlybanhang.utils.MyUser;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.*;
import java.util.stream.Collectors;

@Service
public class UserService implements IUserService {

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private RoleRepository roleRepository;

    @Autowired
    private PasswordEncoder passwordEncoder;

    @Override
    public List<UserDTO> findAll() {
        List<UserDTO> users = new ArrayList<>();
        List<UserEntity> entities = userRepository.findAllByCode(1);
        for (UserEntity entity : entities) {
            UserDTO user = new UserDTO();
            user.setId(entity.getId());
            user.setUserName(entity.getUserName());
            user.setFullName(entity.getFullName());
            user.setEmail(entity.getEmail());
            user.setPhoneNumber(entity.getPhoneNumber());
            users.add(user);
        }
        return users;
    }

    @Override
    public UserEntity registerUser(UserDTO userDTO) {
        UserEntity user = new UserEntity(1,
                                         userDTO.getUserName(),
                                         passwordEncoder.encode(userDTO.getPassword()),
                                         userDTO.getEmail(),
                                         userDTO.getPhoneNumber(),
                                         userDTO.getFullName(),
                                         userDTO.getIdentityNumber(),
                                         Arrays.asList(roleRepository.findOneByName("ROLE_ADMIN")));
        return userRepository.save(user);
    }

    @Override
    public void setCodeZero(Long id) {
        UserEntity user = userRepository.findOneById(id);
        user.setCode(0);
        userRepository.save(user);
    }

    @Override
    public MyUser loadUserByUsername(String username) throws UsernameNotFoundException {
        UserEntity user = userRepository.findByUserName(username);
        if (user == null || user.getCode() == 0) {
            throw new UsernameNotFoundException("Tài khoản hoặc mật khẩu không đúng! Bạn hãy nhập lại");
        }
        return new MyUser(user.getUserName(), user.getPassword(), mapRoleToAuthority(user.getRoles()), user.getFullName(), user.getEmail(), user.getPhoneNumber());
    }

    private Collection<? extends GrantedAuthority> mapRoleToAuthority(Collection<RoleEntity> roles) {
        return roles.stream().map(role -> new SimpleGrantedAuthority(role.getName())).collect(Collectors.toList());
    }
}
