package com.dimas.oracleapi.projetooraclexespringboot.repository;

import com.dimas.oracleapi.projetooraclexespringboot.entity.RegistroPonto;
import com.dimas.oracleapi.projetooraclexespringboot.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

public interface ResgitroPontoRepository extends JpaRepository<RegistroPonto, Long> {

    @Query("""
            select r
            from RegistroPonto r
            """)
    RegistroPonto buscarRegistroHoje();

    @Query("""
       SELECT COUNT(r)
       FROM RegistroPonto r
       WHERE r.user.id = :userId
       """)
    long contarRegistroHoje(Long userId);
}
