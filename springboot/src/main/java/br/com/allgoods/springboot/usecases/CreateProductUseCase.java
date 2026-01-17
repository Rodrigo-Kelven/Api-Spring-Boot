package br.com.allgoods.springboot.usecases;

import br.com.allgoods.springboot.domain.ProductModel;
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
    public ProductResponseDto execute(ProductForm form) {
        ProductModel model = new ProductModel(
                form.name(),
                form.description(),
                form.category(),
                form.price(),
                form.supplier()
        );

            ProductEntity savedProduct = productRepository.save(model);

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
