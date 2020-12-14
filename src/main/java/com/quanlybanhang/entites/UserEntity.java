package com.quanlybanhang.entites;

import lombok.Data;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity
@Data
@Table(name = "user")
public class UserEntity extends BaseEntity {

	@Column(name = "username", length = 24, nullable = false)
	private String userName;
	
	@Column(name = "password", length = 24, nullable = false)
	private String password;
	
	@Column(name = "email", length = 40)
	private String email;
	
	@Column(name = "fullname", length = 50)
	private String fullName;
	
	@Column(name = "dateofbirth")
	private Date dateOfBirth;
	
	@Column(name = "identitynumber", length = 12, nullable = false)
	private Long identityNumber;
	
//	code = 1 == acc có thể sử dụng. code = 0 == acc bị ẩn không thể sử dụng.
	@Column(name = "code")
	private Integer code;
	
	@OneToOne
	@JoinColumn(name = "roleid")
	private RoleEntity role;
}
