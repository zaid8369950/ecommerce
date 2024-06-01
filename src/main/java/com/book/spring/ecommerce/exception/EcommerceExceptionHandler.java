package com.book.spring.ecommerce.exception;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class EcommerceExceptionHandler {
	
	
	
	@ExceptionHandler(OrderNotFoundException.class)
	public ResponseEntity<ErrorMessage> getExceptionData(OrderNotFoundException exception){
		ErrorMessage errorMessage = new ErrorMessage(404, exception.getMessage());
		return new ResponseEntity<>(errorMessage,HttpStatus.NOT_FOUND);
	}
	@ExceptionHandler(ItemNotFoundException.class)
	public ResponseEntity<ErrorMessage> getExceptionData(ItemNotFoundException exception){
		ErrorMessage errorMessage = new ErrorMessage(404, exception.getMessage());
		return new ResponseEntity<>(errorMessage,HttpStatus.NOT_FOUND);
	}
}
