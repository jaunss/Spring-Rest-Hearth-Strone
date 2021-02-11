package com.joaogcm.spring.hearth.stone.services.exceptions;

public class ObjectNotFoundException extends RuntimeException {

	private static final long serialVersionUID = 1L;
	
	public ObjectNotFoundException(Object id) {
		super("Carta não encontrada. ID = " + id);
	}
	
	public ObjectNotFoundException(String mensagem) {
		super(mensagem);
	}
}