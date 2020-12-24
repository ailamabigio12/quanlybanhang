package com.quanlybanhang.entites;

import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.ArrayList;
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

	@OneToMany(mappedBy = "role")
	private List<CommentEntity> comments = new ArrayList<>();

	public RoleEntity(String name) {
		this.name = name;
	}
}
