package com.quanlybanhang.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.ArrayList;
import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class ItemDTO extends AbstractDTO {

	private String thumbnail;

	private String name;

	private Integer basePrice;

	private Integer salePrice;

	private String description;

	private InfoDTO info;

	private Long infoId;

	private Long orderId;

	private Long companyId;

	private Long commentId;
}
