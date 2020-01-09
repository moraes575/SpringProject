package com.moraes.springProject.resources;

import com.moraes.springProject.entidades.Categoria;
import com.moraes.springProject.services.CategoriaService;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(value = "/categorias")
public class CategoriaResource {

    @Autowired
    private CategoriaService service;

    @GetMapping
    public ResponseEntity<List<Categoria>> selectAll() {
        List<Categoria> lista = service.selectAll();
        return ResponseEntity.ok().body(lista);
    }

    @GetMapping(value = "/{id}")
    public ResponseEntity<Categoria> selectById(@PathVariable Long id) {
        Categoria obj = service.selectById(id);
        return ResponseEntity.ok().body(obj);
    }
}
