package com.quanlybanhang.converter;

import com.quanlybanhang.dto.InfoDTO;
import com.quanlybanhang.entites.InfoEntity;
import org.springframework.stereotype.Component;

@Component
public class InfoConverter {

    public InfoDTO toDTO(InfoEntity entity) {
        InfoDTO dto = new InfoDTO();
        dto.setId(entity.getId());
        dto.setCompany(entity.getCompany());
        dto.setWeight(entity.getWeight());
        dto.setRomPhone(entity.getRomPhone());
        dto.setRamPhone(entity.getRamPhone());
        dto.setScreenSize(entity.getScreenSize());
        dto.setSystemVersion(entity.getSystemVersion());
        dto.setChipset(entity.getChipset());
        dto.setPinPhone(entity.getPinPhone());
        return dto;
    }

    public InfoEntity toEntity(InfoDTO dto) {
        InfoEntity entity = new InfoEntity();
        entity.setId(dto.getId());
        entity.setCompany(dto.getCompany());
        entity.setWeight(dto.getWeight());
        entity.setRomPhone(dto.getRomPhone());
        entity.setRamPhone(dto.getRamPhone());
        entity.setScreenSize(dto.getScreenSize());
        entity.setSystemVersion(dto.getSystemVersion());
        entity.setChipset(dto.getChipset());
        entity.setPinPhone(dto.getPinPhone());
        return entity;
    }
    public InfoEntity toEntity(InfoDTO dto, InfoEntity entity) {
        entity.setId(dto.getId());
        entity.setCompany(dto.getCompany());
        entity.setWeight(dto.getWeight());
        entity.setRomPhone(dto.getRomPhone());
        entity.setRamPhone(dto.getRamPhone());
        entity.setScreenSize(dto.getScreenSize());
        entity.setSystemVersion(dto.getSystemVersion());
        entity.setChipset(dto.getChipset());
        entity.setPinPhone(dto.getPinPhone());
        return entity;
    }
}
