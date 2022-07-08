package br.com.tecnologiasistech.LivrosApp.resources;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.tecnologiasistech.LivrosApp.domain.Categoria;
import br.com.tecnologiasistech.LivrosApp.dtos.CategoriaDTO;
import br.com.tecnologiasistech.LivrosApp.service.CategoriaService;

@RestController
@RequestMapping(value = "/categorias")
public class CategoriaResource {
	
	@Autowired
	private CategoriaService categoriaService;
	
	@GetMapping(value = "/{id}")
	public ResponseEntity<Categoria> findById(@PathVariable Integer id) {
		Categoria obj = categoriaService.findById(id);
		
		return ResponseEntity.ok().body(obj);
		
	}
	
	@GetMapping
	public ResponseEntity<List<CategoriaDTO>> findAll() {
		
		List<Categoria> list = categoriaService.findAll()
;
		List<CategoriaDTO> listDTO = list.stream().map(obj -> new CategoriaDTO(obj)).collect(Collectors.toList());
		
		return ResponseEntity.ok().body(listDTO);
	}

}
