package com.quanlybanhang.converter;

import com.quanlybanhang.dto.BannerDTO;
import com.quanlybanhang.entites.BannerEntity;
import org.springframework.boot.Banner;
import org.springframework.stereotype.Component;

@Component
public class BannerConverter {

    public BannerDTO toDTO(BannerEntity entity) {
        BannerDTO dto = new BannerDTO();
        dto.setId(entity.getId());
        dto.setName(entity.getName());
        dto.setUrl(entity.getUrl());
        return dto;
    }

    public BannerEntity toEntity(BannerDTO dto) {
        BannerEntity entity = new BannerEntity();
        entity.setName(dto.getName());
        entity.setUrl(dto.getUrl());
        return entity;
    }

    public BannerEntity toEntity(BannerDTO dto, BannerEntity entity) {
        entity.setName(dto.getName());
        entity.setUrl(dto.getUrl());
        return entity;
    }
}
