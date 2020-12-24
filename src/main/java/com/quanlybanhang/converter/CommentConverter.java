package com.quanlybanhang.converter;

import com.quanlybanhang.dto.CommentDTO;
import com.quanlybanhang.entites.CommentEntity;
import com.quanlybanhang.entites.ItemEntity;
import org.springframework.stereotype.Component;

@Component
public class CommentConverter {

    public CommentDTO toDTO(CommentEntity entity) {
        CommentDTO dto = new CommentDTO();
        try {
            dto.setRoleId(entity.getRole().getId());
            dto.setId(entity.getId());
            dto.setContent(entity.getContent());
            dto.setEmail(entity.getEmail());
            dto.setName(entity.getName());
            dto.setPhoneNumber(entity.getPhoneNumber());
            dto.setItemId(entity.getItem().getId());
            return dto;
        } catch (Exception e) {
            dto.setId(entity.getId());
            dto.setContent(entity.getContent());
            dto.setEmail(entity.getEmail());
            dto.setName(entity.getName());
            dto.setPhoneNumber(entity.getPhoneNumber());
            dto.setItemId(entity.getItem().getId());
            return dto;
        }
    }

    public CommentEntity toEntity(CommentDTO dto) {
        CommentEntity entity = new CommentEntity();
        entity.setContent(dto.getContent());
        entity.setEmail(dto.getEmail());
        entity.setName(dto.getName());
        entity.setPhoneNumber(dto.getPhoneNumber());
        return entity;
    }
}
