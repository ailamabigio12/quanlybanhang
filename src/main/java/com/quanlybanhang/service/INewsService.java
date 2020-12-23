package com.quanlybanhang.service;

import com.quanlybanhang.dto.NewsDTO;
import com.quanlybanhang.entites.NewsEntity;
import org.springframework.web.multipart.MultipartFile;

import java.util.List;

public interface INewsService {

	List<NewsDTO> findAll();
	
	NewsDTO findById(Long id);
	
	NewsDTO saveNews(MultipartFile multipartFile, NewsDTO newsDTO);
	
	void setCodeZero(Long id);
}
