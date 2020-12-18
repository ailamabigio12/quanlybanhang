package com.quanlybanhang.api.admin;

import com.quanlybanhang.dto.UserDTO;
import com.quanlybanhang.service.IUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class UserAPI {

    @Autowired
    private IUserService userService;

    @GetMapping(value = "/dang-nhap")
    public String login() {
        return "login";
    }

    @GetMapping(value = "/admin/tao-tai-khoan")
    public String register(Model model) {
        model.addAttribute("user", new UserDTO());
        return "admin/register";
    }

    @GetMapping(value = "/admin/danh-sach-quan-ly")
    public String listUsers(Model model) {
        model.addAttribute("userlist", userService.findAll());
        return "admin/userlist";
    }

    @PostMapping(value = "/admin/tao-tai-khoan")
    public String register(@ModelAttribute UserDTO userDTO) {
        userService.registerUser(userDTO);
        return "redirect:/admin/danh-sach-quan-ly?csuccess";
    }

}
