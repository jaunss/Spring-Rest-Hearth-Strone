package com.joaogcm.spring.hearth.stone.services.exceptions;

public class ConstraintViolationExceptionAPI extends RuntimeException {

	private static final long serialVersionUID = 1L;

	public ConstraintViolationExceptionAPI(String mensagem) {
		super(mensagem);
	}
}