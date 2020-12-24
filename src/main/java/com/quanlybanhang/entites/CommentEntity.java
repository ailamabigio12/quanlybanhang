package com.quanlybanhang.entites;

import lombok.Data;

import javax.persistence.*;

@Data
@Entity
@Table(name = "comment")
public class CommentEntity extends BaseEntity {

	@Column(name = "name", length = 50)
	private String name;

	@Column(name = "phonenumber")
	private Integer phoneNumber;
	
	@Column(name = "email", length = 100)
	private String email;
	
	@Column(name = "content", columnDefinition = "TEXT")
	private String content;

	@Column(name = "code")
	private Integer code;
	
	@ManyToOne
	@JoinColumn(name = "itemid", nullable = false)
	private ItemEntity item;

	@ManyToOne
	@JoinColumn(name = "roleid")
	private RoleEntity role;

}
