package com.quanlybanhang.api.web;

import com.quanlybanhang.dto.CommentDTO;
import com.quanlybanhang.service.*;
import com.quanlybanhang.service.impl.InfoService;
import com.quanlybanhang.service.impl.ItemService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller(value = "itemAPIOfWeb")
public class ItemAPI {

    @Autowired
    private IItemService itemService;

    @Autowired
    private ICompanyService companyService;

    @Autowired
    private IInfoService infoService;

    @Autowired
    private IBannerService bannerService;

    @Autowired
    private ICommentService commentService;

    @GetMapping(value = "/danh-sach-san-pham")
    public String listItem(Model model, @RequestParam(value = "companyid", required = false) Long id) {
        if (id == null) {
            return "redirect:/trang-chu";
        } else {
            model.addAttribute("banner", bannerService.findAll());
            model.addAttribute("companylist", companyService.findAll());
            model.addAttribute("itemlist", itemService.findAllByCompanyId(id));
            return "web/itemlist";
        }
    }

    @GetMapping(value = "/san-pham")
    public String showItem(Model model, @RequestParam(value = "id") Long id,
                           @RequestParam(value = "infoid") Long infoId) {
        System.out.println(itemService.findById(id));
        model.addAttribute("companylist", companyService.findAll());
        model.addAttribute("item", itemService.findById(id));
        model.addAttribute("info", infoService.findById(infoId));
        model.addAttribute("comment", commentService.findAll(itemService.findById(id)));
        return "web/item";
    }

//    Comment in item page
    @PostMapping(value = "/san-pham")
    public String commentItem(@RequestParam(value = "id") Long id,
                              @ModelAttribute CommentDTO commentDTO) {
        commentService.save(commentDTO, id);
        return "redirect:/san-pham?id=" + id;
    }

    @PutMapping(value = "/san-pham")
    public String deleteItem(@RequestParam(value = "id") Long id,
                             @ModelAttribute CommentDTO commentDTO) {
        System.out.println(commentDTO.getId());
        commentService.setCodeZero(commentDTO.getId());
        return "redirect:/san-pham?id=" + id;
    }
}
