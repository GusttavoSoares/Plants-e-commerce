package com.plants.Product;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.math.BigDecimal;
import java.util.UUID;

@Entity
@Table(name = "products")
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class Product {
    @Id
    private UUID id;
    private String name;
    private String description;
    private int quantity;
    private BigDecimal price;
    @Enumerated(EnumType.STRING)
    private ProductType type;
//    @Lob
//    private byte[] image; // TODO - search how to add image

    public Product(String name, String description, int quantity, BigDecimal price, ProductType type/*, byte[] image */) {
        this.id = UUID.randomUUID();
        this.name = name;
        this.description = description;
        this.quantity = quantity;
        this.price = price;
        this.type = type;
//        this.image = image;
    }
}
