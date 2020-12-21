package com.quanlybanhang.entites;

import lombok.Data;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.*;

@Entity
@Data
@Table(name = "orderphone")
public class OrderEntity extends BaseEntity {

	@Column(name = "fullname", length = 50, nullable = false)
	private String fullName;
	
	@Column(name = "phonenumber")
	private Integer phoneNumber;
	
	@Column(name = "address")
	private String address;
	
	@Column(name = "note", columnDefinition = "TEXT")
	private String note;
	
//	status = 1 == pending. status = 2 == complete. status = 3 == cancel
	@Column(name = "status")
	private Integer status;

	@OneToMany(mappedBy = "order")
	private List<OrderItemEntity> orderitems = new ArrayList<>();
}
