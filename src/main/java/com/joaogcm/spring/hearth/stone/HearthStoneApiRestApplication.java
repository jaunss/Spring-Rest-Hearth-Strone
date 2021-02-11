package com.joaogcm.spring.hearth.stone;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.joaogcm.spring.hearth.stone.implement.Implementacao;

@SpringBootApplication
public class HearthStoneApiRestApplication extends Implementacao {

	public static void main(String[] args) {
		SpringApplication.run(HearthStoneApiRestApplication.class, args);
	}

}
