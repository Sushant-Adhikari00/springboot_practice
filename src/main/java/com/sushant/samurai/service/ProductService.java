package com.sushant.samurai.service;

import com.sushant.samurai.entity.Product;
import com.sushant.samurai.repo.ProductRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ProductService {
    @Autowired
    private ProductRepo productRepo;

    public Product saveProduct() {
        Product product = new Product();
        product.setName("Samurai");
        product.setDescription("Samurai");
        product.setPrice(23.0);
        return productRepo.save(product);
    }

}

