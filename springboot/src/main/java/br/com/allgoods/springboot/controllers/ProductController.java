package br.com.allgoods.springboot.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.validation.annotation.Validated;

import br.com.allgoods.springboot.dtos.ProductRecordDto;
import br.com.allgoods.springboot.models.ProductModel;
import br.com.allgoods.springboot.services.ProductService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;

import java.math.BigDecimal;
import java.util.List;
import java.util.UUID;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;

@RestController
@RequestMapping("/api/v1/products")
@Tag(name = "API Products", description = "Operations relational of Products API")
public class ProductController {


    
    @Autowired // cria somente uma unica instancia desse objeto
    private ProductService productService;

    
    @GetMapping("/hello")
    @Operation(summary = "Create a new product", description = "Creates a new product in the system.")
    @ApiResponses(value = {
        @ApiResponse(responseCode = "201", description = "Product created successfully"),
        @ApiResponse(responseCode = "400", description = "Bad Request, invalid input data"),
        @ApiResponse(responseCode = "500", description = "Internal server error")

    })
    public String hello() {
        return "Hello, Welcome";
    }
}