package com.quanlybanhang.api.web;

import com.quanlybanhang.dto.FeedbackDTO;
import com.quanlybanhang.entites.CompanyEntity;
import com.quanlybanhang.service.IBannerService;
import com.quanlybanhang.service.ICompanyService;
import com.quanlybanhang.service.IFeedbackService;
import com.quanlybanhang.service.IItemService;
import com.quanlybanhang.service.impl.CompanyService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

@Controller(value = "homeAPIOfWeb")
public class HomeAPI {

	@Autowired
	private ICompanyService companyService;

	@Autowired
	private IItemService itemService;

	@Autowired
	private IFeedbackService feedbackService;

	@Autowired
	private IBannerService bannerService;
	
	@GetMapping(value = "/trang-chu")
	public String homepage(Model model) {
		model.addAttribute("banner", bannerService.findAll());
		model.addAttribute("companylist", companyService.findAll());
		model.addAttribute("itemlist", itemService.findAll());
		return "web/homepage";
	}

	@GetMapping(value = {"/", ""})
	public String homepage() {
		return "redirect:/trang-chu";
	}

	@GetMapping(value ="/gop-y")
	public String feedback(Model model) {
		model.addAttribute("feedback", new FeedbackDTO());
		return "web/feedback";
	}

	@PostMapping(value = "/gop-y")
	public String feedback(@ModelAttribute FeedbackDTO feedbackDTO) {
		feedbackService.save(feedbackDTO);
		return "redirect:/trang-chu?success";
	}
}