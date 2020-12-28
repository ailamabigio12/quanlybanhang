package com.quanlybanhang.service;

import com.quanlybanhang.dto.InfoDTO;
import com.quanlybanhang.dto.ItemDTO;
import org.springframework.web.multipart.MultipartFile;

import java.util.List;


public interface IItemService {

    List<ItemDTO> findAll();

    ItemDTO findById(Long id);

    ItemDTO save(MultipartFile file, ItemDTO itemDTO, InfoDTO infoDTO);

    void setCodeZero( Long id);

    List<ItemDTO> findAllByCompanyId(Long id);

    List<ItemDTO> search(String keyWord);
}
