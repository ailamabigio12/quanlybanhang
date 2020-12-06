package com.quanlybanhang.entites;

import lombok.Data;

import javax.persistence.*;

@Entity
@Table(name = "type")
@Data
public class InfoEntity extends BaseEntity {
	
	@Column(name = "company", length = 20)
	private String company;
	
	@Column(name = "weight")
	private Float weight;
	
	@Column(name = "romphone")
	private Integer romPhone;
	
	@Column(name = "ramphone")
	private Integer ramPhone;
	
	@Column(name = "screensize")
	private Float screenSize;
	
	@Column(name = "systemversion", length = 40)
	private String systemVersion;
	
	@Column(name = "chipset", length = 40)
	private String chipset;
	
	@Column(name = "pinphone")
	private Integer pinPhone;

	@OneToOne(mappedBy = "info")
	private ItemEntity item;
}
