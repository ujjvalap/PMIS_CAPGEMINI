package com.example.RestAPIQuestion.Question4;

import java.util.Map;
import java.util.Optional;
import java.util.concurrent.ConcurrentHashMap;

import org.springframework.stereotype.Service;

@Service("question4ProductService")
public class ProductService {

    private final Map<Long, Product> products = new ConcurrentHashMap<>();

    public ProductService() {
        products.put(1L, new Product(1, "Laptop", 55000));
        products.put(2L, new Product(2, "Mouse", 500));
        products.put(3L, new Product(3, "Monitor", 199.99));
    }

    public Optional<Product> update(long id, UpdateProductRequest request) {

        if (request == null || !products.containsKey(id)) {
            return Optional.empty();
        }

        Product updatedProduct = new Product(
                id,
                request.name(),
                request.price()
        );

        products.put(id, updatedProduct);

        return Optional.of(updatedProduct);
    }
}