package com.gabriel.bookstore.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.gabriel.bookstore.domain.Livro;

@Repository
public interface LivroRepository extends JpaRepository<Livro, Integer> {
}
