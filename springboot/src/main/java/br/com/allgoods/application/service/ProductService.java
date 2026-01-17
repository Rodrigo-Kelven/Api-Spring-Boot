package br.com.allgoods.application.service;


import br.com.allgoods.domain.ProductModel;
import br.com.allgoods.application.exception.ResourceNotFoundException;
import br.com.allgoods.infrastructure.persistence.entity.ProductEntity;
import br.com.allgoods.infrastructure.adapter.dtos.ProductForm;
import br.com.allgoods.infrastructure.adapter.dtos.ProductResponseDto;
import br.com.allgoods.application.ports.in.ProductUseCase;
import br.com.allgoods.application.ports.out.ProductRepository;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Service;

import java.util.UUID;

@Service
public class ProductService implements ProductUseCase {

    private final ProductRepository productRepository;

    public ProductService(ProductRepository productRepository) {
        this.productRepository = productRepository;
    }

    @Override
    public ProductResponseDto createProducts(ProductForm productForm) {

        ProductModel model = new ProductModel(
                productForm.name(),
                productForm.description(),
                productForm.category(),
                productForm.price(),
                productForm.supplier()
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

    @Override
    public Page<ProductResponseDto> getAllProducts(int page, int size){
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

    @Override
    public ProductResponseDto getProductById(UUID id) {
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

    @Override
    public void deleteProductById(UUID id){
        ProductEntity product = productRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException(
                        "Produto nao encontrado com id: " + id
                ));

        productRepository.deleteById(id);
    }

}
