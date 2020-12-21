package com.quanlybanhang.api.web;

import com.quanlybanhang.service.ICompanyService;
import com.quanlybanhang.service.IInfoService;
import com.quanlybanhang.service.IItemService;
import com.quanlybanhang.service.impl.InfoService;
import com.quanlybanhang.service.impl.ItemService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller(value = "itemAPIOfWeb")
public class ItemAPI {

    @Autowired
    private IItemService itemService;

    @Autowired
    private ICompanyService companyService;

    @Autowired
    private IInfoService infoService;

    @GetMapping(value = "/danh-sach-san-pham")
    public String listItem(Model model, @RequestParam(value = "companyid", required = false) Long id) {
        if (id == null) {
            return "redirect:/trang-chu";
        } else {
            model.addAttribute("companylist", companyService.findAll());
            model.addAttribute("itemlist", itemService.findAllByCompanyId(id));
            return "web/itemlist";
        }
    }

    @GetMapping(value = "/san-pham")
    public String showItem(Model model, @RequestParam(value = "id") Long id,
                           @RequestParam(value = "infoid") Long infoId) {
        model.addAttribute("companylist", companyService.findAll());
        model.addAttribute("item", itemService.findById(id));
        model.addAttribute("info", infoService.findById(infoId));
        return "web/item";
    }
}
