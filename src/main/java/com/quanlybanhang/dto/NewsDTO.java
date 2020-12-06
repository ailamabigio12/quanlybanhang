package com.quanlybanhang.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.constraints.FutureOrPresent;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class NewsDTO extends AbstractDTO {

	@Size(min = 10, max = 255)
	@NotBlank
	private String title;

	@NotBlank
	private String thumbnail;

	@NotBlank
	private String shortDescription;

	@NotBlank
	private String content;
}