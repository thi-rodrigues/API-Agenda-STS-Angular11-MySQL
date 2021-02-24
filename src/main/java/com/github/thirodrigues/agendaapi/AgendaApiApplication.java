package com.github.thirodrigues.agendaapi;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.github.thirodrigues.agendaapi.mode.entity.Contato;
import com.github.thirodrigues.agendaapi.mode.repository.ContatoRepository;

@SpringBootApplication
public class AgendaApiApplication implements CommandLineRunner{

	public static void main(String[] args){
		SpringApplication.run(AgendaApiApplication.class, args);
	}

	@Autowired
	private ContatoRepository contatoRepository;
	
	@Override
	public void run(String... args) throws Exception {
		Contato c = new Contato();
		c.setNome("João A.");
		c.setEmail("joao@gmail.com");
		c.setFavorito(false);
		
		contatoRepository.save(c);
	}
}
