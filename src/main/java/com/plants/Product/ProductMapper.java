package com.plants.Product;

import org.mapstruct.Mapper;

import java.util.List;

@Mapper(componentModel = "spring")
public interface ProductMapper {

    ProductDto to(Product product);
//    String map(byte[] image);
    List<ProductDto> to(List<Product> products);
}
