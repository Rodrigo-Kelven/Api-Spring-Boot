package br.com.allgoods.springboot.usecases;

import br.com.allgoods.springboot.infrastructure.web.dtos.ProductResponseDto;
import br.com.allgoods.springboot.exception.ResourceNotFoundException;
import br.com.allgoods.springboot.infrastructure.persistence.entity.ProductEntity;
import br.com.allgoods.springboot.infrastructure.persistence.repository.ProductRepositoryImpl;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Service;


@Service
public class FindAllProductsUseCase {

    private final ProductRepositoryImpl productRepository;

    public FindAllProductsUseCase(ProductRepositoryImpl productRepository) {
        this.productRepository = productRepository;
    }

    public Page<ProductResponseDto> execute(int page, int size) {
        Page<ProductEntity> products = productRepository.findAll(page, size);

        if (products.isEmpty()) {
            throw new ResourceNotFoundException("Nenhum produto encontrado.");
        }

        return products.map(product ->
                new ProductResponseDto(
                        product.getId(),
                        product.getName(),
                        product.getDescription(),
                        product.getCategory(),
                        product.getPrice(),
                        product.getSupplier()
                )
        );
    }
}
