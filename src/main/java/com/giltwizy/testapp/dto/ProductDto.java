package com.giltwizy.testapp.dto;

import jakarta.validation.constraints.NotBlank;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor(staticName = "build")
public class ProductDto {

    @NotBlank(message = "Product Name cannot be empty or null")
    private String productName;
    private double productPrice;
    private int productQuantity;
}
