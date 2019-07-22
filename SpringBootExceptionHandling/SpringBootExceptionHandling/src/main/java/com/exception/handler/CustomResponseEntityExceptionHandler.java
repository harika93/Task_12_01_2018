package com.exception.handler;

import java.util.Date;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.context.request.WebRequest;

import com.exception.StudentNotFoundException;
import com.exception.model.ErrorDetails;

@ControllerAdvice
public class CustomResponseEntityExceptionHandler{
	
	@ExceptionHandler(StudentNotFoundException.class)
	public final ResponseEntity<ErrorDetails> handleStudentNotFoundException(StudentNotFoundException ex, WebRequest request){
		ErrorDetails errorDetails= new ErrorDetails(new Date(), ex.getMessage(), request.getDescription(false));
		return new ResponseEntity<>(errorDetails, HttpStatus.NOT_FOUND);
	}
	
	
	/*
	 * For declaring two exceptions at same time we can use
	 * @ExceptionHandler(value = { IllegalArgumentException.class, IllegalStateException.class })
	 */
}
