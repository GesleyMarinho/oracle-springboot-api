package com.dimas.oracleapi.projetooraclexespringboot.repository;

import com.dimas.oracleapi.projetooraclexespringboot.entity.RegistroPonto;
import com.dimas.oracleapi.projetooraclexespringboot.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface ResgitroPontoRepository extends JpaRepository<RegistroPonto, Long> {

    @Query("""
            select r
            from RegistroPonto r
            """)
    RegistroPonto buscarRegistroHoje();

    /*@Query("""
            SELECT COUNT(r)
            FROM RegistroPonto r
            WHERE r.user.id = :userId
            """)
    long contarRegistroHoje(Long userId);*/

    List<RegistroPonto> findByUser(User user);

    @Query(value = """
            SELECT COUNT(*) FROM tb_registro_ponto 
            WHERE user_id = :userId 
            AND TRUNC(data_hora) = TRUNC(SYSDATE)
            """, nativeQuery = true)
    long contarRegistroHoje(@Param("userId") Long userId);

}
