package com.moraes.springProject.resources;

import com.moraes.springProject.entidades.Usuario;
import com.moraes.springProject.services.UsuarioService;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(value = "/usuarios")
public class UsuarioResource {

    @Autowired
    private UsuarioService service;

    @GetMapping
    public ResponseEntity<List<Usuario>> selectAll() {
        List<Usuario> lista = service.selectAll();
        return ResponseEntity.ok().body(lista);
    }

    @GetMapping(value = "/{id}")
    public ResponseEntity<Usuario> selectById(@PathVariable Long id) {
        Usuario obj = service.selectById(id);
        return ResponseEntity.ok().body(obj);
    }
}
