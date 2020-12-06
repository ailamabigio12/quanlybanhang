package com.quanlybanhang.converter;

import com.quanlybanhang.dto.CompanyDTO;
import com.quanlybanhang.entites.CompanyEntity;
import org.springframework.stereotype.Component;

@Component
public class CompanyConverter {

    public CompanyDTO toDTO(CompanyEntity entity) {
        CompanyDTO dto = new CompanyDTO();
        dto.setId(entity.getId());
        dto.setName(entity.getName());
        return dto;
    }

    public CompanyEntity toEntity(CompanyDTO dto) {
        CompanyEntity entity = new CompanyEntity();
        entity.setId(dto.getId());
        entity.setName(dto.getName());
        return entity;
    }
}
