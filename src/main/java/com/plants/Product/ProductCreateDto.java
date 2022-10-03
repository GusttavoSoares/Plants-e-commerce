package com.plants.Product;

import lombok.Value;

import javax.validation.constraints.*;

@Value
public class ProductCreateDto {
   @NotNull
   @NotBlank
   @Size(min = 5, max = 60)
   String name;
   @NotNull
   @NotBlank
   @Size(min = 30, max = 5000)
   String description;
   @NotNull
   @Min(value = 1)
   @Max(value = 9999)
   Integer quantity;
   @NotNull
   @NotBlank
   String image;
   // TOOD - Add enum type
}
