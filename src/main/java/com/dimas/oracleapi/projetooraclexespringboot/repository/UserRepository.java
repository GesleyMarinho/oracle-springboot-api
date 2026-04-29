package com.dimas.oracleapi.projetooraclexespringboot.repository;

import com.dimas.oracleapi.projetooraclexespringboot.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User,Long> {
}
