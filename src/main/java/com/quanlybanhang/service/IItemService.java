package com.quanlybanhang.service;

import com.quanlybanhang.dto.InfoDTO;
import com.quanlybanhang.dto.ItemDTO;
import org.springframework.web.multipart.MultipartFile;

import java.util.List;


public interface IItemService {

    public List<ItemDTO> findAll();

    public ItemDTO findById(Long id);

    public ItemDTO save(MultipartFile file, ItemDTO itemDTO, InfoDTO infoDTO);

    public void setCodeZero( ItemDTO itemDTO);

    public List<ItemDTO> findAllByCompanyId(Long id);
}
