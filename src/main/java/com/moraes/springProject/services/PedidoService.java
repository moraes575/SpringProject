package com.moraes.springProject.services;

import com.moraes.springProject.entidades.Pedido;
import com.moraes.springProject.repositories.PedidoRepository;
import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class PedidoService {

    @Autowired
    private PedidoRepository repository;

    public List<Pedido> selectAll() {
        return repository.findAll();
    }

    public Pedido selectById(Long id) {
        Optional<Pedido> obj = repository.findById(id);
        return obj.get();
    }

}
