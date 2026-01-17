package br.com.allgoods.infrastructure.persistence.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

import java.math.BigDecimal;
import java.util.UUID;


@Entity
@Table(name = "tb_products")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class ProductEntity {

    @Id
    @GeneratedValue
    @Column(name = "id", updatable = false, nullable = false)
    private UUID id;

    @Column(name = "name", length = 50, nullable = false, unique = false)
    @NotNull
    @NotEmpty
    @Size(min = 3, max = 50)
    private String name;

    @Column(name = "price",nullable = false, unique = false)
    @NotNull
    private BigDecimal price;

    @Column(name = "category", length = 50, nullable = false, unique = false)
    @NotNull
    @NotEmpty
    @Size(min = 3, max = 50)
    private String category;

    @Column(name = "description", length = 100, nullable = false, unique = false)
    @NotNull
    @NotEmpty
    @Size(min = 3, max = 100)
    private String description;

    @Column(name = "supplier", length = 50, nullable = false, unique = false)
    @NotNull
    @NotEmpty
    @Size(min = 3, max = 50)
    private String supplier;



    // Getters e setters
    public UUID getId() { return id; }
    public String getName() { return name; }
    public String getDescription() { return description; }
    public String getCategory() { return category; }
    public BigDecimal getPrice() { return price; }
    public String getSupplier() { return supplier; }

    public void setId(UUID id) { this.id = id; }
    public void setName(String name) { this.name = name; }
    public void setDescription(String description) { this.description = description; }
    public void setCategory(String category) { this.category = category; }
    public void setPrice(BigDecimal price) { this.price = price; }
    public void setSupplier(String supplier) { this.supplier = supplier; }
}