package br.com.tecnologiasistech.LivrosApp.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.tecnologiasistech.LivrosApp.domain.Categoria;
import br.com.tecnologiasistech.LivrosApp.dtos.CategoriaDTO;
import br.com.tecnologiasistech.LivrosApp.repositories.CategoriaRepository;
import br.com.tecnologiasistech.LivrosApp.service.exceptions.ObjectNotFoundException;

@Service
public class CategoriaService {

	@Autowired
	private CategoriaRepository categoriaRepository;

	public Categoria findById(Integer id) {
		Optional<Categoria> obj = categoriaRepository.findById(id);

		return obj.orElseThrow(() -> new ObjectNotFoundException(
				"Objeto não encontrado! ID: " + id + ", Tipo: " + Categoria.class.getName()));
	}

	public List<Categoria> findAll() {
		return categoriaRepository.findAll();
	}

	public Categoria create(Categoria obj) {
		obj.setId(null);
		
		return categoriaRepository.save(obj);
	}

	public Categoria update(Integer id, CategoriaDTO objDto) {
		Categoria obj = findById(id);
		obj.setNome(objDto.getNome());
		obj.setDescricao(objDto.getDescricao());
		return categoriaRepository.save(obj) ;
	}
	
	public void delete(Integer id) {
		
		findById(id);
		categoriaRepository.deleteById(id);
	}
}	
