package br.com.allgoods.infrastructure.adapter.inbound

import br.com.allgoods.application.ports.inbound.ProductUseCasePort
import br.com.allgoods.infrastructure.adapter.dtos.ProductForm
import br.com.allgoods.infrastructure.adapter.dtos.ProductResponseDto
import io.swagger.v3.oas.annotations.tags.Tag
import jakarta.validation.Valid
import org.springframework.http.HttpStatus
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.*

@RestController
@RequestMapping("/products-kotlin")
@Tag(
    name = "Products Controller (Kotlin)",
    description = "Endpoints de produtos usando Spring Boot e Kotlin"
)
class ProductControllerKotlin(
    private val productUseCasePort: ProductUseCasePort
) {

    @GetMapping
    fun hello(): String = "Hello, Welcome"

    @PostMapping
    fun createProduct(
        @RequestBody @Valid productForm: ProductForm
    ): ResponseEntity<ProductResponseDto> {

        return ResponseEntity
            .status(HttpStatus.CREATED)
            .header("X-Custom-Header", "Produto criado com sucesso!!")
            .body(productUseCasePort.createProducts(productForm))
    }
}
