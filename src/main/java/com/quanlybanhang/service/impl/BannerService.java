package com.quanlybanhang.service.impl;

import com.quanlybanhang.converter.BannerConverter;
import com.quanlybanhang.dto.BannerDTO;
import com.quanlybanhang.entites.BannerEntity;
import com.quanlybanhang.repository.BannerRepository;
import com.quanlybanhang.service.IBannerService;
import com.quanlybanhang.utils.CommonConstant;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;

@Service
public class BannerService implements IBannerService {

    @Autowired
    private BannerRepository bannerRepository;

    @Autowired
    private BannerConverter bannerConverter;

    @Override
    public List<BannerDTO> findAll() {
        List<BannerDTO> dtos = new ArrayList<>();
        List<BannerEntity> entities = bannerRepository.findAllByCode(1);
        for (BannerEntity entity : entities) {
            BannerDTO dto = bannerConverter.toDTO(entity);
            dtos.add(dto);
        }
        return dtos;
    }

    @Override
    public BannerDTO findById(Long id) {
        BannerEntity entity = bannerRepository.findOneById(id);
        return bannerConverter.toDTO(entity);
    }

    @Override
    public BannerDTO save(MultipartFile file, BannerDTO dto) {
        try {
            String fileName = System.currentTimeMillis() + "_" + file.getOriginalFilename();
            String rootPath = CommonConstant.root;
            Path filePath = Paths.get( rootPath + fileName);
            BannerEntity entity = new BannerEntity();
            if (dto.getId() != null) {
                BannerEntity oldentity = bannerRepository.findOneById(dto.getId());
                entity = bannerConverter.toEntity(dto, oldentity);
                entity.setCode(1);
            } else {
                entity = bannerConverter.toEntity(dto);
                entity.setCode(1);
            }
            if (fileName.charAt(fileName.length()-1) != '_') {
                entity.setUrl(fileName);
                Files.copy(file.getInputStream(), filePath);
            }
            return bannerConverter.toDTO(bannerRepository.save(entity));
        } catch (Exception e) {
            return null;
        }
    }

    @Override
    public void setCodeZero(Long id) {
        BannerEntity bannerEntity = bannerRepository.findOneById(id);
        bannerEntity.setCode(0);
        bannerRepository.save(bannerEntity);
    }
}
