package br.com.allgoods.springboot.services;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import br.com.allgoods.springboot.repositories.ProductRepository;


@Service
public class ProductService {

    @Autowired // cria somente uma unica instancia desse objeto
    private ProductRepository productRepository;

}