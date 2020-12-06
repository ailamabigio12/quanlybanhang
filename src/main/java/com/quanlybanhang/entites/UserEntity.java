package com.quanlybanhang.entites;

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

	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getFullName() {
		return fullName;
	}

	public void setFullName(String fullName) {
		this.fullName = fullName;
	}

	public Date getDateOfBirth() {
		return dateOfBirth;
	}

	public void setDateOfBirth(Date dateOfBirth) {
		this.dateOfBirth = dateOfBirth;
	}

	public Long getIdentityNumber() {
		return identityNumber;
	}

	public void setIdentityNumber(Long identityNumber) {
		this.identityNumber = identityNumber;
	}

	public Integer getCode() {
		return code;
	}

	public void setCode(Integer code) {
		this.code = code;
	}

	public RoleEntity getRole() {
		return role;
	}

	public void setRole(RoleEntity role) {
		this.role = role;
	}
}
