package com.dimas.oracleapi.projetooraclexespringboot.service;

import com.dimas.oracleapi.projetooraclexespringboot.ENUM.StatusRegistroPonto;
import com.dimas.oracleapi.projetooraclexespringboot.dto.RegistroPontoDTO.RegistroPontoDTO;
import com.dimas.oracleapi.projetooraclexespringboot.entity.RegistroPonto;
import com.dimas.oracleapi.projetooraclexespringboot.entity.User;
import com.dimas.oracleapi.projetooraclexespringboot.repository.ResgitroPontoRepository;
import com.dimas.oracleapi.projetooraclexespringboot.repository.UserRepository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDateTime;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class RegistroPontoService {

    private static final int LIMITE_REGISTROS_POR_DIA = 4;

    private final ResgitroPontoRepository resgitroPontoRepository;
    private final UserRepository userRepository;

    public RegistroPontoService(ResgitroPontoRepository resgitroPontoRepository,
                                UserRepository userRepository) {
        this.resgitroPontoRepository = resgitroPontoRepository;
        this.userRepository = userRepository;
    }

    @Transactional
    public RegistroPonto save(Long userId) {
        // 1. Buscar usuário
        User user = findUserById(userId);

        // 2. Validar limite de registros
        long quantidadeRegistrosHoje = resgitroPontoRepository.contarRegistroHoje(userId);

        if (quantidadeRegistrosHoje >= LIMITE_REGISTROS_POR_DIA) {
            throw new RuntimeException(
                    String.format("Limite de %d batidas do dia atingido", LIMITE_REGISTROS_POR_DIA)
            );
        }

        // 3. Determinar o status baseado na quantidade atual
        StatusRegistroPonto status = determineStatus(quantidadeRegistrosHoje);

        // 4. Criar e salvar o registro
        RegistroPonto registroPonto = buildRegistroPonto(user, status);

        return resgitroPontoRepository.save(registroPonto);
    }

    @Transactional(readOnly = true)
    public List<RegistroPontoDTO> findAll() {
        return resgitroPontoRepository.findAll()
                .stream()
                .map(this::convertToDTO)
                .collect(Collectors.toList());
    }

    @Transactional(readOnly = true)
    public List<RegistroPontoDTO> findById(Long userId) {
        // Verificar se usuário existe
        User user = findUserById(userId);

        return resgitroPontoRepository.findByUser(user)
                .stream()
                .map(this::convertToDTO)
                .collect(Collectors.toList());
    }

    // Métodos privados auxiliares

    private User findUserById(Long userId) {
        return userRepository.findById(userId)
                .orElseThrow(() -> new RuntimeException(
                        String.format("Usuário com ID %d não encontrado", userId)
                ));
    }

    private StatusRegistroPonto determineStatus(long quantidadeRegistros) {
        switch ((int) quantidadeRegistros) {
            case 0:
                return StatusRegistroPonto.ENTRADA;
            case 1:
                return StatusRegistroPonto.ALMOCO;
            case 2:
                return StatusRegistroPonto.VOLTA_ALMOCO;
            case 3:
                return StatusRegistroPonto.SAIDA;
            default:
                throw new RuntimeException(
                        String.format("Quantidade inválida de registros: %d", quantidadeRegistros)
                );
        }
    }

    private RegistroPonto buildRegistroPonto(User user, StatusRegistroPonto status) {
        RegistroPonto registroPonto = new RegistroPonto();
        registroPonto.setUser(user);
        registroPonto.setDataHora(LocalDateTime.now());
        registroPonto.setTipoRegistro(status);
        return registroPonto;
    }

    private RegistroPontoDTO convertToDTO(RegistroPonto registro) {
        RegistroPontoDTO dto = new RegistroPontoDTO();
        dto.setDataHora(registro.getDataHora());
        dto.setStatus(registro.getTipoRegistro());
        dto.setUserId(registro.getUser().getId());
        dto.setNomeUsuario(registro.getUser().getNome());
        return dto;
    }
}