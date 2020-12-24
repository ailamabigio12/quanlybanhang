package com.quanlybanhang.dto;

import com.quanlybanhang.entites.BaseEntity;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class UserDTO extends BaseEntity {

    private String userName;

    private String password;

    private String email;

    private String fullName;

    private Integer phoneNumber;

    private Long identityNumber;
}
