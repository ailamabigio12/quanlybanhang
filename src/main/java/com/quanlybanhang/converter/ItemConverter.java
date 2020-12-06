package com.quanlybanhang.converter;

import com.quanlybanhang.dto.ItemDTO;
import com.quanlybanhang.entites.ItemEntity;
import org.springframework.stereotype.Component;

@Component
public class ItemConverter {

    public ItemDTO toDTO(ItemEntity entity) {
        ItemDTO dto = new ItemDTO();
        dto.setId(entity.getId());
        dto.setThumbnail(entity.getThumbnail());
        dto.setName(entity.getName());
        dto.setBasePrice(entity.getBasePrice());
        dto.setSalePrice(entity.getSalePrice());
        dto.setDescription(entity.getDescription());
        dto.setCompanyId(entity.getCompany().getId());
        dto.setInfoId(entity.getInfo().getId());
        return dto;
    }

    public ItemEntity toEntity(ItemDTO dto) {
        ItemEntity entity = new ItemEntity();
        entity.setId(dto.getId());
        entity.setName(dto.getName());
        entity.setBasePrice(dto.getBasePrice());
        entity.setSalePrice(dto.getSalePrice());
        entity.setDescription(dto.getDescription());
        return entity;
    }

    public ItemEntity toEntity(ItemDTO dto, ItemEntity entity) {
        entity.setName(dto.getName());
        entity.setBasePrice(dto.getBasePrice());
        entity.setSalePrice(dto.getSalePrice());
        entity.setDescription(dto.getDescription());
        return entity;
    }
}
