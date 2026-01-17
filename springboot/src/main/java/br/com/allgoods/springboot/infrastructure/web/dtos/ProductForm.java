package br.com.allgoods.springboot.infrastructure.web.dtos;

import java.io.Serializable;
import java.math.BigDecimal;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

public record ProductForm(

        String name,
        String description,
        String category,
        BigDecimal price,
        String supplier
) implements Serializable {
}
