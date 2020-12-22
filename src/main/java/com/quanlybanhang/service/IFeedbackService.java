package com.quanlybanhang.service;

import com.quanlybanhang.dto.FeedbackDTO;
import com.quanlybanhang.entites.FeedbackEntity;

import java.util.List;

public interface IFeedbackService {

    List<FeedbackDTO> findAll();

    FeedbackDTO save(FeedbackDTO feedbackDTO);
}
