package br.com.tecnologiasistech.LivrosApp;

import java.util.Arrays;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import br.com.tecnologiasistech.LivrosApp.domain.Categoria;
import br.com.tecnologiasistech.LivrosApp.domain.Livro;
import br.com.tecnologiasistech.LivrosApp.repositories.CategoriaRepository;
import br.com.tecnologiasistech.LivrosApp.repositories.LivroRepository;

@SpringBootApplication
public class LivrosAppApplication implements CommandLineRunner {
	
	@Autowired
	private CategoriaRepository categoriaRepository;

	@Autowired
	private LivroRepository livroRepository;
	
	public static void main(String[] args) {
		SpringApplication.run(LivrosAppApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		
		try {
			Categoria cat1 = new Categoria(null, "Informática", "Livro sobre informática");	
			Livro l1 = new Livro(null, "Clean Code", "Robert Martin", "Lorem Ipsum", cat1);
			
			cat1.getLivros().addAll(Arrays.asList(l1));
			
			this.categoriaRepository.saveAll(Arrays.asList(cat1));
			this.livroRepository.saveAll(Arrays.asList(l1));
		} catch(Exception e) {
			String erro = "";
			erro = e.getMessage();
		}	
	}

}
