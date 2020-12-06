package com.quanlybanhang.api.web;

import com.quanlybanhang.dto.NewsDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.w3c.dom.html.HTMLModElement;

import com.quanlybanhang.service.INewsService;

@Controller(value = "newsAPIOfWeb")
public class NewsAPI {
	
	@Autowired
	private INewsService newsService;
	
	@GetMapping(value = "/danh-sach-tin-tuc")
		public String listNews(Model model) {
			model.addAttribute("newslist", newsService.findAll());
			return "web/newslist";
		}

	@GetMapping(value = "/tin-tuc")
		public String showNews(Model model, @RequestParam(value = "id") Long id) {
			model.addAttribute("showNews", newsService.findById(id));
			return "web/news";
	}
}
