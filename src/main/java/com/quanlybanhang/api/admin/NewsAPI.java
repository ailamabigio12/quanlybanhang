package com.quanlybanhang.api.admin;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

import com.quanlybanhang.dto.NewsDTO;
import com.quanlybanhang.service.INewsService;

@Controller(value = "newsAPIOfAdmin")
public class NewsAPI {

	@Autowired
	private INewsService newsService;
	
	@GetMapping(value = "/admin/danh-sach-tin-tuc")
	public String listNews(Model model) {		
		model.addAttribute("newslist", newsService.findAll());
		return "admin/newslist";
	}
	
	@DeleteMapping(value = "/admin/danh-sach-tin-tuc")
	public String deleteNews(@RequestBody Long id) {
		newsService.delete(id);
		return "redirect:/admin/danh-sach-tin-tuc?dsuccess";
	}
	
	@GetMapping(value = "/admin/tin-tuc")
	public String addnews(Model model, @RequestParam(value = "id", required = false) Long id) {
		NewsDTO newsDTO = new NewsDTO();
		if (id != null) {
			newsDTO = newsService.findById(id);			
		}		
		model.addAttribute("addnews", newsDTO);
		return "admin/news";
	}
	
	@PostMapping(value = "/admin/tin-tuc")
	public String addNews(@RequestParam(value = "file", required = false) MultipartFile file,
						  @ModelAttribute NewsDTO newsDTO) {
		newsService.saveNews(file, newsDTO);
		return "redirect:/admin/danh-sach-tin-tuc?csuccess";
	}
	
	@PutMapping(value = "/admin/tin-tuc")
	public String updateNews(@RequestParam(value = "id",required = false) Long id,
							 @RequestParam(value = "file", required = false) MultipartFile files,
							 @ModelAttribute NewsDTO newsDTO) {
		newsDTO.setId(id);
		newsService.saveNews(files, newsDTO);
		return "redirect:/admin/danh-sach-tin-tuc?fsuccess";
	}
}
