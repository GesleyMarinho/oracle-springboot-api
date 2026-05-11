package com.dimas.oracleapi.projetooraclexespringboot.controller;

import com.dimas.oracleapi.projetooraclexespringboot.dto.userDTO.UserAuthDTO;
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
    public ResponseEntity<?> createUser(@RequestBody UserDTO userDTO) {

        try {
            User user = new User();
            user.setIdade(userDTO.getIdade());
            user.setNome(userDTO.getNome());
            user.setEmail(userDTO.getEmail());
            user.setSenha(userDTO.getSenha());
            user.setConfirmSenha(userDTO.getConfirmaSenha());
            User objUser = userService.saveUser(user);

            UserDTO objUserDTO = new UserDTO();
            objUserDTO.setNome(objUser.getNome());
            objUserDTO.setIdade(objUser.getIdade());
            objUserDTO.setEmail(objUser.getEmail());
            objUserDTO.setSenha(objUser.getSenha());
            objUserDTO.setConfirmaSenha(objUser.getConfirmSenha());

            return ResponseEntity.status(201).body(objUserDTO);
        } catch (Exception e) {
            return ResponseEntity
                    .badRequest()
                    .body(e.getMessage());
        }
    }

    @GetMapping
    public ResponseEntity<List<UserDTO>> getAllUser() {
        List<User> users = userService.findAll();
        List<UserDTO> userDTOs = new ArrayList<>();

        users.forEach(user -> {
            UserDTO objUserDTO = new UserDTO();
            objUserDTO.setNome(user.getNome());
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
        objUserDTO.setNome(user.getNome());
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

        objUser.setNome(userDTO.getNome());
        objUser.setIdade(userDTO.getIdade());
        objUser.setEmail(userDTO.getEmail());
        objUser.setSenha(userDTO.getSenha());
        objUser.setConfirmSenha(userDTO.getConfirmaSenha());
        User userUpdated = userService.updateUser(objUser);

        UserDTO objUserDTO = new UserDTO();
        objUserDTO.setNome(userUpdated.getNome());
        objUserDTO.setIdade(userUpdated.getIdade());
        objUserDTO.setEmail(userUpdated.getEmail());
        objUserDTO.setSenha(userUpdated.getSenha());
        objUserDTO.setConfirmaSenha(userUpdated.getConfirmSenha());


        return ResponseEntity.ok(objUserDTO);

    }

    @PostMapping("/login")
    public ResponseEntity<?> authenticateUser(@RequestBody UserAuthDTO dto) {
        User user = userService.findByEmail(dto.getEmail());
        System.out.println(dto.getEmail() + "|");
        if (user == null) {
            return ResponseEntity.notFound().build();
        }

        if (user.getSenha().equals(dto.getSenha())) {
            return ResponseEntity.ok("Login realizado com sucesso");
        }
        return ResponseEntity.status(401)
                .body("Usuário ou senha inválidos");
    }

}
