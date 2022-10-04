package com.plants.Product;

import lombok.AllArgsConstructor;
import lombok.Data;

import java.util.UUID;

@Data
@AllArgsConstructor
public class ProductDto {
    UUID id;
    String name;
    String description;
    Integer quantity;
    ProductType type;
    String image;
}
