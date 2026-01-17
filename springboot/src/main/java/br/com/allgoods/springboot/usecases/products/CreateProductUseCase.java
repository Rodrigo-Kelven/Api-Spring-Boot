package br.com.allgoods.springboot.usecases.products;

import br.com.allgoods.springboot.infrastructure.web.dtos.ProductForm;
import br.com.allgoods.springboot.infrastructure.web.dtos.ProductResponseDto;
import br.com.allgoods.springboot.infrastructure.persistence.entity.ProductEntity;
import br.com.allgoods.springboot.port.ProductRepository;
import jakarta.transaction.Transactional;
import org.springframework.stereotype.Service;

@Service
public class CreateProductUseCase {

    private final ProductRepository productRepository;

    public CreateProductUseCase(ProductRepository productRepository) {
        this.productRepository = productRepository;
    }

    @Transactional
    public ProductResponseDto execute(ProductForm productForm) {
        ProductEntity productEntity = new ProductEntity(
                null,
                productForm.name(),
                productForm.price(),
                productForm.description(),
                productForm.category(),
                productForm.supplier()
        );

        ProductEntity savedProduct = productRepository.save(productEntity);

        return new ProductResponseDto(
                savedProduct.getId(),
                savedProduct.getName(),
                savedProduct.getDescription(),
                savedProduct.getCategory(),
                savedProduct.getPrice(),
                savedProduct.getSupplier()
        );

    }
}
