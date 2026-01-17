package br.com.allgoods.springboot.usecases.products;

import br.com.allgoods.springboot.infrastructure.web.dtos.ProductResponseDto;
import br.com.allgoods.springboot.exception.ResourceNotFoundException;
import br.com.allgoods.springboot.infrastructure.persistence.entity.ProductEntity;
import br.com.allgoods.springboot.port.ProductRepository;
import org.springframework.stereotype.Service;
import java.util.UUID;

@Service
public class FindByIdProductUseCase {

    private final ProductRepository productRepository;

    public FindByIdProductUseCase(ProductRepository productRepository) {
        this.productRepository = productRepository;
    }

    public ProductResponseDto execute(UUID id) {
            ProductEntity product = productRepository.findById(id)
                    .orElseThrow(() -> new ResourceNotFoundException(
                            "Produto nao encontrado com id: " + id
                    ));

            return new ProductResponseDto(
                    product.getId(),
                    product.getName(),
                    product.getDescription(),
                    product.getCategory(),
                    product.getPrice(),
                    product.getSupplier()
            );

        }

}
