package com.quanlybanhang.service;

import com.quanlybanhang.dto.CommentDTO;
import com.quanlybanhang.dto.ItemDTO;
import com.quanlybanhang.entites.ItemEntity;

import java.util.List;

public interface ICommentService {

    List<CommentDTO> findAll();

    CommentDTO save(CommentDTO commentDTO, Long id);

    void setCodeZero(Long id);
}
