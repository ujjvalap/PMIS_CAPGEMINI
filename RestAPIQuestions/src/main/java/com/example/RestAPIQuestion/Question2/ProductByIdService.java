
package com.example.RestAPIQuestion.Question2;

import org.springframework.stereotype.Service;
import java.util.List;
import java.util.Optional;

@Service
public class ProductByIdService {

    private final List<product> products = List.of(
        new product(1, "Laptop", 50000),
        new product(2, "Mobile", 20000),
        new product(3, "Keyboard", 1500),
        new product(4, "Mouse", 800)
    );

    public Optional<product> findById(long id) {
        return products.stream()
                .filter(product -> product.id() == id)
                .findFirst();
    }
}
