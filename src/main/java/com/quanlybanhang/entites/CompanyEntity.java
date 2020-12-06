package com.quanlybanhang.entites;

import lombok.Data;

import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Data
@Table(name = "company")
public class CompanyEntity extends BaseEntity {

	@Column(name = "name", length = 20)
	private String name;
	
	@OneToMany(mappedBy = "company")
	private Set<ItemEntity> items;
}
