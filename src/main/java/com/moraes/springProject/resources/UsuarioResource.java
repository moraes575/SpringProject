package com.moraes.springProject.resources;

import com.moraes.springProject.entidades.Usuario;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(value = "/usuarios")
public class UsuarioResource {

    @GetMapping
    public ResponseEntity<Usuario> selectAll() {
        Usuario u = new Usuario(1L, "Maria", "maria@gmail.com", "94898-8574", "12345");
        return ResponseEntity.ok().body(u);
    }

}
