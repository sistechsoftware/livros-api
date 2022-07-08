package br.com.tecnologiasistech.LivrosApp.service;

import java.util.Arrays;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.tecnologiasistech.LivrosApp.domain.Categoria;
import br.com.tecnologiasistech.LivrosApp.domain.Livro;
import br.com.tecnologiasistech.LivrosApp.repositories.CategoriaRepository;
import br.com.tecnologiasistech.LivrosApp.repositories.LivroRepository;

@Service
public class DBServices {
	
	@Autowired
	private CategoriaRepository categoriaRepository;

	@Autowired
	private LivroRepository livroRepository;
	
	
	public void instanciaBaseDados() {
		try {
			Categoria cat1 = new Categoria(null, "Informática", "Livro sobre informática");	
			Categoria cat2 = new Categoria(null, "Ficção Científica", "Livro sobre ficções");	
			Categoria cat3 = new Categoria(null, "Biografias", "Livro sobre biografias");	
			Categoria cat4 = new Categoria(null, "Matemática", "Livros de matemática");	
		
			Livro l1 = new Livro(null, "Clean Code", "Robert Martin", "Lorem Ipsum", cat1);
			Livro l2 = new Livro(null, "Engenharia de Software", "Robert Martin", "Lorem Ipsum", cat1);
			Livro l3 = new Livro(null, "The Time Machine", "Robert Martin", "Lorem Ipsum", cat2);
			Livro l4 = new Livro(null, "The War of the Worlds", "Robert Martin", "Lorem Ipsum", cat3);
			Livro l5 = new Livro(null, "I, Robot", "Robert Martin", "Lorem Ipsum", cat1);
			Livro l6 = new Livro(null, "Quem pensa enriquece", "Robert Martin", "Lorem Ipsum", cat4);
			
			cat1.getLivros().addAll(Arrays.asList(l1));
			cat1.getLivros().addAll(Arrays.asList(l1));
			
			this.categoriaRepository.saveAll(Arrays.asList(cat1, cat2, cat3));
			this.livroRepository.saveAll(Arrays.asList(l1, l2, l3, l4, l5));
		} catch(Exception e) {
			String erro = "";
			erro = e.getMessage();
		}	
	}

}
