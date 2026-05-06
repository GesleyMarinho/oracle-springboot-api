package com.dimas.oracleapi.projetooraclexespringboot.service;

import com.dimas.oracleapi.projetooraclexespringboot.entity.Product;
import com.dimas.oracleapi.projetooraclexespringboot.entity.User;
import com.dimas.oracleapi.projetooraclexespringboot.repository.ProductRepository;
import com.dimas.oracleapi.projetooraclexespringboot.repository.UserRepository;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import java.util.Date;
import java.util.List;

@Service
public class ProductService {

    private ProductRepository productRepository;
    private UserRepository userRepository;

    public ProductService(ProductRepository productRepository, UserRepository userRepository) {
        this.productRepository = productRepository;
        this.userRepository = userRepository;
    }


    public List<Product> listarAllProducts() {
        return productRepository.findAll();
    }


    public Product buscarProdutoID(Long id) {
        return productRepository.findById(id).orElse(null);
    }


    public Product salvarProdutoID(Product product, Long userID) {

        User user = userRepository.findById(userID).orElse(null);

        if (user == null) {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, "usuário não encontrado");
        }

        product.setDataCadastro(new Date());
        product.setUser(user);

        return productRepository.save(product);
    }

    public void deletarProduto(Long id) {
        productRepository.deleteById(id);
    }

    public Product atualizarProduto(Product product) {

        return productRepository.save(product);
    }
}
