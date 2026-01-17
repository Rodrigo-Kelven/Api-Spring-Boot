package br.com.allgoods.springboot.port;

import br.com.allgoods.springboot.infrastructure.persistence.entity.ProductEntity;
import org.springframework.data.domain.Page;

import java.util.Optional;
import java.util.UUID;

public interface ProductRepository {

    ProductEntity save(ProductEntity product);
    Page<ProductEntity> findAll(int page, int size);
    Optional<ProductEntity> findById(UUID id);
    void deleteById(UUID id);
}