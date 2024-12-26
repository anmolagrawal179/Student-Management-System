package com.sms.exception;

import java.time.LocalDateTime;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class GlobalExceptionHandler {

	@ExceptionHandler(value=StudentNotFoundException.class)
	public ResponseEntity<ErrorResponse> handleStudentNotFoundExeption(StudentNotFoundException exception){
		
		ErrorResponse errorResponse=new ErrorResponse();
		errorResponse.setTimestamp(LocalDateTime.now());
		errorResponse.setStatus(HttpStatus.NOT_FOUND.value());
		errorResponse.setError(HttpStatus.NOT_FOUND);
		errorResponse.setMessage(exception.getMessage());
		
		return new ResponseEntity<ErrorResponse>(errorResponse,HttpStatus.NOT_FOUND);
		
	}
}
