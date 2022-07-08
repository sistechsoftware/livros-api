package br.com.tecnologiasistech.LivrosApp.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;

import br.com.tecnologiasistech.LivrosApp.service.DBServices;

@Configuration
@Profile("test")
public class TestConfig {

	@Autowired
	private DBServices dbService;
	
	@Bean
	public void instanciaBaseDeDados() {
		this.dbService.instanciaBaseDados();
	}
	
}
