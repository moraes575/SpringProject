package com.moraes.springProject.resources;

import com.moraes.springProject.entidades.Pedido;
import com.moraes.springProject.services.PedidoService;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(value = "/pedidos")
public class PedidoResource {

    @Autowired
    private PedidoService service;

    @GetMapping
    public ResponseEntity<List<Pedido>> selectAll() {
        List<Pedido> lista = service.selectAll();
        return ResponseEntity.ok().body(lista);
    }

    @GetMapping(value = "/{id}")
    public ResponseEntity<Pedido> selectById(@PathVariable Long id) {
        Pedido obj = service.selectById(id);
        return ResponseEntity.ok().body(obj);
    }
}
