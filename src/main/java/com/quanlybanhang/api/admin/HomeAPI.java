package com.quanlybanhang.api.admin;

import com.quanlybanhang.service.IFeedbackService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

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
