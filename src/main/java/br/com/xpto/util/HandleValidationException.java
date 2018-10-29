package br.com.xpto.util;

import javax.persistence.EntityNotFoundException;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.context.request.WebRequest;

public abstract class HandleValidationException {
	@SuppressWarnings({ "unchecked", "rawtypes" })
	@ExceptionHandler(EntityNotFoundException.class)
	public final ResponseEntity<Error> handlerValidationException(EntityNotFoundException e, WebRequest request) {
		return new ResponseEntity(new Error(e.getMessage()), HttpStatus.NOT_FOUND);
	}
}
