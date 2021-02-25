package com.github.thirodrigues.agendaapi.model.api.rest;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.github.thirodrigues.agendaapi.mode.entity.Contato;
import com.github.thirodrigues.agendaapi.mode.repository.ContatoRepository;

@RestController
@RequestMapping("/api/contatos")
@CrossOrigin("*")
public class ContatoController {

	@Autowired
	private ContatoRepository contatoRepository;
	
	@PostMapping
	@ResponseStatus(HttpStatus.CREATED)
	public Contato save( @RequestBody Contato contato ) {
		return contatoRepository.save(contato);
	}
	
	@DeleteMapping("/{id}")
	@ResponseStatus(HttpStatus.NO_CONTENT)
	public void delete( @PathVariable Integer id ) {
		contatoRepository.deleteById(id);
	}
	
	@GetMapping
	public List<Contato> contatos() {
		return contatoRepository.findAll();
	}
	
	@PatchMapping("/{id}/favorito")
	public void favorite( @PathVariable Integer id, @RequestBody Boolean favorito ) {
		Optional<Contato> contatoId = contatoRepository.findById(id);
		contatoId.ifPresent( c -> {
			c.setFavorito(favorito);
			contatoRepository.save(c);
		});
	}
}