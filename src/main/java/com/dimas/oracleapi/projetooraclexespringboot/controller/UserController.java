package com.dimas.oracleapi.projetooraclexespringboot.controller;

import com.dimas.oracleapi.projetooraclexespringboot.entity.User;
import com.dimas.oracleapi.projetooraclexespringboot.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(value = "/users")
public class UserController {


    private UserService userService;

    public UserController(UserService userService) {
        this.userService = userService;
    }

    @PostMapping
    public ResponseEntity<User> createUser(@RequestBody User user) {

        User objUser = userService.saveUser(user);
        return ResponseEntity.status(201).body(objUser);
    }

    @GetMapping
    public ResponseEntity<List<User>> getAllUser() {
        List<User> users = userService.findAll();
        return ResponseEntity.ok(users);
    }

    @GetMapping("/{id}")
    public ResponseEntity<User> getFinfbyID(@PathVariable Long id) {
        User user = userService.findById(id);
        if (user == null) {
            return ResponseEntity.notFound().build();
        }

        return ResponseEntity.ok(user);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<User> deleteUser(@PathVariable Long id) {
        User user = userService.findById(id);

        if (user == null) {
            return ResponseEntity.notFound().build();
        }

        userService.deleteByID(id);

        return ResponseEntity.noContent().build();
    }

    @PutMapping("/{id}")
    public ResponseEntity<User> updateUser(@PathVariable Long id, @RequestBody User user) {

        User objUser = userService.findById(id);
        if (objUser == null) {
            return ResponseEntity.notFound().build();
        }
        objUser.setNome(user.getNome());
        objUser.setIdade(user.getIdade());
        User objUpdatedUser = userService.saveUser(objUser);
        return ResponseEntity.ok(objUpdatedUser);

    }

}
