
package com.example.RestAPIQuestion.Question2;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/products")
public class ProductByIdController {

    private final ProductByIdService productService;

    public ProductByIdController(ProductByIdService productService) {
        this.productService = productService;
    }

    @GetMapping("/{id}")
    public ResponseEntity<product> getProduct(@PathVariable long id) {

        return productService.findById(id)
                .map(ResponseEntity::ok)
                .orElseGet(() -> ResponseEntity.notFound().build());
    }
}
