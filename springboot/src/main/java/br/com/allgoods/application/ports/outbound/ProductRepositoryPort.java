package br.com.allgoods.application.ports.outbound;

import br.com.allgoods.application.core.domain.ProductModel;
import br.com.allgoods.infrastructure.persistence.entity.ProductEntity;
import org.springframework.data.domain.Page;
import java.util.Optional;
import java.util.UUID;

public interface ProductRepositoryPort {

    ProductEntity save(ProductModel product);
    Page<ProductEntity> findAll(int page, int size);
    Optional<ProductEntity> findById(UUID id);
    void deleteById(UUID id);

}