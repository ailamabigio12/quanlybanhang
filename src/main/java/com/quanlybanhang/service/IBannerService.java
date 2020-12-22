package com.quanlybanhang.service;

import com.quanlybanhang.dto.BannerDTO;
import org.springframework.web.multipart.MultipartFile;

import java.util.List;

public interface IBannerService {

    List<BannerDTO> findAll();

    BannerDTO findById(Long id);

    BannerDTO save(MultipartFile file, BannerDTO dto);
}
