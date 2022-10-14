package com.plants.Product;

import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping("/api/products")
@AllArgsConstructor
@CrossOrigin(origins = "*")
public class ProductController {

    private final ProductService productService;
    private final ProductMapper productMapper;

    @PostMapping
    public ResponseEntity<ProductDto> create(@Valid @RequestBody ProductCreateDto productCreateDto) {
        Product product = productService.create(productCreateDto);
        ProductDto productDto = productMapper.to(product);
        return new ResponseEntity<>(productDto, HttpStatus.CREATED);
    }

    @PutMapping("{productId}")
    public ResponseEntity<ProductDto> update(@PathVariable UUID productId, @Valid @RequestBody ProductCreateDto productCreateDto) {
        Product product = productService.update(productId, productCreateDto);
        return ResponseEntity.ok(productMapper.to(product));
    }

    @GetMapping
    public ResponseEntity<List<ProductDto>> index() {
        List<Product> products = productService.findAll();
        return ResponseEntity.ok(productMapper.to(products));
    }

    @GetMapping("{productId}")
    public ResponseEntity<ProductDto> show(@PathVariable UUID productId) {
        Product productDto = productService.findById(productId);
        return ResponseEntity.ok(productMapper.to(productDto));
    }

    @DeleteMapping("{productId}")
    public ResponseEntity<Void> delete(@PathVariable UUID productId) {
        productService.delete(productId);
        return ResponseEntity.noContent().build();
    }
}
