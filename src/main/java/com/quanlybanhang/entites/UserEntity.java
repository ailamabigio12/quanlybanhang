package com.quanlybanhang.entites;

import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.List;

@Entity
@Data
@NoArgsConstructor
@Table(name = "user", uniqueConstraints = @UniqueConstraint(columnNames = {"username", "email"}))
public class UserEntity extends BaseEntity {

	@Column(name = "username", length = 24, nullable = false)
	private String userName;
	
	@Column(name = "password", nullable = false)
	private String password;
	
	@Column(name = "email", length = 40)
	private String email;
	
	@Column(name = "fullname", length = 50)
	private String fullName;

	@Column(name = "phonenumber")
	private Integer phoneNumber;
	
	@Column(name = "identitynumber", length = 12, nullable = false)
	private Long identityNumber;
	
//	code = 1 == acc có thể sử dụng. code = 0 == acc bị ẩn không thể sử dụng.
	@Column(name = "code")
	private Integer code;

	@ManyToMany(cascade = CascadeType.ALL, fetch = FetchType.EAGER)
	@JoinTable(name = "users_roles",
			   joinColumns = @JoinColumn(name = "userid", referencedColumnName = "id"),
			   inverseJoinColumns = @JoinColumn(name = "roleid", referencedColumnName = "id"))
	private Collection<RoleEntity> roles;

	public UserEntity(Integer code, String userName, String password, String email, Integer phoneNumber, String fullName, Long identityNumber, List<RoleEntity> roles) {
		this.code = code;
		this.userName = userName;
		this.password = password;
		this.email = email;
		this.phoneNumber = phoneNumber;
		this.fullName = fullName;
		this.identityNumber = identityNumber;
		this.roles = roles;
	}
}
