package com.gabriel.bookstore.service;

import java.util.Arrays;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.gabriel.bookstore.domain.Categoria;
import com.gabriel.bookstore.domain.Livro;
import com.gabriel.bookstore.repositories.CategoriaRepository;
import com.gabriel.bookstore.repositories.LivroRepository;

@Service
public class DBService {

	@Autowired
	private CategoriaRepository categoriaRepository;
	@Autowired
	private LivroRepository livroRepository;
	
	public void instanciaBaseDeDados() {
		
		Categoria cat1 = new Categoria(null, "Culinaria", "Varias comidinhas");
		Categoria cat2 = new Categoria(null, "Ciencias", "Varias ciencinhas");
		Categoria cat3 = new Categoria(null, "Matematica", "Varias matematiquinhas");
		Categoria cat4 = new Categoria(null, "Informatica", "Livro de T.I");
		
		Livro l1 = new Livro(null, "Clean code", "Robert Martin", "Lorem ipsum", cat4);
		Livro l2 = new Livro(null, "Como fazer Pizza", "Maria Braga", "Lorem ipsum", cat1);
		Livro l3 = new Livro(null, "Matematica Para Crianças", "Autor desconhecido", "Lorem ipsum", cat3);
		Livro l4 = new Livro(null, "Discovery Channel", "SKY", "Lorem ipsum", cat2);
		
		cat1.getLivros().addAll(Arrays.asList(l2));
		cat2.getLivros().addAll(Arrays.asList(l4));
		cat3.getLivros().addAll(Arrays.asList(l3));
		cat4.getLivros().addAll(Arrays.asList(l1));
		
		this.categoriaRepository.saveAll(Arrays.asList(cat1,cat2,cat3,cat4));
		this.livroRepository.saveAll(Arrays.asList(l1,l2,l3,l4));
	}
}
