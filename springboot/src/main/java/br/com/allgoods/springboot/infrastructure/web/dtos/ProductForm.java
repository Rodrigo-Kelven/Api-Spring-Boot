package br.com.allgoods.springboot.infrastructure.web.dtos;

import java.io.Serializable;
import java.math.BigDecimal;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

public record ProductForm(

        @NotBlank(message = "Name is mandatory")
        String name,
        @NotBlank(message = "Description is mandatory")
        String description,
        @NotNull(message = "Price is mandatory")
        BigDecimal price,
        @NotBlank(message = "Category is mandatory")
        String category,
        @NotBlank(message = "Supplier is mandatory")
        String supplier
) implements Serializable {
}
