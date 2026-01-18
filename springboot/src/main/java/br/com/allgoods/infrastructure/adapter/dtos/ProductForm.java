package br.com.allgoods.infrastructure.adapter.dtos;

import java.io.Serializable;
import java.math.BigDecimal;

public record ProductForm(

        String name,
        String description,
        String category,
        BigDecimal price,
        String supplier
) implements Serializable {
}