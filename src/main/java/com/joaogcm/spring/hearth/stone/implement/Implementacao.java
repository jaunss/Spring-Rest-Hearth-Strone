package com.joaogcm.spring.hearth.stone.implement;

import java.util.Arrays;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;

import com.joaogcm.spring.hearth.stone.entities.Carta;
import com.joaogcm.spring.hearth.stone.entities.enums.Classe;
import com.joaogcm.spring.hearth.stone.entities.enums.Tipo;
import com.joaogcm.spring.hearth.stone.repositories.CartaRepository;

@Configuration
@Profile("test")
public class Implementacao implements CommandLineRunner {

	@Autowired
	private CartaRepository cartaRepository;
	
	@Override
	public void run(String... args) throws Exception {
		
		Carta carta1 = new Carta(1, "Leao Bravo", "Leao que ataca porquinhos", 9, 6, Tipo.CRIATURA, Classe.CACADOR);
		Carta carta2 = new Carta(2, "Porco Espinho", "Porco espinho com poderes de fincar seus espinhos nos inimigos", 8, 4, Tipo.CRIATURA, Classe.PALADINO);
		Carta carta3 = new Carta(3, "Lobo Invisível", "Lobo invísivel muito poderoso", 10, 5, Tipo.CRIATURA, Classe.PALADINO);
		Carta carta4 = new Carta(4, "Onça Parda", "Onça com garras enormes que ataca pessoas e outros animais", 10, 3, Tipo.MAGIA, Classe.QUALQUER);
		
		cartaRepository.saveAll(Arrays.asList(carta1, carta2, carta3, carta4));
	}
}