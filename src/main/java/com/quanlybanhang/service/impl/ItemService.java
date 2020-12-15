package com.quanlybanhang.service.impl;

import com.quanlybanhang.converter.ItemConverter;
import com.quanlybanhang.dto.InfoDTO;
import com.quanlybanhang.dto.ItemDTO;
import com.quanlybanhang.entites.CompanyEntity;
import com.quanlybanhang.entites.InfoEntity;
import com.quanlybanhang.entites.ItemEntity;
import com.quanlybanhang.repository.CompanyRepository;
import com.quanlybanhang.repository.InfoRepository;
import com.quanlybanhang.repository.ItemRepository;
import com.quanlybanhang.service.IItemService;
import com.quanlybanhang.utils.CommonConstant;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import javax.xml.ws.ServiceMode;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;

@Service
public class ItemService implements IItemService {

    @Autowired
    private ItemRepository itemRepository;

    @Autowired
    private ItemConverter itemConverter;

    @Autowired
    private CompanyRepository companyRepository;

    @Autowired
    private InfoRepository infoRepository;

    @Override
    public List<ItemDTO> findAll() {
        List<ItemDTO> items = new ArrayList<>();
        itemRepository.findAllByCode(1);
        List<ItemEntity> entities = itemRepository.findAllByCode(1);
        for (ItemEntity item:entities) {
            ItemDTO itemDTO = itemConverter.toDTO(item);
            items.add(itemDTO);
        }
        return items;
    }

    @Override
    public ItemDTO findById(Long id) {
        ItemEntity itemEntity = itemRepository.findOneById(id);
        return itemConverter.toDTO(itemEntity);
    }

    @Override
    public ItemDTO save(MultipartFile file, ItemDTO itemDTO, InfoDTO infoDTO) {
        try {
            String filename = System.currentTimeMillis() + "_" + file.getOriginalFilename();
            String rootPath = CommonConstant.root;
            Path pathfiles = Paths.get(rootPath + filename);
            CompanyEntity company = companyRepository.findOneById(itemDTO.getCompanyId());
            InfoEntity info = infoRepository.findOneById(infoDTO.getId());
            ItemEntity itemEntity = new ItemEntity();
            if (itemDTO.getId() != null) {
                ItemEntity oldItem = itemRepository.findOneById(itemDTO.getId());
                oldItem.setCompany(company);
                oldItem.setCode(1);
                oldItem.setInfo(info);
                itemEntity = itemConverter.toEntity(itemDTO, oldItem);
            } else {
                itemEntity = itemConverter.toEntity(itemDTO);
                itemEntity.setCompany(company);
                itemEntity.setCode(1);
                itemEntity.setInfo(info);
            }
            if (filename.charAt(filename.length()-1) != '_') {
                itemEntity.setThumbnail(filename);
                Files.copy(file.getInputStream(), pathfiles);
            }
            return itemConverter.toDTO(itemRepository.save(itemEntity));
        } catch (Exception e) {
            throw null;
        }
    }

    @Override
    public void setCodeZero(ItemDTO itemDTO) {
        ItemEntity itemEntity = itemConverter.toEntity(itemDTO);
        itemEntity.setCode(0);
        itemRepository.save(itemEntity);
    }
}
