package com.joaogcm.spring.hearth.stone.resources.exceptions;

import javax.servlet.http.HttpServletRequest;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import com.joaogcm.spring.hearth.stone.services.exceptions.ConstraintViolationExceptionAPI;
import com.joaogcm.spring.hearth.stone.services.exceptions.ObjectNotFoundException;

@ControllerAdvice
public class ResourceExceptionHandler {

	@ExceptionHandler(ObjectNotFoundException.class)
	public ResponseEntity<StandardError> objectNotFound(ObjectNotFoundException e, HttpServletRequest request) {

		String error = "Carta não encontrada.";
		HttpStatus status = HttpStatus.NOT_FOUND;
		StandardError standard = new StandardError(System.currentTimeMillis(), status.value(), error, e.getMessage(),
				request.getRequestURI());

		return ResponseEntity.status(status).body(standard);
	}

	@ExceptionHandler(ConstraintViolationExceptionAPI.class)
	public ResponseEntity<StandardError> constraintViolation(ConstraintViolationExceptionAPI e,
			HttpServletRequest request) {
		String error = "Erro de validação.";
		HttpStatus status = HttpStatus.BAD_REQUEST;
		StandardError standard = new StandardError(System.currentTimeMillis(), status.value(), error, e.getMessage(),
				request.getRequestURI());

		return ResponseEntity.status(status).body(standard);
	}
}