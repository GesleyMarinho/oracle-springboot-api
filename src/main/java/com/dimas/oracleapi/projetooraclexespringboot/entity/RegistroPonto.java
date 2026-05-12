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

    @ManyToOne
    @JoinColumn(name = "user_id")
    private User user;

    private LocalDateTime dataHora;

    @Enumerated(EnumType.STRING)
    private StatusRegistroPonto tipoRegistro;

    public RegistroPonto() {
    }

    public RegistroPonto(Long id, LocalDateTime dataHora, User user, StatusRegistroPonto tipoRegistro) {
        this.id = id;
        this.dataHora = dataHora;
        this.user = user;
        this.tipoRegistro = tipoRegistro;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public LocalDateTime getDataHora() {
        return dataHora;
    }

    public void setDataHora(LocalDateTime dataHora) {
        this.dataHora = dataHora;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public StatusRegistroPonto getTipoRegistro() {
        return tipoRegistro;
    }

    public void setTipoRegistro(StatusRegistroPonto tipoRegistro) {
        this.tipoRegistro = tipoRegistro;
    }
}