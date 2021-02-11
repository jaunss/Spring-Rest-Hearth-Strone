package com.joaogcm.spring.hearth.stone.resources;

import java.net.URI;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import com.joaogcm.spring.hearth.stone.entities.Carta;
import com.joaogcm.spring.hearth.stone.entities.enums.Tipo;
import com.joaogcm.spring.hearth.stone.services.CartaService;

@RestController
@RequestMapping(value = "/cartas")
public class CartaResource {

	@Autowired
	private CartaService cartaService;

	/* Consultar todas as cartas */
	@GetMapping
	public ResponseEntity<?> findAll() {
		List<Carta> obj = cartaService.findAll();
		return ResponseEntity.ok().body(obj);
	}

	/* Consultar carta por id */
	@GetMapping(value = "/{id}")
	public ResponseEntity<?> findById(@PathVariable Integer id) {
		Carta obj = cartaService.findById(id);
		return ResponseEntity.ok().body(obj);
	}

	@PostMapping
	public ResponseEntity<?> insert(@RequestBody Carta obj) {
		obj = cartaService.insert(obj);
		URI uri = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").buildAndExpand(obj.getId()).toUri();
		return ResponseEntity.created(uri).body(obj);
	}

	@DeleteMapping(value = "/{id}")
	public ResponseEntity<?> deleteById(@PathVariable Integer id) {
		findById(id);
		cartaService.deleteById(id);
		return ResponseEntity.noContent().build();
	}

	@PutMapping(value = "/{id}")
	public ResponseEntity<?> updateById(@PathVariable Integer id, @RequestBody Carta obj) {
		obj = cartaService.updateById(id, obj);
		return ResponseEntity.ok().body(obj);
	}

	@GetMapping(value = "/findByName")
	public ResponseEntity<?> findByName(@RequestParam("nome") String nome) {
		Carta obj = cartaService.findByName(nome);
		return ResponseEntity.ok().body(obj);
	}

	@GetMapping(value = "/findByTipo")
	public ResponseEntity<?> findByTipo(@RequestParam("tipo") Tipo tipo) {
		Carta obj = cartaService.findByTipo(tipo);
		return ResponseEntity.ok().body(obj);
	}
}