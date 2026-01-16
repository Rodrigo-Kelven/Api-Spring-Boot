package br.com.allgoods.springboot.models;

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
import jakarta.persistence.GenerationType;
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
public class ProductModel {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id")
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


}
