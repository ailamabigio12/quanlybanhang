package com.quanlybanhang.service.impl;

import com.quanlybanhang.converter.CompanyConverter;
import com.quanlybanhang.dto.CompanyDTO;
import com.quanlybanhang.entites.CompanyEntity;
import com.quanlybanhang.repository.CompanyRepository;
import com.quanlybanhang.service.ICompanyService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class CompanyService implements ICompanyService {

    @Autowired
    private CompanyConverter companyConverter;

    @Autowired
    private CompanyRepository companyRepository;

    @Override
    public List<CompanyDTO> findAll() {
        List<CompanyDTO> companyDTO = new ArrayList<>();
        List<CompanyEntity> companyEntity = companyRepository.findAll();
        for (CompanyEntity company : companyEntity) {
            CompanyDTO comp = companyConverter.toDTO(company);
            companyDTO.add(comp);
        }
        return companyDTO;
    }
}
