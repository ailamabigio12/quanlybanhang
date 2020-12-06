package com.quanlybanhang.service.impl;

import com.quanlybanhang.converter.InfoConverter;
import com.quanlybanhang.dto.InfoDTO;
import com.quanlybanhang.entites.InfoEntity;
import com.quanlybanhang.repository.InfoRepository;
import com.quanlybanhang.service.IInfoService;
import jdk.internal.org.objectweb.asm.tree.TryCatchBlockNode;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.TreeMap;

@Service
public class InfoService implements IInfoService {

    @Autowired
    private InfoRepository infoRepository;

    @Autowired
    private InfoConverter infoConverter;

    @Override
    public InfoDTO findById(Long id) {
        InfoEntity infoEntity = infoRepository.findOneById(id);
        return infoConverter.toDTO(infoEntity);
    }

    @Override
    public InfoDTO save(InfoDTO infoDTO) {
        try {
            InfoEntity infoEntity = new InfoEntity();
            System.out.println(infoDTO.getCompany());
            if (infoDTO.getId() != null) {
                InfoEntity oldInfo = infoRepository.findOneById(infoDTO.getId());
                infoEntity = infoConverter.toEntity(infoDTO, oldInfo);
            } else {
                infoEntity = infoConverter.toEntity(infoDTO);
            }
            InfoEntity saveinfo = infoRepository.save(infoEntity);
            System.out.println(saveinfo.getId());
            return infoConverter.toDTO(saveinfo);
        } catch (Exception e) {
            throw null;
        }
    }
}
