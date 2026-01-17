package br.com.allgoods.springboot.infrastructure.persistence.repository;

import br.com.allgoods.springboot.domain.ProductModel;
import br.com.allgoods.springboot.infrastructure.persistence.entity.ProductEntity;
import br.com.allgoods.springboot.port.ProductRepository;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Repository;
import java.util.Optional;
import java.util.UUID;

@Repository
public class ProductRepositoryImpl implements ProductRepository {

    private final ProductRepositoryConcret productRepositoryConcret;

    public ProductRepositoryImpl(ProductRepositoryConcret productRepositoryConcret) {
        this.productRepositoryConcret = productRepositoryConcret;
    }


    @Override
    public ProductEntity save(ProductModel product) {
        ProductEntity entity = new ProductEntity(
                null,
                product.getName(),
                product.getPrice(),
                product.getDescription(),
                product.getCategory(),
                product.getSupplier()
        );


        return productRepositoryConcret.save(entity);
    }


    @Override
    public Page<ProductEntity> findAll(int page, int size) {

        Pageable pageable = PageRequest.of(page, size);

        return productRepositoryConcret.findAll(pageable)
                .map(this::toDomain);
    }

    private ProductEntity toDomain(ProductEntity entity) {
        return new ProductEntity(
                entity.getId(),
                entity.getName(),
                entity.getPrice(),
                entity.getDescription(),
                entity.getCategory(),
                entity.getSupplier()
        );
    }
    
    @Override
    public Optional<ProductEntity> findById(UUID id){
        return productRepositoryConcret.findById(id);
    }

    @Override
    public void deleteById(UUID id){
        productRepositoryConcret.deleteById(id);
    }
}
