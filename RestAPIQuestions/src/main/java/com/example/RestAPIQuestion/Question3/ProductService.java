
package com.example.RestAPIQuestion.Question3;

import java.util.concurrent.atomic.AtomicLong;
import org.springframework.stereotype.Service;

@Service("question3ProductService")
public class ProductService {

    private final AtomicLong nextId = new AtomicLong(1);

    public Product createProduct(CreateProductRequest request) {

        if (request == null) {
            throw new IllegalArgumentException("Product details are required");
        }

        if (request.name() == null || request.name().isBlank()) {
            throw new IllegalArgumentException("Product name is required");
        }

        if (request.price() < 0) {
            throw new IllegalArgumentException("Price cannot be negative");
        }

        return new Product(
                nextId.getAndIncrement(),
                request.name(),
                request.price()
        );
    }
}
