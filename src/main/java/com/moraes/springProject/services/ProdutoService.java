package com.moraes.springProject.services;

import com.moraes.springProject.entidades.Produto;
import com.moraes.springProject.repositories.ProdutoRepository;
import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ProdutoService {

    @Autowired
    private ProdutoRepository repository;

    public List<Produto> selectAll() {
        return repository.findAll();
    }

    public Produto selectById(Long id) {
        Optional<Produto> obj = repository.findById(id);
        return obj.get();
    }

}
