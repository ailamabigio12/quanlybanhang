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

	public String getName() {
		return name;
	}

	public Integer getPhoneNumber() {
		return phoneNumber;
	}

	public String getEmail() {
		return email;
	}

	public String getContent() {
		return content;
	}

	public ItemEntity getItem() {
		return item;
	}

	public void setName(String name) {
		this.name = name;
	}

	public void setPhoneNumber(Integer phoneNumber) {
		this.phoneNumber = phoneNumber;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public void setContent(String content) {
		this.content = content;
	}

	public void setItem(ItemEntity item) {
		this.item = item;
	}
}
