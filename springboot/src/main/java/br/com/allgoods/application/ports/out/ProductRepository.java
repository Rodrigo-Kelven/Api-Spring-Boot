package br.com.allgoods.application.ports.out;

import br.com.allgoods.domain.ProductModel;
import br.com.allgoods.infrastructure.persistence.entity.ProductEntity;
import org.springframework.data.domain.Page;
import java.util.Optional;
import java.util.UUID;

public interface ProductRepository {

    ProductEntity save(ProductModel product);
    Page<ProductEntity> findAll(int page, int size);
    Optional<ProductEntity> findById(UUID id);
    void deleteById(UUID id);
}