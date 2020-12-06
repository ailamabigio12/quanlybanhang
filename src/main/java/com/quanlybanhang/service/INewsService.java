package com.quanlybanhang.service;

import java.util.List;

import org.springframework.web.multipart.MultipartFile;

import com.quanlybanhang.dto.NewsDTO;
import com.quanlybanhang.entites.NewsEntity;

public interface INewsService {

	public List<NewsEntity> findAll();
	
	public NewsDTO findById(Long id);
	
	public NewsDTO saveNews(MultipartFile multipartFile, NewsDTO newsDTO);
	
	public void delete(Long id); 
}
