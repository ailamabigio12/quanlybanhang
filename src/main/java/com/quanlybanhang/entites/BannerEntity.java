package com.quanlybanhang.entites;

import lombok.Data;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;

@Entity
@Data
@Table(name = "banner")
public class BannerEntity extends BaseEntity {

	@Column(name = "name", length = 100)
	private String name;
	
	@Column(name = "url")
	private String url;
	
//	code = 1 == acc có thể sử dụng. code = 0 == acc bị ẩn không thể sử dụng.
	@Column(name = "code")
	private Integer code;
}
