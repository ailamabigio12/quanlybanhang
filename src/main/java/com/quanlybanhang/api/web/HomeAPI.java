package com.quanlybanhang.api.web;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller(value = "homeAPIOfWeb")
public class HomeAPI {
	
	@GetMapping(value = "/trang-chu")
	public String homepage() {
		return "web/homepage";
	}
}