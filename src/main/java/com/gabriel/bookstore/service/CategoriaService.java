package com.gabriel.bookstore.service;

import java.util.List;
import java.util.Optional;

import com.gabriel.bookstore.domain.Categoria;
import com.gabriel.bookstore.dtos.CategoriaDTO;
import com.gabriel.bookstore.exceptions.ObjectNotFoundException;
import com.gabriel.bookstore.repositories.CategoriaRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CategoriaService {
    
    @Autowired
    private CategoriaRepository repository;

    public Categoria findById(Integer id){
        Optional<Categoria> obj = repository.findById(id);
        return obj.orElseThrow(() -> new ObjectNotFoundException("Objeto não encontrado! id: " + id + ", Tipo: " + Categoria.class.getName()));
    }

    public List<Categoria> findAll(){
        return repository.findAll();
    }

    public Categoria create(Categoria obj){
        obj.setId(null);
        return repository.save(obj);
    }

	public Categoria update(Integer id, CategoriaDTO objDto) {
		Categoria obj = findById(id);
        obj.setNome(objDto.getNome());
        obj.setDescricao(objDto.getDescricao());
        return repository.save(obj);
	}

	public void delete(Integer id) {
        findById(id);
        repository.deleteById(id);
	}
}
