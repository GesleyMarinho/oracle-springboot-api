package com.dimas.oracleapi.projetooraclexespringboot.repository;

import com.dimas.oracleapi.projetooraclexespringboot.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.Optional;

public interface UserRepository extends JpaRepository<User,Long> {

    @Query("SELECT u FROM User u WHERE u.email = :email")
    Optional<User> buscarPorEmail(@Param("email") String email);

}
