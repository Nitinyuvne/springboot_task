package com.example.crudapp.controller;

import com.example.crudapp.model.Product;
import com.example.crudapp.service.ProductService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.List;

@Controller
public class POSController {

    private final ProductService productService;

    public POSController(ProductService productService) {
        this.productService = productService;
    }

    @GetMapping("/pos")
    public String posPage(Model model) {
        List<Product> products = productService.getAllProducts();
        model.addAttribute("products", products);
        return "pos";
    }
}
