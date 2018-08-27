package br.com.bb.services.exception;

import javax.servlet.http.HttpServletRequest;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class ServiceExceptionHandler {

	@ExceptionHandler(EntityNotFoundException.class)
	public ResponseEntity<StandardError> entityNotFound(EntityNotFoundException e, HttpServletRequest request){
		StandardError error = new StandardError(HttpStatus.NOT_FOUND.value(), "Entidade não encontrada", e.getMessage(), request.getRequestURI());
		return ResponseEntity.status(HttpStatus.NOT_FOUND).body(error);
	}
	
	@ExceptionHandler(NumberFormatException.class)
	public ResponseEntity<StandardError> numberFormatException(NumberFormatException e, HttpServletRequest request){
		StandardError error = new StandardError(HttpStatus.BAD_REQUEST.value(), "Erro ao converter o valor para o tipo inteiro", e.getMessage(), request.getRequestURI());
		return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(error);
	}
}
