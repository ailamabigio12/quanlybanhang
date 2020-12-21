package com.quanlybanhang.api.web;

import com.quanlybanhang.entites.CompanyEntity;
import com.quanlybanhang.service.ICompanyService;
import com.quanlybanhang.service.IItemService;
import com.quanlybanhang.service.impl.CompanyService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller(value = "homeAPIOfWeb")
public class HomeAPI {

	@Autowired
	private ICompanyService companyService;

	@Autowired
	private IItemService itemService;
	
	@GetMapping(value = "/trang-chu")
	public String homepage(Model model) {
		model.addAttribute("companylist", companyService.findAll());
		model.addAttribute("itemlist", itemService.findAll());
		return "web/homepage";
	}
}