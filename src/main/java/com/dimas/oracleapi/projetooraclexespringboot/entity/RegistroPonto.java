package com.dimas.oracleapi.projetooraclexespringboot.entity;

import com.dimas.oracleapi.projetooraclexespringboot.ENUM.StatusRegistroPonto;
import jakarta.persistence.*;

import java.time.LocalDateTime;

@Entity
@Table(name = "TB_REGISTRO_PONTO")
public class RegistroPonto {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    //private LocalDateTime dataHora;

    private LocalDateTime entrada;

    private LocalDateTime saidaAlmoco;

    private LocalDateTime voltaAlmoco;

    private LocalDateTime saida;

    @Enumerated(EnumType.STRING)
    private StatusRegistroPonto tipoRegistro;

    public RegistroPonto() {
    }

    /*public RegistroPonto(Long id, LocalDateTime dataHora, StatusRegistroPonto tipoRegistro) {
        this.id = id;
        this.dataHora = dataHora;
        this.tipoRegistro = tipoRegistro;
    }*/

    public RegistroPonto(Long id, LocalDateTime entrada, LocalDateTime saidaAlmoco, LocalDateTime voltaAlmoco, LocalDateTime saida, StatusRegistroPonto tipoRegistro) {
        this.id = id;
        this.entrada = entrada;
        this.saidaAlmoco = saidaAlmoco;
        this.voltaAlmoco = voltaAlmoco;
        this.saida = saida;
        this.tipoRegistro = tipoRegistro;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    /*public LocalDateTime getDataHora() {
        return dataHora;
    }

    public void setDataHora(LocalDateTime dataHora) {
        this.dataHora = dataHora;
    }*/

    public LocalDateTime getEntrada() {
        return entrada;
    }

    public void setEntrada(LocalDateTime entrada) {
        this.entrada = entrada;
    }

    public LocalDateTime getSaidaAlmoco() {
        return saidaAlmoco;
    }

    public void setSaidaAlmoco(LocalDateTime saidaAlmoco) {
        this.saidaAlmoco = saidaAlmoco;
    }

    public LocalDateTime getVoltaAlmoco() {
        return voltaAlmoco;
    }

    public void setVoltaAlmoco(LocalDateTime voltaAlmoco) {
        this.voltaAlmoco = voltaAlmoco;
    }

    public LocalDateTime getSaida() {
        return saida;
    }

    public void setSaida(LocalDateTime saida) {
        this.saida = saida;
    }

    public StatusRegistroPonto getTipoRegistro() {
        return tipoRegistro;
    }

    public void setTipoRegistro(StatusRegistroPonto tipoRegistro) {
        this.tipoRegistro = tipoRegistro;
    }
}