package com.quanlybanhang.service;

import com.quanlybanhang.dto.InfoDTO;

public interface IInfoService {

    public InfoDTO findById(Long id);

    public InfoDTO save(InfoDTO infoDTO);
}
