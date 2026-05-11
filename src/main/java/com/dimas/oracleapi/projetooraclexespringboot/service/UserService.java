package com.dimas.oracleapi.projetooraclexespringboot.service;

import com.dimas.oracleapi.projetooraclexespringboot.entity.User;
import com.dimas.oracleapi.projetooraclexespringboot.repository.UserRepository;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;


@Service
public class UserService {


    private final UserRepository userRepository;

    public UserService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }


    public User saveUser(User user) {
        if (userRepository
                .buscarPorEmail(user.getEmail())
                .isPresent()) {

            throw new RuntimeException(
                    "Email já cadastrado"
            );
        }

        return userRepository.save(user);
    }

    public List<User> findAll() {

        return userRepository.findAll();
    }

    public User findById(Long id) {
        return userRepository.findById(id).orElse(null);
    }

    public User findByEmail(String email) {
        return userRepository.buscarPorEmail(email).orElse(null);
    }

    public void deleteByID(Long id) {

        userRepository.deleteById(id);
    }

    public User updateUser(User user) {

        return userRepository.save(user);
    }
}
