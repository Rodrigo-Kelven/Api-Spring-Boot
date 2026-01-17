package br.com.allgoods.springboot.domain.product;

import java.math.BigDecimal;
import java.util.UUID;

public class Product {

    private UUID id;
    private String name;
    private BigDecimal price;
    private String category;
    private String supplier;

    public Product(UUID id, String name, BigDecimal price,
                   String category, String supplier) {
        this.id = id;
        this.name = name;
        this.price = price;
        this.category = category;
        this.supplier = supplier;
    }

    // regras de negócio aqui
}
