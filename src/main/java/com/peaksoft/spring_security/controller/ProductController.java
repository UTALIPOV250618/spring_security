package com.peaksoft.spring_security.controller;


import com.peaksoft.spring_security.entity.Product;
import com.peaksoft.spring_security.service.ProductService;
import lombok.RequiredArgsConstructor;
import org.springframework.context.annotation.Conditional;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;

@Controller
@RequiredArgsConstructor

public class ProductController {
    private final ProductService service;


    @RequestMapping("/")
    public String viewHomePage(Model model){
        List<Product> productList = service.getAllProduct();
        model.addAttribute("productList",productList);
        return "product_page";
    }
    @RequestMapping("/new")
    public String showNewPage(Model model){
        Product product = new Product();
        model.addAttribute("product",product);
        return "new_product";
    }
    @RequestMapping(value = "/save",method = RequestMethod.POST)
    public String saveProduct(@ModelAttribute("product") Product product){
        service.save(product);
        return "redirect:/";
    }

    @RequestMapping("/edit/{id}")
    public ModelAndView showEditPage(@PathVariable(name = "id")long id){
        ModelAndView view = new ModelAndView("edit_product");
        Product product = service.getById(id);
        view.addObject("product",product);
        return view;
    }

    @RequestMapping("/delete/{id}")
    public String deleteProduct(@PathVariable(name = "id")long id){
        service.delete(id);
        return "redirect:/";
    }

}
