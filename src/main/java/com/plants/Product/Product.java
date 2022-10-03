package com.plants.Product;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
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
    private String image;
    //TODO - add enum type

    public Product(String name, String description, int quantity, String image) {
        this.id = UUID.randomUUID();
        this.name = name;
        this.description = description;
        this.quantity = quantity;
        this.image = image;
    }
}
