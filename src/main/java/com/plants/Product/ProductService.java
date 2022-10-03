package com.plants.Product;

import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

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
}
