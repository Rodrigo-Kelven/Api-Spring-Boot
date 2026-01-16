package br.com.allgoods.springboot.dtos;

import java.io.Serializable;
import java.math.BigDecimal;

import br.com.allgoods.springboot.models.ProductModel;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

public record ProductRecordDto(

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
) {
    // DTO → Model
    public static ProductModel fromDto(ProductRecordDto dto) {
        return new ProductModel(
                null,
                dto.name(),
                dto.price(),
                dto.description(),
                dto.category(),
                dto.supplier()
        );
    }

    // Model → DTO
    public static ProductRecordDto fromModel(ProductModel model) {
        return new ProductRecordDto(
                model.getName(),
                model.getDescription(),
                model.getPrice(),
                model.getCategory(),
                model.getSupplier()
        );
    }
}
