package com.quanlybanhang.entites;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;

@Entity
@Table(name = "banner")
public class BannerEntity extends BaseEntity {

	@Column(name = "name", length = 100)
	private String name;
	
	@Column(name = "url")
	private String url;
	
//	code = 1 == acc có thể sử dụng. code = 0 == acc bị ẩn không thể sử dụng.
	@Column(name = "code")
	private Integer code;

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getUrl() {
		return url;
	}

	public void setUrl(String url) {
		this.url = url;
	}

	public Integer getCode() {
		return code;
	}

	public void setCode(Integer code) {
		this.code = code;
	}
}
