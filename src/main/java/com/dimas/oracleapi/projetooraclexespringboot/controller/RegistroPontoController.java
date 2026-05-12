package com.dimas.oracleapi.projetooraclexespringboot.controller;


import com.dimas.oracleapi.projetooraclexespringboot.dto.RegistroPontoDTO.RegistroPontoDTO;
import com.dimas.oracleapi.projetooraclexespringboot.entity.RegistroPonto;
import com.dimas.oracleapi.projetooraclexespringboot.service.RegistroPontoService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.time.LocalDateTime;

@RestController
@RequestMapping(value = "/registroPonto")
public class RegistroPontoController {

    private RegistroPontoService registroPontoService;

    public RegistroPontoController(RegistroPontoService registroPontoService) {
        this.registroPontoService = registroPontoService;
    }

    @PostMapping
    public ResponseEntity<RegistroPontoDTO>
    insertRegistroPonto() {

        RegistroPonto registroPonto =
                registroPontoService.save();

        RegistroPontoDTO dto =
                new RegistroPontoDTO();

        dto.setEntrada(
                registroPonto.getEntrada());

        dto.setSaidaAlmoco(
                registroPonto.getSaidaAlmoco());

        dto.setVoltaAlmoco(
                registroPonto.getVoltaAlmoco());

        dto.setSaida(
                registroPonto.getSaida());

        return new ResponseEntity<>(
                dto,
                HttpStatus.CREATED);
    }

    /*@PostMapping
    public ResponseEntity<RegistroPontoDTO> insertRegistroPonto(@RequestBody RegistroPontoDTO registroPontoDTO) {
        RegistroPonto registroPonto = new RegistroPonto();

        registroPonto.setEntrada(registroPontoDTO.getEntrada());
        registroPonto.setSaidaAlmoco(registroPontoDTO.getSaidaAlmoco());
        registroPonto.setVoltaAlmoco(registroPontoDTO.getVoltaAlmoco());
        registroPonto.setSaida(registroPontoDTO.getSaida());
        registroPonto.setTipoRegistro(registroPonto.getTipoRegistro());


        registroPontoService.save(registroPonto);

        RegistroPontoDTO objResgitroPonto = new RegistroPontoDTO();
        objResgitroPonto.setEntrada(registroPonto.getEntrada());
        objResgitroPonto.setSaida(registroPonto.getSaida());
        objResgitroPonto.setVoltaAlmoco(registroPonto.getVoltaAlmoco());
        objResgitroPonto.setSaida(registroPonto.getSaida());

        objResgitroPonto.setStatusRegistroPonto(registroPonto.getTipoRegistro());


        return new ResponseEntity<>(objResgitroPonto, HttpStatus.CREATED);
    }*/
}
