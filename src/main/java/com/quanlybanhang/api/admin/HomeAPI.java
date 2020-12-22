package com.quanlybanhang.api.admin;

import com.quanlybanhang.dto.BannerDTO;
import com.quanlybanhang.service.IBannerService;
import com.quanlybanhang.service.IFeedbackService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

@Controller(value = "homeAPIOfAdmin")
public class HomeAPI {

    @Autowired
    private IFeedbackService feedbackService;

	@GetMapping(value = "/admin/danh-sach-gop-y")
    public String listfeedback(Model model) {
	    model.addAttribute("feedback", feedbackService.findAll());
	    return "admin/feedback";
    }
}
