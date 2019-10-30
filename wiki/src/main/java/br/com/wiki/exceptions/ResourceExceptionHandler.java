package br.com.wiki.exceptions;

import javax.servlet.http.HttpServletRequest;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class ResourceExceptionHandler {

	@ExceptionHandler(ObjectNotFoundException.class)
	public ResponseEntity<StandardError> objectNotFound(ObjectNotFoundException exception, HttpServletRequest request) {
		StandardError error = new StandardError(HttpStatus.NOT_FOUND.value(), exception.getMessage(), System.currentTimeMillis());
		return ResponseEntity.status(HttpStatus.NOT_FOUND).body(error);
	}
	
	@ExceptionHandler(UnprocessableEntityException.class)
	public ResponseEntity<StandardError> unprocessableEntity(UnprocessableEntityException exception, HttpServletRequest request) {
		StandardError error = new StandardError(HttpStatus.UNPROCESSABLE_ENTITY.value(), exception.getMessage(), System.currentTimeMillis());
		return ResponseEntity.status(HttpStatus.UNPROCESSABLE_ENTITY).body(error);
	}
	
	@ExceptionHandler(IntegrityViolationException.class)
	public ResponseEntity<StandardError> integrityViolationException(IntegrityViolationException exception, HttpServletRequest request) {
		StandardError error = new StandardError(HttpStatus.CONFLICT.value(), exception.getMessage(), System.currentTimeMillis());
		return ResponseEntity.status(HttpStatus.CONFLICT).body(error);
	}
}
