package com.example.demo.controller;

import com.example.demo.dto.UserDTO;
import com.example.demo.service.impl.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

// extends ResourceBase<UsuarioDTO>
@RestController
@RequestMapping("/usuarios")
public class UserController extends ControllerBase<UserDTO> {

    @Autowired
    private UserService usuarioService;

    @GetMapping("/{login}")
    public ResponseEntity<UserDTO> consultar(@PathVariable String login) {
        UserDTO usuario = usuarioService.consultar(login);
        if (usuario == null) {
            return responderItemNaoEncontrado();
        }
        return responderSucessoComItem(usuario);
    }
}
