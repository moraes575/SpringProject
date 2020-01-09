package com.moraes.springProject.services;

import com.moraes.springProject.entidades.Usuario;
import com.moraes.springProject.repositories.UsuarioRepository;
import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UsuarioService {

    @Autowired
    private UsuarioRepository repository;

    public List<Usuario> selectAll() {
        return repository.findAll();
    }

    public Usuario selectById(Long id) {
        Optional<Usuario> obj = repository.findById(id);
        return obj.get();
    }

    public Usuario insert(Usuario obj) {
        return repository.save(obj);
    }

    public void delete(Long id) {
        repository.deleteById(id);
    }

}
