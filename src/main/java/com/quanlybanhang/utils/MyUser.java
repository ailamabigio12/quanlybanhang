package com.quanlybanhang.utils;

import lombok.Data;
import lombok.Getter;
import lombok.Setter;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.User;

import java.util.Collection;

public class MyUser extends User {

    @Getter
    @Setter
    private String fullName;

    @Getter
    @Setter
    private String email;

    @Getter
    @Setter
    private Integer phoneNumber;

    private static final long serialVersionUID = 1L;

    public MyUser(String username, String password, Collection<? extends GrantedAuthority> authorities, String fullName, String email, Integer phoneNumber) {
        super(username, password, authorities);
        this.fullName = fullName;
        this.email = email;
        this.phoneNumber = phoneNumber;
    }
}
