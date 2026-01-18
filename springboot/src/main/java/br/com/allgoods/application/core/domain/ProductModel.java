package br.com.allgoods.application.core.domain;

import java.math.BigDecimal;
import java.util.UUID;

public class ProductModel {

    private UUID id;
    private String name;
    private String description;
    private String category;
    private BigDecimal price;
    private String supplier;

    public ProductModel(String name, String description, String category,
                        BigDecimal price, String supplier) {
        this.id = UUID.randomUUID();
        this.name = name;
        this.description = description;
        this.category = category;
        this.price = price;
        this.supplier = supplier;
    }

    // getters
    public UUID getId() { return id; }
    public String getName() { return name; }
    public String getDescription() { return description; }
    public String getCategory() { return category; }
    public BigDecimal getPrice() { return price; }
    public String getSupplier() { return supplier; }

    // exemplo de regra de negócio
    public boolean isExpensive() {
        return price.compareTo(BigDecimal.valueOf(1000)) > 0;
    }
}
