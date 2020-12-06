package com.quanlybanhang.entites;

import lombok.Data;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.*;

@Entity
@Data
@Table(name = "item")
public class ItemEntity extends BaseEntity {

	@Column(name = "thumbnail")
	private String thumbnail;
	
	@Column(name = "name", length = 40)
	private String name;

	@Column(name = "baseprice")
	private Integer basePrice;

	@Column(name = "saleprice")
	private Integer salePrice;
	
	@Column(name = "description", columnDefinition = "TEXT")
	private String description;

//	code = 1 == active, code = 0 == inactive
	@Column(name = "code")
	private Integer code;
	
	@OneToOne
	@JoinColumn(name = "infoid")
	private InfoEntity info;
	
	@ManyToMany(mappedBy = "items")
	private List<OrderEntity> orders = new ArrayList<>();
	
	@ManyToOne
	@JoinColumn(name = "companyid")
	private CompanyEntity company;
	
	@OneToMany(mappedBy = "item")
	private List<CommentEntity> comments = new ArrayList<>();
}
