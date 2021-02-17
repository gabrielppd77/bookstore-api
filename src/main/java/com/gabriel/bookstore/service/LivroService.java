package com.gabriel.bookstore.service;

import java.util.Optional;

import com.gabriel.bookstore.domain.Livro;
import com.gabriel.bookstore.repositories.LivroRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.gabriel.bookstore.exceptions.ObjectNotFoundException;

@Service
public class LivroService {
    
    @Autowired
    private LivroRepository repository; 

    public Livro findById(Integer id){
        Optional<Livro> obj = repository.findById(id);
        return obj.orElseThrow(() -> new ObjectNotFoundException("Objeto não encontrado! id: " + id + ", Tipo: " + Livro.class.getName()));
    }
}
