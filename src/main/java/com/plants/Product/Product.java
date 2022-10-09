package com.plants.Product;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
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
    @Enumerated(EnumType.STRING)
    private ProductType type;
    private String image; // TODO - search how to add image

    public Product(String name, String description, int quantity, ProductType type, String image) {
        this.id = UUID.randomUUID();
        this.name = name;
        this.description = description;
        this.quantity = quantity;
        this.type = type;
        this.image = image;
    }
}
