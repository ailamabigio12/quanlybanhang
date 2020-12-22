package com.quanlybanhang.service.impl;

import com.quanlybanhang.converter.FeedbackConverter;
import com.quanlybanhang.dto.FeedbackDTO;
import com.quanlybanhang.entites.FeedbackEntity;
import com.quanlybanhang.repository.FeedbackRepository;
import com.quanlybanhang.service.IFeedbackService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class FeedbackService implements IFeedbackService {

    @Autowired
    private FeedbackRepository feedbackRepository;

    @Autowired
    private FeedbackConverter feedbackConverter;

    @Override
    public List<FeedbackDTO> findAll() {
        List<FeedbackEntity> entities = feedbackRepository.findAll();
        List<FeedbackDTO> dtos = new ArrayList<>();
        for (FeedbackEntity entity : entities) {
            FeedbackDTO dto = feedbackConverter.toDTO(entity);
            dtos.add(dto);
        }
        return dtos;
    }

    @Override
    public FeedbackDTO save(FeedbackDTO feedbackDTO) {
        FeedbackEntity feedback = feedbackConverter.toEntity(feedbackDTO);
        feedbackRepository.save(feedback);
        return feedbackConverter.toDTO(feedback);
    }
}
