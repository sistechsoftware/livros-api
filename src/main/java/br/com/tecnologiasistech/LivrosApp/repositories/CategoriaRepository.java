package br.com.tecnologiasistech.LivrosApp.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import br.com.tecnologiasistech.LivrosApp.domain.Categoria;

public interface CategoriaRepository extends JpaRepository<Categoria, Integer> {

}
