package com.joaogcm.spring.hearth.stone.services;

import java.util.List;
import java.util.Optional;

import javax.persistence.EntityNotFoundException;
import javax.validation.ConstraintViolationException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.stereotype.Service;

import com.joaogcm.spring.hearth.stone.entities.Carta;
import com.joaogcm.spring.hearth.stone.entities.enums.Tipo;
import com.joaogcm.spring.hearth.stone.repositories.CartaRepository;
import com.joaogcm.spring.hearth.stone.services.exceptions.ConstraintViolationExceptionAPI;
import com.joaogcm.spring.hearth.stone.services.exceptions.ObjectNotFoundException;

@Service
public class CartaService {

	@Autowired
	private CartaRepository cartaRepository;

	public List<Carta> findAll() {
		List<Carta> obj = cartaRepository.findAll();
		return obj;
	}

	public Carta findById(Integer id) {
		Optional<Carta> obj = cartaRepository.findById(id);
		return obj.orElseThrow(() -> new ObjectNotFoundException(id));
	}

	public Carta insert(Carta obj) {
		try {
			if (obj.getAtaque() > 10 || obj.getDefesa() > 10) {
				throw new ConstraintViolationExceptionAPI("Argumentos inválidos: Revise o Ataque e a Defesa.");
			}
			return cartaRepository.save(obj);
		} catch (ConstraintViolationException e) {
			throw new ConstraintViolationExceptionAPI(e.getMessage());
		}
	}

	public void deleteById(Integer id) {
		try {
			cartaRepository.deleteById(id);

		} catch (EmptyResultDataAccessException e) {
			throw new ObjectNotFoundException(id);
		}
	}

	public Carta updateById(Integer id, Carta obj) {

		try {
			Carta objC = cartaRepository.getOne(id);
			updateData(objC, obj);
			return cartaRepository.save(objC);

		} catch (EntityNotFoundException e) {
			throw new ObjectNotFoundException(e.getMessage());
		}
	}

	public Carta findByName(String nome) {
		if (nome != null && !nome.isEmpty()) {
			Carta obj = cartaRepository.findByName(nome);
			return obj;
		}
		return null;
	}

	public Carta findByTipo(Tipo tipo) {
		Carta obj = cartaRepository.findByTipo(tipo);
		return obj;
	}

	private void updateData(Carta objC, Carta obj) {
		objC.setNome(obj.getNome());
		objC.setDescricao(obj.getDescricao());
		objC.setAtaque(obj.getAtaque());
		objC.setDefesa(obj.getDefesa());
		objC.setTipo(obj.getTipo());
		objC.setClasse(obj.getClasse());
	}
}