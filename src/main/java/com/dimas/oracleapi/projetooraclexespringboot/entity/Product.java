package com.dimas.oracleapi.projetooraclexespringboot.entity;

import jakarta.persistence.*;

import java.io.Serializable;
import java.util.Date;

@Entity
public class Product implements Serializable {
    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String nomeProduto;
    private Double preco;
    private Date dataCadastro;

    @ManyToOne
    @JoinColumn(name = "user_id")
    private User user;


    public Product() {
    }

    public Product(Long id, String nomeProduto, Double preco, Date DataCadastro) {
        this.id = id;
        this.nomeProduto = nomeProduto;
        this.preco = preco;
        this.dataCadastro = DataCadastro;
    }



    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getNomeProduto() {
        return nomeProduto;
    }

    public void setNomeProduto(String nomeProduto) {
        this.nomeProduto = nomeProduto;
    }

    public Double getPreco() {
        return preco;
    }

    public void setPreco(Double preco) {
        this.preco = preco;
    }

    public Date getDataCadastro() {
        return dataCadastro;
    }

    public void setDataCadastro(Date DataCadastro) {
        this.dataCadastro = DataCadastro;
    }
}
