package com.plants.Product;

import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Service
@AllArgsConstructor
public class ProductService {
    ProductRepository productRepository;

    public Product create(ProductCreateDto productCreateDto) {

        //TODO - productexistsybytitle validation

        Product product = new Product(
                productCreateDto.getName(),
                productCreateDto.getDescription(),
                productCreateDto.getQuantity(),
                productCreateDto.getImage()
        );

        return productRepository.save(product);
    }

    public List<Product> findAll() {
        return productRepository.findAll();
    }

    public Optional<Product> findById(UUID productId) {
        return productRepository.findById(productId);
        // TODO - add validation when not found
    }
}
