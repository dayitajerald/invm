package com.example.demo.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.example.demo.domain.Product;
import com.example.demo.service.ProductService;

import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

@Controller
@RequestMapping("/")
public class ProductController {

    @Autowired
    private ProductService service;

    @PostMapping("/addprod")
    public String addProuct(Product item) {
        service.saveProduct(item.getId(), item.getName(), item.getQuantity());
        return "redirect:/disp";
    }

    @PostMapping("/decrease")
    public String decreasequantity(Product item) {
        service.decreaseProduct(item.getId());
        return "redirect:/disp";
    }

}
