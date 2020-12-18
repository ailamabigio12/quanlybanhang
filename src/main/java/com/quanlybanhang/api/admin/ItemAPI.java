package com.quanlybanhang.api.admin;


import com.quanlybanhang.dto.CompanyDTO;
import com.quanlybanhang.dto.InfoDTO;
import com.quanlybanhang.dto.ItemDTO;
import com.quanlybanhang.service.ICompanyService;
import com.quanlybanhang.service.IInfoService;
import com.quanlybanhang.service.IItemService;
import org.hibernate.validator.constraints.SafeHtml;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.util.ArrayList;
import java.util.List;

@Controller(value = "itemAPIOfAdmin")
public class ItemAPI {

    @Autowired
    private IItemService itemService;

    @Autowired
    private ICompanyService companyService;

    @Autowired
    private IInfoService infoService;

    @GetMapping(value = "/admin/danh-sach-san-pham")
        public String listItem(Model model) {
            model.addAttribute("itemlist", itemService.findAll());
            return "admin/itemlist";
    }

    @PutMapping(value = "/admin/danh-sach-san-pham")
        public String deleteItem(@RequestParam(value = "itemid") Long id,
                                 @ModelAttribute ItemDTO itemDTO) {
            itemService.setCodeZero(itemDTO);
            return "redirect:/admin/danh-sach-san-pham?dsuccess";
    }

    @GetMapping(value = "/admin/san-pham")
        public String addItem(Model model, @RequestParam(value = "itemid", required = false) Long itemid) {
            ItemDTO itemDTO = new ItemDTO();
            InfoDTO infoDTO = new InfoDTO();
            if (itemid != null) {
                itemDTO = itemService.findById(itemid);
            }
            model.addAttribute("company", companyService.findAll());
            model.addAttribute("additem", itemDTO);
            model.addAttribute("infoitem", infoDTO);
            return "admin/item";
    }

    @PostMapping(value = "/admin/san-pham")
        public String addItem(@RequestParam(value = "file",required = false) MultipartFile file,
                              @ModelAttribute ItemDTO itemDTO,
                              @ModelAttribute InfoDTO infoDTO) {
            InfoDTO infopost = infoService.save(infoDTO);
            itemService.save(file, itemDTO, infopost);
            return "redirect:/admin/danh-sach-san-pham?csuccess";
    }

    @PutMapping(value = "/admin/san-pham")
        public String updateItem(@RequestParam(value = "itemid") Long id,
                                 @RequestParam(value = "file", required = false) MultipartFile file,
                                 @ModelAttribute ItemDTO itemDTO,
                                 @ModelAttribute InfoDTO infoDTO) {
            InfoDTO infoput = infoService.save(infoDTO);
            itemDTO.setId(id);
            itemService.save(file, itemDTO, infoput);
            return "redirect:/admin/danh-sach-san-pham?fsuccess";
    }
}