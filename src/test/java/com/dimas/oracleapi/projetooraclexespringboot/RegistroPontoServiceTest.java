package com.dimas.oracleapi.projetooraclexespringboot;


import com.dimas.oracleapi.projetooraclexespringboot.ENUM.StatusRegistroPonto;
import com.dimas.oracleapi.projetooraclexespringboot.entity.RegistroPonto;
import com.dimas.oracleapi.projetooraclexespringboot.entity.User;
import com.dimas.oracleapi.projetooraclexespringboot.repository.ResgitroPontoRepository;
import com.dimas.oracleapi.projetooraclexespringboot.repository.UserRepository;
import com.dimas.oracleapi.projetooraclexespringboot.service.RegistroPontoService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
public class RegistroPontoServiceTest {

    @Mock
    private ResgitroPontoRepository registroPontoRepository;

    @Mock
    private UserRepository userRepository;

    @InjectMocks
    private RegistroPontoService registroPontoService;

    private User user;

    @BeforeEach
    void setup() {

        user = new User();
        user.setId(1L);
        user.setNome("Dimas");
        user.setEmail("dimas@gmail.com");
    }

    @Test
    void deveLancarErroQuandoUsuarioNaoExistir() {

        when(userRepository.findById(1L))
                .thenReturn(Optional.empty());

        RuntimeException exception = assertThrows(
                RuntimeException.class,
                () -> registroPontoService.save(1L)
        );

        assertEquals(
                "Usuário não encontrado",
                exception.getMessage()
        );
    }

    @Test
    void deveSalvarEntradaQuandoPrimeiraBatida() {

        when(userRepository.findById(1L))
                .thenReturn(Optional.of(user));

        when(registroPontoRepository.contarRegistroHoje(1L))
                .thenReturn(0L);

        RegistroPonto registroMock = new RegistroPonto();
        registroMock.setUser(user);
        registroMock.setTipoRegistro(StatusRegistroPonto.ENTRADA);

        when(registroPontoRepository.save(any(RegistroPonto.class)))
                .thenReturn(registroMock);

        RegistroPonto response = registroPontoService.save(1L);

        assertEquals(
                StatusRegistroPonto.ENTRADA,
                response.getTipoRegistro()
        );
    }

    @Test
    void deveSalvarAlmocoQuandoSegundaBatida() {

        when(userRepository.findById(1L))
                .thenReturn(Optional.of(user));

        when(registroPontoRepository.contarRegistroHoje(1L))
                .thenReturn(1L);

        RegistroPonto registroMock = new RegistroPonto();
        registroMock.setTipoRegistro(StatusRegistroPonto.ALMOCO);

        when(registroPontoRepository.save(any(RegistroPonto.class)))
                .thenReturn(registroMock);

        RegistroPonto response = registroPontoService.save(1L);

        assertEquals(
                StatusRegistroPonto.ALMOCO,
                response.getTipoRegistro()
        );
    }

    @Test
    void deveSalvarVoltaAlmocoQuandoTerceiraBatida() {

        when(userRepository.findById(1L))
                .thenReturn(Optional.of(user));

        when(registroPontoRepository.contarRegistroHoje(1L))
                .thenReturn(2L);

        RegistroPonto registroMock = new RegistroPonto();
        registroMock.setTipoRegistro(StatusRegistroPonto.VOLTA_ALMOCO);

        when(registroPontoRepository.save(any(RegistroPonto.class)))
                .thenReturn(registroMock);

        RegistroPonto response = registroPontoService.save(1L);

        assertEquals(
                StatusRegistroPonto.VOLTA_ALMOCO,
                response.getTipoRegistro()
        );
    }

    @Test
    void deveSalvarSaidaQuandoQuartaBatida() {

        when(userRepository.findById(1L))
                .thenReturn(Optional.of(user));

        when(registroPontoRepository.contarRegistroHoje(1L))
                .thenReturn(3L);

        RegistroPonto registroMock = new RegistroPonto();
        registroMock.setTipoRegistro(StatusRegistroPonto.SAIDA);

        when(registroPontoRepository.save(any(RegistroPonto.class)))
                .thenReturn(registroMock);

        RegistroPonto response = registroPontoService.save(1L);

        assertEquals(
                StatusRegistroPonto.SAIDA,
                response.getTipoRegistro()
        );
    }

    @Test
    void deveListarRegistrosPorUsuario() {

        when(userRepository.findById(1L))
                .thenReturn(Optional.of(user));

        RegistroPonto registro = new RegistroPonto();
        registro.setUser(user);
        registro.setTipoRegistro(StatusRegistroPonto.ENTRADA);

        List<RegistroPonto> registros = new ArrayList<>();
        registros.add(registro);

        when(registroPontoRepository.findByUser(user))
                .thenReturn(registros);

        var response = registroPontoService.findById(1L);

        assertFalse(response.isEmpty());

        assertEquals(
                "Dimas",
                response.get(0).getNomeUsuario()
        );
    }
}
