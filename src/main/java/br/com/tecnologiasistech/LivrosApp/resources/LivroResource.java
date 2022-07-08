package br.com.tecnologiasistech.LivrosApp.resources;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import br.com.tecnologiasistech.LivrosApp.domain.Livro;
import br.com.tecnologiasistech.LivrosApp.service.LivroService;

@RestController
@RequestMapping(value = "/livros")
public class LivroResource {
	
	
	@Autowired
	private LivroService service;
	
	@GetMapping(value = "/{id}")
	public ResponseEntity<Livro> findById(@PathVariable Integer id) {
		Livro obj = service.findById(id);
		
		return ResponseEntity.ok().body(obj);
	}

}
