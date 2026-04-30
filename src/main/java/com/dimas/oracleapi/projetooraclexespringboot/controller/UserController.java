package com.dimas.oracleapi.projetooraclexespringboot.controller;

import com.dimas.oracleapi.projetooraclexespringboot.dto.userDTO.UserDTO;
import com.dimas.oracleapi.projetooraclexespringboot.entity.User;
import com.dimas.oracleapi.projetooraclexespringboot.service.UserService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping(value = "/users")
public class UserController {


    private UserService userService;

    public UserController(UserService userService) {
        this.userService = userService;
    }

    @PostMapping
    public ResponseEntity<UserDTO> createUser(@RequestBody UserDTO userDTO) {

        User user = new User();
        user.setIdade(userDTO.getIdade());
        user.setNome(userDTO.getnome());
        User objUser = userService.saveUser(user);

        UserDTO objUserDTO = new UserDTO();
        objUserDTO.setnome(objUser.getNome());
        objUserDTO.setIdade(objUser.getIdade());

        return ResponseEntity.status(201).body(objUserDTO);
    }

    @GetMapping
    public ResponseEntity<List<UserDTO>> getAllUser() {
        List<User> users = userService.findAll();
        List<UserDTO> userDTOs = new ArrayList<>();

        users.forEach(user -> {
            UserDTO objUserDTO = new UserDTO();
            objUserDTO.setnome(user.getNome());
            objUserDTO.setIdade(user.getIdade());

            userDTOs.add(objUserDTO);
        });
        return ResponseEntity.ok(userDTOs);
    }

    @GetMapping("/{id}")
    public ResponseEntity<UserDTO> getFinfbyID(@PathVariable Long id) {

        User user = userService.findById(id);
        if (user == null) {
            return ResponseEntity.notFound().build();
        }

        UserDTO objUserDTO = new UserDTO();
        objUserDTO.setnome(user.getNome());
        objUserDTO.setIdade(user.getIdade());


        return ResponseEntity.ok(objUserDTO);
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
    public ResponseEntity<UserDTO> updateUser(@PathVariable Long id, @RequestBody UserDTO userDTO) {

        User objUser = userService.findById(id);
        if (objUser == null) {
            return ResponseEntity.notFound().build();
        }

        objUser.setNome(userDTO.getnome());
        objUser.setIdade(userDTO.getIdade());
        User userUpdated = userService.updateUser(objUser);

        UserDTO objUserDTO = new UserDTO();
        objUserDTO.setnome(userUpdated.getNome());
        objUserDTO.setIdade(userUpdated.getIdade());


        return ResponseEntity.ok(objUserDTO);

    }

}
