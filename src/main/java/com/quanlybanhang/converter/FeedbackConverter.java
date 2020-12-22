package com.quanlybanhang.converter;

import com.quanlybanhang.dto.FeedbackDTO;
import com.quanlybanhang.entites.FeedbackEntity;
import org.springframework.stereotype.Component;

@Component
public class FeedbackConverter {

    public FeedbackEntity toEntity(FeedbackDTO dto) {
        FeedbackEntity entity = new FeedbackEntity();
        entity.setContent(dto.getContent());
        entity.setEmail(dto.getEmail());
        entity.setFullname(dto.getFullname());
        entity.setPhoneNumber(dto.getPhoneNumber());
        return entity;
    }

    public FeedbackDTO toDTO(FeedbackEntity entity) {
        FeedbackDTO dto = new FeedbackDTO();
        dto.setId(entity.getId());
        dto.setContent(entity.getContent());
        dto.setPhoneNumber(entity.getPhoneNumber());
        dto.setEmail(entity.getEmail());
        dto.setFullname(entity.getFullname());
        return dto;
    }
}
