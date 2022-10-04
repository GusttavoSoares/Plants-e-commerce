package com.plants.Product;

import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;
import java.util.Optional;
import java.util.UUID;

@RestController
@RequestMapping("/api/products")
@AllArgsConstructor
public class ProductController {
    private final ProductService productService;
    private final ProductMapper productMapper;
    @PostMapping
    public ResponseEntity<ProductDto> create(@Valid @RequestBody ProductCreateDto productCreateDto) {
        Product product = productService.create(productCreateDto);
        ProductDto productDto = productMapper.to(product);
        return new ResponseEntity<>(productDto, HttpStatus.CREATED);
    }

    @GetMapping
    public ResponseEntity<List<ProductDto>> index() {
        List<Product> products = productService.findAll();
        return ResponseEntity.ok(productMapper.to(products));
    }

    @GetMapping("{productId}")
    public ResponseEntity<ProductDto> show(@PathVariable UUID productId) {
        Optional<Product> productDto = productService.findById(productId);
        return ResponseEntity.ok(productMapper.to(productDto.get()));
    }
}
