package com.moraes.springProject.services;

import com.moraes.springProject.entidades.Categoria;
import com.moraes.springProject.repositories.CategoriaRepository;
import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CategoriaService {

    @Autowired
    private CategoriaRepository repository;

    public List<Categoria> selectAll() {
        return repository.findAll();
    }

    public Categoria selectById(Long id) {
        Optional<Categoria> obj = repository.findById(id);
        return obj.get();
    }

}
