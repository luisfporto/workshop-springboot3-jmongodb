package com.lp.workshopmongo.resources.exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import com.lp.workshopmongo.services.exception.ObjectNotFoundException;

import jakarta.servlet.http.HttpServletRequest;

@ControllerAdvice
/*
 * @ControllerAdvice indica que a classe é responsável por tratar possíveis
 * erros nas requisições
 */
public class ResourceExceptionHandler {
	@ExceptionHandler(ObjectNotFoundException.class)
	/*
	 * (ObjectNotFoundException.class) indica que ao ocorrer a exceção, a forma de
	 * tratamento deverá ser o que vem dentro das chaves
	 */
	public ResponseEntity<StandardError> objectNotFound(ObjectNotFoundException e, HttpServletRequest request) {
		HttpStatus status = HttpStatus.NOT_FOUND;
		StandardError err = new StandardError(System.currentTimeMillis(), status.value(), "Não encontrado",
				e.getMessage(), request.getRequestURI());
		return ResponseEntity.status(status).body(err);
	}
}
