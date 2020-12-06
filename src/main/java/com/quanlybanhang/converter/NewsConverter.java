package com.quanlybanhang.converter;

import org.springframework.stereotype.Component;

import com.quanlybanhang.dto.NewsDTO;
import com.quanlybanhang.entites.NewsEntity;

@Component
public class NewsConverter {

	public NewsDTO toDTO(NewsEntity entity) {
		NewsDTO dto = new NewsDTO();
		dto.setId(entity.getId());
		dto.setTitle(entity.getTitle());
		dto.setThumbnail(entity.getThumbnail());
		dto.setShortDescription(entity.getShortDescription());
		dto.setContent(entity.getContent());
		return dto;
	}
	
	public NewsEntity toEntity(NewsDTO dto) {
		NewsEntity entity = new NewsEntity();	
		entity.setId(dto.getId());
		entity.setTitle(dto.getTitle());
		entity.setThumbnail(dto.getThumbnail());
		entity.setShortDescription(dto.getShortDescription());
		entity.setContent(dto.getContent());
		return entity;
	}
	
	public NewsEntity toEntity(NewsDTO dto, NewsEntity entity) {
		entity.setId(dto.getId());
		entity.setTitle(dto.getTitle());
		entity.setThumbnail(dto.getThumbnail());
		entity.setShortDescription(dto.getShortDescription());
		entity.setContent(dto.getContent());
		return entity;
	}
}
