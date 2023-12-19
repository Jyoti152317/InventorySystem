package com.xyz.Inventory_System.exception;

import java.util.HashMap;
import java.util.Map;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class GlobalExceptionHandler {

	@ExceptionHandler(value = { ItemNotFoundException.class })
	public ResponseEntity<ItemException> handleIllegalArgumentException(ItemNotFoundException ex) {
		ItemException error = new ItemException(ex.getMessage(), ex.getCause(), HttpStatus.NOT_FOUND);
		return ResponseEntity.status(HttpStatus.NOT_FOUND).body(error);
	}

	@ExceptionHandler(IllegalArgumentException.class)
	public ResponseEntity<ItemException> handleIllegalArgumentException(IllegalArgumentException ex) {
		ItemException error = new ItemException(ex.getMessage(), ex.getCause(), HttpStatus.BAD_REQUEST);
		return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(error);
	}

	@ExceptionHandler(MethodArgumentNotValidException.class)
	public ResponseEntity<Map<String, String>> handleMethodArgumentNotValidException(
			MethodArgumentNotValidException ex) {
		Map<String, String> response = new HashMap<>();
		ex.getBindingResult().getAllErrors().forEach((error) -> {
			String fieldName = ((FieldError) error).getField();
			String msg = error.getDefaultMessage();
			response.put(fieldName, msg);

		});
		return new ResponseEntity<Map<String, String>>(response, HttpStatus.BAD_REQUEST);

	}

}
