package br.com.allgoods.infrastructure.adapter.inbound;

import br.com.allgoods.application.ports.inbound.ProductUseCasePort;
import br.com.allgoods.infrastructure.adapter.dtos.ProductResponseDto;
import jakarta.validation.Valid;
import org.springframework.data.domain.Page;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import br.com.allgoods.infrastructure.adapter.dtos.ProductForm;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import java.util.UUID;

@RestController
@RequestMapping("/api/v1")
@Tag(name = "API Products", description = "Operations relational of Products API")
public class ProductController {


    private final ProductUseCasePort productUseCasePort;

    public ProductController(ProductUseCasePort productUseCasePort) {
        this.productUseCasePort = productUseCasePort;
    }


    @PostMapping("/products")
    @Operation(summary = "Create a new product", description = "Creates a new product in the system.")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "201", description = "Product created successfully"),
            @ApiResponse(responseCode = "400", description = "Bad Request, invalid input data"),
            @ApiResponse(responseCode = "500", description = "Internal server error")
    })
    @ResponseStatus(HttpStatus.CREATED)
    public ResponseEntity<ProductResponseDto> registerProduct(@RequestBody @Valid ProductForm productForm) {
        return ResponseEntity.status(HttpStatus.CREATED)
                .header("X-Custom-Header", "Produto criado com sucesso!!")
                .body(productUseCasePort.createProducts(productForm));
    }

    @GetMapping("/products")
    @Operation(summary = "List all Products", description = "List all products in the system.")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Products listed successfully"),
            @ApiResponse(responseCode = "400", description = "Bad Request, invalid input data"),
            @ApiResponse(responseCode = "500", description = "Internal server error")
    })
    @ResponseStatus(HttpStatus.OK)
    public ResponseEntity<Page<ProductResponseDto>> getAllProducts(
            @RequestParam(defaultValue = "0") int page,
            @RequestParam(defaultValue = "10") int size
    ) {
        Page<ProductResponseDto> products = productUseCasePort.getAllProducts(page, size);

        return ResponseEntity.status(HttpStatus.OK)
                .header("X-Custom-Header", "Produtos listados encontrado!")
                .body(products);
    }

    @GetMapping("/products/{id}")
    @Operation(summary = "Find Product by id", description = "Find product by id in the system.")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Product found successfully"),
            @ApiResponse(responseCode = "400", description = "Bad Request, invalid input data"),
            @ApiResponse(responseCode = "500", description = "Internal server error")
    })
    @ResponseStatus(HttpStatus.OK)
    public ResponseEntity<ProductResponseDto> getProductsByid(@PathVariable UUID id) {
        return ResponseEntity.status(HttpStatus.OK)
                .header("X-Custom-Header", "Produto encontrado com sucesso!")
                .body(productUseCasePort.getProductById(id));

    }

    @DeleteMapping("/products/{id}")
    @Operation(summary = "Delete Product by id", description = "Delete product by id in the system.")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "204", description = "Product deleted successfully"),
            @ApiResponse(responseCode = "400", description = "Bad Request, invalid input data"),
            @ApiResponse(responseCode = "500", description = "Internal server error")
    })
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public ResponseEntity<Void> deleteProductById(@PathVariable UUID id) {
        productUseCasePort.deleteProductById(id);
        return ResponseEntity.status(HttpStatus.NO_CONTENT)
                .header("X-Custom-Header", "Produto deletado com sucesso!")
                .build();
    }


    @DeleteMapping("/products/")
    @Operation(summary = "Delete all Product", description = "Delete all product in the system.")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "204", description = "Products deleted successfully"),
            @ApiResponse(responseCode = "400", description = "Bad Request, invalid input data"),
            @ApiResponse(responseCode = "500", description = "Internal server error")
    })
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public ResponseEntity<Void> deleteAllProducts(){
        productUseCasePort.deleteAllProducts();
        return ResponseEntity.status(HttpStatus.NO_CONTENT)
                .header("X-Custom-Header", "Produto deletado com sucesso!")
                .build();

    }


}