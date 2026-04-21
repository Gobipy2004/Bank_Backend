package com.reserver.bankingApp.exception;

import java.util.LinkedHashMap;
import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class GlobalException {

	@ExceptionHandler(value = ResourceNotFoundException.class)
	public ResponseEntity<String> handleResourceNotFoundException(ResourceNotFoundException ex){
		ResponseEntity<String> rs=new ResponseEntity<>(ex.getMessage(),HttpStatus.NOT_FOUND);
		return rs;
	}
	
	@ExceptionHandler(value = MethodArgumentNotValidException.class)
	public ResponseEntity<LinkedHashMap<String, String>> handleMethodArgumentNotValidException(MethodArgumentNotValidException ex){
		LinkedHashMap<String, String> lm=new LinkedHashMap<>();
		List<FieldError> error=ex.getBindingResult().getFieldErrors();
		
		for(FieldError er:error) {
			String field=er.getField();
			String msg=er.getDefaultMessage();
			lm.put(field, msg);
		}
		return new ResponseEntity<LinkedHashMap<String,String>>(lm,HttpStatus.BAD_REQUEST);
	}
}
