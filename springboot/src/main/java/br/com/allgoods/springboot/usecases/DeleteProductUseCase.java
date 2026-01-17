package br.com.allgoods.springboot.usecases;

import br.com.allgoods.springboot.infrastructure.persistence.entity.ProductEntity;
import br.com.allgoods.springboot.exception.ResourceNotFoundException;
import br.com.allgoods.springboot.port.ProductRepository;
import org.springframework.stereotype.Service;

import java.util.UUID;

@Service
public class DeleteProductUseCase {

    private final ProductRepository productRepository;

    public DeleteProductUseCase(ProductRepository productRepository) {
        this.productRepository = productRepository;
    }

    public void execute(UUID id){
        ProductEntity product = productRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException(
                        "Produto nao encontrado com id: " + id
                ));

        productRepository.deleteById(id);
    }


}
