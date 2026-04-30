package com.dimas.oracleapi.projetooraclexespringboot.controller;

import com.dimas.oracleapi.projetooraclexespringboot.dto.userDTO.ProductDTO;
import com.dimas.oracleapi.projetooraclexespringboot.entity.Product;
import com.dimas.oracleapi.projetooraclexespringboot.repository.ProductRepository;
import com.dimas.oracleapi.projetooraclexespringboot.service.ProductService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;


@RestController
@RequestMapping(value = "/products")
public class ProductController {

    private ProductService productService;

    public ProductController(ProductService productService) {
        this.productService = productService;
    }


    @GetMapping
    public ResponseEntity<List<ProductDTO>> getAllProducts() {
        List<Product> productList = productService.listarAllProducts();

        List<ProductDTO> productDTOList = new ArrayList<>();

        for (Product product : productList) {
            ProductDTO productDTO = new ProductDTO();
            productDTO.setNomeProduto(product.getNomeProduto());
            productDTO.setPreco(product.getPreco());
            productDTO.setDataCadastro(product.getDataCadastro());

            productDTOList.add(productDTO);
        }

        return ResponseEntity.ok(productDTOList);

    }


    @GetMapping("/{id}")
    public ResponseEntity<ProductDTO> buscarPorId(@PathVariable Long id) {
        Product product = productService.buscarProdutoID(id);

        if (product == null) {
            return ResponseEntity.notFound().build();
        }
        ProductDTO objProductDTO = new ProductDTO();

        objProductDTO.setNomeProduto(product.getNomeProduto());
        objProductDTO.setPreco(product.getPreco());
        objProductDTO.setDataCadastro(product.getDataCadastro());
        return ResponseEntity.ok(objProductDTO);
    }


    @PostMapping
    public ResponseEntity<ProductDTO> salvar(@RequestBody ProductDTO objProductDTO) {
        Product product = new Product();
        product.setNomeProduto(objProductDTO.getNomeProduto());
        product.setPreco(objProductDTO.getPreco());
        product.setDataCadastro(objProductDTO.getDataCadastro());

        Product objProduct = productService.salvarProduto(product);

        ProductDTO productDTO = new ProductDTO();

        productDTO.setNomeProduto(objProduct.getNomeProduto());
        productDTO.setPreco(objProduct.getPreco());
        //productDTO.setDataCadastro(objProduct.getDataCadastro());

        return ResponseEntity.status(201).body(productDTO);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Product> deletarPorId(@PathVariable Long id) {
        Product product = productService.buscarProdutoID(id);
        if (product == null) {
            return ResponseEntity.notFound().build();
        }

        productService.deletarProduto(id);

        return  ResponseEntity.noContent().build();
    }

    @PutMapping("/{id}")
    public ResponseEntity<ProductDTO> atualizar(@RequestBody ProductDTO objProductDTO,@PathVariable Long id) {
        Product product = productService.buscarProdutoID(id);

        if (product == null) {
            return ResponseEntity.notFound().build();
        }

        product.setNomeProduto(objProductDTO.getNomeProduto());
        product.setPreco(objProductDTO.getPreco());


        Product objProduct = productService.atualizarProduto(product);

        ProductDTO productDTO = new ProductDTO();

        productDTO.setNomeProduto(objProduct.getNomeProduto());
        productDTO.setPreco(objProduct.getPreco());
        productDTO.setDataCadastro(objProduct.getDataCadastro());

        return ResponseEntity.ok(productDTO);

    }
}
