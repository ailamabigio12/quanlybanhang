package com.quanlybanhang.entites;

import java.util.List;
import java.util.Set;

import javax.persistence.*;

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
	
	@ManyToOne
	@JoinColumn(name = "itemid", nullable = false)
	private ItemEntity item;
}
