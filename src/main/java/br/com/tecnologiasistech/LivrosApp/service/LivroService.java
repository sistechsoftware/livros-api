package br.com.tecnologiasistech.LivrosApp.service;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.tecnologiasistech.LivrosApp.domain.Livro;
import br.com.tecnologiasistech.LivrosApp.repositories.LivroRepository;
import br.com.tecnologiasistech.LivrosApp.service.exceptions.ObjectNotFoundException;

@Service
public class LivroService {

	@Autowired
	private LivroRepository livroRepository;

	public Livro findById(Integer id) {
		Optional<Livro> obj = livroRepository.findById(id);
		
		return obj.orElseThrow(() -> new ObjectNotFoundException("Objeto não encontrado! Id: " + id + ", Tipo: " + Livro.class.getName()));
	}
}
