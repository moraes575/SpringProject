package com.moraes.springProject.resources;

import com.moraes.springProject.entidades.Produto;
import com.moraes.springProject.services.ProdutoService;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(value = "/produtos")
public class ProdutoResource {

    @Autowired
    private ProdutoService service;

    @GetMapping
    public ResponseEntity<List<Produto>> selectAll() {
        List<Produto> lista = service.selectAll();
        return ResponseEntity.ok().body(lista);
    }

    @GetMapping(value = "/{id}")
    public ResponseEntity<Produto> selectById(@PathVariable Long id) {
        Produto obj = service.selectById(id);
        return ResponseEntity.ok().body(obj);
    }
}
