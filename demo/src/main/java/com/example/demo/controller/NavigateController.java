package com.example.demo.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.example.demo.domain.Product;
import com.example.demo.service.ProductService;

@Controller
public class NavigateController {

    @Autowired
    private ProductService service;

    @GetMapping("/")
    public String getindex() {
        return "index";
    }

    @GetMapping("/disp")
    public String display(Model model) {
        List<Product> products = service.listAllProducts();
        model.addAttribute("products", products);
        return "disp";
    }

    @GetMapping("/ava")
    public String availableItems(Model modelava) {
        List<Product> products = service.availableProducts();
        modelava.addAttribute("avaproducts", products);
        return "available";
    }

}
