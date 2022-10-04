package com.plants.Product;

import lombok.Value;

import javax.validation.Valid;
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
   @Valid
   @NotNull
   ProductType type;
   @NotNull
   @NotBlank
   String image;
}
