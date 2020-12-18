package com.quanlybanhang.service.impl;

import com.quanlybanhang.dto.UserDTO;
import com.quanlybanhang.entites.RoleEntity;
import com.quanlybanhang.entites.UserEntity;
import com.quanlybanhang.repository.UserRepository;
import com.quanlybanhang.service.IUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class UserService implements IUserService {

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private PasswordEncoder passwordEncoder;

    @Override
    public List<UserDTO> findAll() {
        List<UserDTO> users = new ArrayList<>();
        List<UserEntity> entities = userRepository.findAll();
        for (UserEntity entity : entities) {
            UserDTO user = new UserDTO();
            user.setUsername(entity.getUserName());
            user.setFullname(entity.getFullName());
            user.setEmail(entity.getEmail());
            users.add(user);
        }
        return users;
    }

    @Override
    public UserEntity registerUser(UserDTO userDTO) {
        UserEntity user = new UserEntity(userDTO.getUsername(),
                                         passwordEncoder.encode(userDTO.getPassword()),
                                         userDTO.getEmail(),
                                         userDTO.getFullname(),
                                         userDTO.getIdentityNumber(),
                                         Arrays.asList(new RoleEntity("ROLE_ADMIN")));
        return userRepository.save(user);
    }

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        UserEntity user = userRepository.findByUserName(username);
        if (user == null) {
            throw new UsernameNotFoundException("Tài khoản hoặc mật khẩu không đúng! Bạn hãy nhập lại");
        }
        return new User(user.getUserName(), user.getPassword(), mapRoleToAuthority(user.getRoles()));
    }

    private Collection<? extends GrantedAuthority> mapRoleToAuthority(Collection<RoleEntity> roles) {
        return roles.stream().map(role -> new SimpleGrantedAuthority(role.getName())).collect(Collectors.toList());
    }
}
