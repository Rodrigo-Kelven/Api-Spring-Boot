package br.com.allgoods.application.ports.inbound;

import br.com.allgoods.infrastructure.adapter.dtos.ProductForm;
import br.com.allgoods.infrastructure.adapter.dtos.ProductResponseDto;
import org.springframework.data.domain.Page;

import java.util.UUID;

public interface ProductUseCasePort {

    ProductResponseDto createProducts(ProductForm productForm);
    Page<ProductResponseDto> getAllProducts(int page, int size);
    ProductResponseDto getProductById(UUID id);
    void deleteProductById(UUID id);
    void deleteAllProducts();

}
