package com.city.connections.web;

import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.MissingServletRequestParameterException;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.NoHandlerFoundException;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

import com.city.connections.common.Constants;

/**
 * Custom controller advice class to handle possible exception
 * thrown when calling REST endpoint for city connections. 
 * 
 * @author Ranga
 *
 */
@RestControllerAdvice
@EnableWebMvc
public class ExceptionsController extends ResponseEntityExceptionHandler {
	
	@Override
	protected ResponseEntity<Object> handleMissingServletRequestParameter(
			MissingServletRequestParameterException ex, HttpHeaders headers, HttpStatus status, WebRequest request) {
		return new ResponseEntity<>(Constants.EXCEPTION_MESSAGE, status);
	}
	
	@Override
	protected ResponseEntity<Object> handleNoHandlerFoundException(
			NoHandlerFoundException ex, HttpHeaders headers, HttpStatus status, WebRequest request) {
		return new ResponseEntity<>(ex.getMessage(), status);
	}
}