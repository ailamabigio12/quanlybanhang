package com.quanlybanhang.api.web;

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
    private ItemService itemService;

    @Autowired
    private InfoService infoService;

    @GetMapping(value = "/danh-sach-san-pham")
    public String listItem(Model model) {
        model.addAttribute("itemlist", itemService.findAll());
        return "web/itemlist";
    }

    @GetMapping(value = "/san-pham")
    public String showItem(Model model, @RequestParam(value = "id") Long id,
                           @RequestParam(value = "infoid") Long infoId) {
        model.addAttribute("item", itemService.findById(id));
        System.out.println(infoId);
        model.addAttribute("info", infoService.findById(infoId));
        return "web/item";
    }
}
