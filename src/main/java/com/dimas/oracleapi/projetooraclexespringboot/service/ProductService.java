package com.dimas.oracleapi.projetooraclexespringboot.service;

import com.dimas.oracleapi.projetooraclexespringboot.entity.Product;
import com.dimas.oracleapi.projetooraclexespringboot.repository.ProductRepository;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;

@Service
public class ProductService {

    private ProductRepository productRepository;

    public ProductService(ProductRepository productRepository) {
        this.productRepository = productRepository;
    }



    public List<Product> listarAllProducts() {
        return productRepository.findAll();
    }


    public Product buscarProdutoID( Long id) {
        return productRepository.findById(id).orElse(null);
    }


    public Product salvarProduto( Product product) {
        product.setDataCadastro(new Date());
        return productRepository.save(product);
    }

    public void deletarProduto( Long id) {
        productRepository.deleteById(id);
    }

    public Product atualizarProduto( Product product) {

        return productRepository.save(product);
    }
}
