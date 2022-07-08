package br.com.tecnologiasistech.LivrosApp.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import br.com.tecnologiasistech.LivrosApp.domain.Livro;

public interface LivroRepository extends JpaRepository<Livro, Integer> {

}
