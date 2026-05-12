package com.dimas.oracleapi.projetooraclexespringboot.service;

import com.dimas.oracleapi.projetooraclexespringboot.entity.RegistroPonto;
import com.dimas.oracleapi.projetooraclexespringboot.repository.ResgitroPontoRepository;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;

@Service
public class RegistroPontoService {

    private ResgitroPontoRepository resgitroPontoRepository;

    public RegistroPontoService(ResgitroPontoRepository resgitroPontoRepository) {
        this.resgitroPontoRepository = resgitroPontoRepository;
    }

    public RegistroPonto save() {

        RegistroPonto registroHoje = resgitroPontoRepository.buscarRegistroHoje();

        if (registroHoje == null) {
            registroHoje = new RegistroPonto();
            registroHoje.setEntrada(LocalDateTime.now());

        } else if (registroHoje.getSaidaAlmoco() == null) {
            registroHoje.setSaidaAlmoco(LocalDateTime.now());

        } else if (registroHoje.getVoltaAlmoco() == null) {

            registroHoje.setVoltaAlmoco( LocalDateTime.now());

        } else if (registroHoje.getSaida() == null) {

            registroHoje.setSaida(LocalDateTime.now());
        }

        return resgitroPontoRepository.save(registroHoje);
    }

}
