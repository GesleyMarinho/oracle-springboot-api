package com.dimas.oracleapi.projetooraclexespringboot.service;

import com.dimas.oracleapi.projetooraclexespringboot.entity.User;
import com.dimas.oracleapi.projetooraclexespringboot.repository.UserRepository;
import org.springframework.stereotype.Service;

import java.util.List;


@Service
public class UserService {


    private final UserRepository userRepository;

    public UserService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }


    public User saveUser(User user) {
        return userRepository.save(user);
    }

    public List<User> findAll() {

        return userRepository.findAll();
    }

    public User findById(Long id) {
        return userRepository.findById(id).orElse(null);
    }

    public void deleteByID(Long id) {

        userRepository.deleteById(id);
    }

    public User updateUser(User user) {

        return userRepository.save(user);
    }
}
