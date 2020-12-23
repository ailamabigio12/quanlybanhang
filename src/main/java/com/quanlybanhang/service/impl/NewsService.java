package com.quanlybanhang.service.impl;

import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import com.quanlybanhang.converter.NewsConverter;
import com.quanlybanhang.dto.NewsDTO;
import com.quanlybanhang.entites.NewsEntity;
import com.quanlybanhang.repository.NewsRepository;
import com.quanlybanhang.service.INewsService;
import com.quanlybanhang.utils.CommonConstant;

@Service
public class NewsService implements INewsService {

	@Autowired
	private NewsRepository newsRepository;
	
	@Autowired
	private NewsConverter newsConverter;
	
	@Override
	public List<NewsDTO> findAll() {
		List<NewsEntity> entities = newsRepository.findAllByCode(1);
		List<NewsDTO> dtos = new ArrayList<>();
		for (NewsEntity entity : entities) {
			NewsDTO dto = newsConverter.toDTO(entity);
			dtos.add(dto);
		}
		return dtos;
	}

	@Override
	public NewsDTO saveNews(MultipartFile multipartFile, NewsDTO newsDTO) {
		try {		
			String filename = System.currentTimeMillis() + "_" + multipartFile.getOriginalFilename();
			String rootPath = CommonConstant.root;
			Path pathfiles = Paths.get(rootPath + filename);
			NewsEntity newsEntity = new NewsEntity();
			if(newsDTO.getId() != null ) {
				NewsEntity oldEntity = newsRepository.findOneById(newsDTO.getId());
				newsEntity = newsConverter.toEntity(newsDTO, oldEntity);
				newsEntity.setThumbnail(filename);
				newsEntity.setCode(1);
			} else {				
				newsEntity = newsConverter.toEntity(newsDTO);			
				newsEntity.setThumbnail(filename);
				newsEntity.setCode(1);
			}
			if (filename.charAt(filename.length()-1) != '_') {
				newsEntity.setThumbnail(filename);
				Files.copy(multipartFile.getInputStream(), pathfiles);
			}
			return newsConverter.toDTO(newsRepository.save(newsEntity));			
		} catch (Exception e) {			
			return null;
		}		
	}

	@Override
	public NewsDTO findById(Long id) {
		NewsEntity newsEntity = newsRepository.findOneById(id);
		return newsConverter.toDTO(newsEntity);
	}

	@Override
	public void setCodeZero(Long id) {
		NewsEntity newsEntity = newsRepository.findOneById(id);
		newsEntity.setCode(0);
		newsRepository.save(newsEntity);
	}
}
