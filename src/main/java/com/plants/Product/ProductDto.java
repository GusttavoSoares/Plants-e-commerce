package com.plants.Product;

import lombok.AllArgsConstructor;
import lombok.Data;

import java.math.BigDecimal;
import java.util.UUID;

@Data
@AllArgsConstructor
public class ProductDto {
    UUID id;
    String name;
    String description;
    Integer quantity;
    BigDecimal price;
    ProductType type;
    String image;
}
