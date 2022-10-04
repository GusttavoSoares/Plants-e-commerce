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
                productCreateDto.getType(),
                productCreateDto.getImage()
        );

        return productRepository.save(product);
    }

    public Product update(UUID productId, ProductCreateDto productCreateDto) {
        Optional<Product> product = findById(productId);

        product.get().setName(productCreateDto.getName());
        product.get().setDescription(productCreateDto.getDescription());
        product.get().setQuantity(productCreateDto.getQuantity());
        product.get().setType(productCreateDto.getType());
        product.get().setImage(productCreateDto.getImage());

        return productRepository.save(product.get());
    }

    public List<Product> findAll() {
        return productRepository.findAll();
    }

    public Optional<Product> findById(UUID productId) {
        return productRepository.findById(productId);
        // TODO - add validation when not found
    }

    public void delete(UUID productId) {
        productRepository.deleteById(productId);
    }
}
