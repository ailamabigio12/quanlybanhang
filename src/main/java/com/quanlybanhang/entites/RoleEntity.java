package com.quanlybanhang.entites;

import lombok.Data;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity
@Data
@Table(name = "role")
public class RoleEntity extends BaseEntity {

	@Column(name = "code", length = 50)
	private String code;
	
	@Column(name = "name", length = 50)
	private String name;
	
	@OneToOne(mappedBy = "role")
	private UserEntity user;
}
