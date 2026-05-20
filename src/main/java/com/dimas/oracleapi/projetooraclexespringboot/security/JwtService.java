package com.dimas.oracleapi.projetooraclexespringboot.security;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.stereotype.Service;

@Service
public class JwtService {

    @Autowired
    private JwtUtil jwtUtil;

    @Autowired
    private UserDetailsService userDetailsService;

    public String authenticate(String username, String password) {
        // Verificar credenciais no banco
        UserDetails user = userDetailsService.loadUserByUsername(username);

        if (password.equals(user.getPassword())) { // Use encoder na prática
            return jwtUtil.generateToken(username);
        }
        throw new RuntimeException("Credenciais inválidas");
    }

    public UserDetails getUserFromToken(String token) {
        String username = jwtUtil.extractUsername(token);
        return userDetailsService.loadUserByUsername(username);
    }
}