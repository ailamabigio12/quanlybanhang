package com.quanlybanhang.entites;

import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.ManyToMany;
import javax.persistence.Table;
import java.util.Collection;
import java.util.List;

@Entity
@Data
@NoArgsConstructor
@Table(name = "role")
public class RoleEntity extends BaseEntity {

	@Column(name = "code", length = 50)
	private String code;
	
	@Column(name = "name", length = 50)
	private String name;
	
	@ManyToMany(mappedBy = "roles")
	private Collection<UserEntity> users;

	public RoleEntity(String name) {
		this.name = name;
	}
}
