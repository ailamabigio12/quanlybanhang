package com.quanlybanhang.api.admin;

import com.quanlybanhang.dto.BannerDTO;
import com.quanlybanhang.service.IBannerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

@Controller(value = "bannerAPIOfAdmin")
public class BannerAPI {

    @Autowired
    private IBannerService bannerService;

    @GetMapping(value = "/admin/quan-ly-anh")
    public String pictureManage(Model model) {
        model.addAttribute("banner", bannerService.findAll());
        return "admin/picturelist";
    }

    @GetMapping(value = "/admin/anh")
    public String pictureUpdate(Model model,
                                @RequestParam(value = "file", required = false) MultipartFile file,
                                @RequestParam(value = "id", required = false) Long id) {
        BannerDTO dto = new BannerDTO();
        if (id != null) {
            dto = bannerService.findById(id);
        }
        model.addAttribute("banner", dto);
        return "admin/picture";
    }

    @PostMapping(value = "/admin/anh")
    public String pictureUpdate(@RequestParam(value = "file", required = false) MultipartFile file,
                                @ModelAttribute BannerDTO bannerDTO) {
        bannerService.save(file, bannerDTO);
        return "redirect:/admin/quan-ly-anh?csuccess";
    }

    @PutMapping(value = "/admin/anh")
    public String pictureUpdate(@RequestParam(value = "file", required = false) MultipartFile file,
                                @RequestParam(value = "id") Long id,
                                @ModelAttribute BannerDTO bannerDTO) {
        bannerDTO.setId(id);
        bannerService.save(file, bannerDTO);
        return "redirect:/admin/quan-ly-anh?fsuccess";
    }
}
