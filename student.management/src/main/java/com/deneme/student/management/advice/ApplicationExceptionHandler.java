package com.deneme.student.management.advice;

import java.util.HashMap;
import java.util.Map;

import javax.validation.ConstraintViolation;
import javax.validation.ConstraintViolationException;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import com.deneme.student.management.exception.StudentNotFoundException;

/**
 * 
 * @author aslin
 *Arayüzden gönderilen verilerde StudentDTO nesnesi fieldları için tanımlanan validationlara 
 *uygunsuz veri olması halinde uygunsuzluğa özel hata mesajları göstermek için yazılır.
 */
@RestControllerAdvice
public class ApplicationExceptionHandler {
	
	@ResponseStatus(HttpStatus.BAD_REQUEST)
	@ExceptionHandler(ConstraintViolationException.class)
	public Map<String, String> handleInvalidArgument(ConstraintViolationException ex){
		
		Map<String, String> errMap = new HashMap<>();
		
		for (ConstraintViolation<?> violation : ex.getConstraintViolations()) {
			errMap.put(violation.getPropertyPath().toString(), violation.getMessage());
		}
		
		return errMap;
	}
	
	@ResponseStatus(HttpStatus.NOT_FOUND)
	@ExceptionHandler(StudentNotFoundException.class)
	public Map<String, String> handleInvalidArgument(StudentNotFoundException ex){
		
		Map<String, String> errMap = new HashMap<>();
		
			errMap.put("Hata: " , ex.getLocalizedMessage());
		
		
		return errMap;
	}
	
	}
