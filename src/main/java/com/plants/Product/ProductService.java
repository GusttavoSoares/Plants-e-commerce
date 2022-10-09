package com.plants.Product;

import com.plants.exceptions.ResourceAlreadyExistsException;
import com.plants.exceptions.ResourceNotFoundException;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;

@Service
@AllArgsConstructor
public class ProductService {
    ProductRepository productRepository;

    public Product create(ProductCreateDto productCreateDto) {

        if(productRepository.existsByName(productCreateDto.getName())) {
            throw new ResourceAlreadyExistsException("product", "name", productCreateDto.getName());
        }

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
        Product product = findById(productId);

        if(productRepository.existsByNameAndIdNot(productCreateDto.getName(), productId)) {
            throw new ResourceAlreadyExistsException("product", "name", productCreateDto.getName());
        }

        product.setName(productCreateDto.getName());
        product.setDescription(productCreateDto.getDescription());
        product.setQuantity(productCreateDto.getQuantity());
        product.setType(productCreateDto.getType());
        product.setImage(productCreateDto.getImage());

        return productRepository.save(product);
    }

    public List<Product> findAll() {
        return productRepository.findAll();
    }

    public Product findById(UUID productId) {
        return productRepository.findById(productId)
                .orElseThrow(() -> new ResourceNotFoundException("product", productId));
    }
    public void delete(UUID productId) {
        Product product = findById(productId);
        productRepository.deleteById(productId);
    }
}
