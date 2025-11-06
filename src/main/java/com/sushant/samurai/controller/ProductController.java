package com.sushant.samurai.controller;

import com.sushant.samurai.entity.Product;
import com.sushant.samurai.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("api/product")
public class ProductController {
    @Autowired
    private ProductService productService;
    @PostMapping("/save")
    public Product saveProduct(){
        return productService.saveProduct();
    }
}
