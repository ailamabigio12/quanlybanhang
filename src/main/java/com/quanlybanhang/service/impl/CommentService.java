package com.quanlybanhang.service.impl;

import com.quanlybanhang.converter.CommentConverter;
import com.quanlybanhang.dto.CommentDTO;
import com.quanlybanhang.dto.ItemDTO;
import com.quanlybanhang.entites.CommentEntity;
import com.quanlybanhang.entites.ItemEntity;
import com.quanlybanhang.repository.CommentRepository;
import com.quanlybanhang.repository.ItemRepository;
import com.quanlybanhang.service.ICommentService;
import com.sun.tools.doclets.internal.toolkit.util.CommentedMethodFinder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class CommentService implements ICommentService {

    @Autowired
    private CommentRepository commentRepository;

    @Autowired
    private ItemRepository itemRepository;

    @Autowired
    private CommentConverter commentConverter;

    @Override
    public List<CommentDTO> findAll() {
        List<CommentEntity> entities = commentRepository.findAllByCode(1);
        List<CommentDTO> dtos = new ArrayList<>();
        for (CommentEntity entity : entities) {
            CommentDTO dto = commentConverter.toDTO(entity);
            dtos.add(dto);
        }
        return dtos;
    }

    @Override
    public CommentDTO save(CommentDTO commentDTO, Long id) {
        ItemEntity itemEntity = itemRepository.findOneById(id);
        CommentEntity commentEntity = commentConverter.toEntity(commentDTO);
        commentEntity.setItem(itemEntity);
        return commentConverter.toDTO(commentRepository.save(commentEntity));
    }

    @Override
    public void setCodeZero(Long id) {
        CommentEntity commentEntity = commentRepository.findOneById(id);
        commentEntity.setCode(0);
        commentRepository.save(commentEntity);
    }
}
