package com.moontea.handler;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import com.moontea.exception.BookNotFoundException;
import com.moontea.resource.ErrorResource;

@RestControllerAdvice
public class ApiExceptionHandler {

	@ExceptionHandler(BookNotFoundException.class)
	@ResponseBody
	public ResponseEntity<?> handleNotFound(RuntimeException e) {
		ErrorResource errorResource = new ErrorResource(e.getMessage());
		return new ResponseEntity<Object>(errorResource, HttpStatus.NOT_FOUND);
	}

}
