package com.quanlybanhang.service.impl;

import com.quanlybanhang.converter.CommentConverter;
import com.quanlybanhang.dto.CommentDTO;
import com.quanlybanhang.dto.ItemDTO;
import com.quanlybanhang.entites.CommentEntity;
import com.quanlybanhang.entites.ItemEntity;
import com.quanlybanhang.entites.RoleEntity;
import com.quanlybanhang.repository.CommentRepository;
import com.quanlybanhang.repository.ItemRepository;
import com.quanlybanhang.repository.RoleRepository;
import com.quanlybanhang.service.ICommentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class CommentService implements ICommentService {

    @Autowired
    private CommentRepository commentRepository;

    @Autowired
    private RoleRepository roleRepository;

    @Autowired
    private ItemRepository itemRepository;

    @Autowired
    private CommentConverter commentConverter;

    @Override
    public List<CommentDTO> findAll(ItemDTO itemDTO) {
        ItemEntity itemEntity = itemRepository.findOneById(itemDTO.getId());
        List<CommentEntity> entities = commentRepository.findAllByCodeAndItem(1, itemEntity);
        List<CommentDTO> dtos = new ArrayList<>();
        for (CommentEntity entity : entities) {
            CommentDTO dto = commentConverter.toDTO(entity);
            dtos.add(dto);
        }
        return dtos;
    }

    @Override
    public CommentDTO save(CommentDTO commentDTO, Long id) {
        RoleEntity role = roleRepository.findOneById(commentDTO.getRoleId());
        ItemEntity item = itemRepository.findOneById(id);
        CommentEntity commentEntity = commentConverter.toEntity(commentDTO);
        commentEntity.setCode(1);
        commentEntity.setItem(item);
        commentEntity.setRole(role);
        return commentConverter.toDTO(commentRepository.save(commentEntity));
    }

    @Override
    public void setCodeZero(Long id) {
        CommentEntity commentEntity = commentRepository.findOneById(id);
        commentEntity.setCode(0);
        commentRepository.save(commentEntity);
    }
}
