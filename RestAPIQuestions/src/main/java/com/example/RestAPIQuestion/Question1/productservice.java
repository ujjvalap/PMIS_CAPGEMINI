package com.example.RestAPIQuestion.Question1;

import org.springframework.stereotype.Service;

import java.util.List;

@Service("question1ProductService")
public class productservice {

    private final List<product> products = List.of(
            new product(1, "Keyboard", 49.99),
            new product(2, "Mouse", 19.99)
    );

    public List<product> findAll() {
        return products;
    }
}
