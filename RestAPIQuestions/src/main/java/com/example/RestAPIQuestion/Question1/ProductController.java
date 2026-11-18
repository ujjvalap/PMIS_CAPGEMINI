package com.example.RestAPIQuestion.Question1;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController("question1ProductController")
@RequestMapping("/api/products")
public class ProductController {

    private final productservice productService;

    public ProductController(productservice productService) {
        this.productService = productService;
    }

    @GetMapping
    public List<product> getProducts() {
        return productService.findAll();
    }
}
