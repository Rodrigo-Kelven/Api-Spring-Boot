package br.com.allgoods.springboot.infrastructure.persistence.repository;

import br.com.allgoods.springboot.infrastructure.persistence.entity.ProductEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import java.util.UUID;

@Repository
public interface ProductRepositoryConcret extends JpaRepository<ProductEntity, UUID> {}
