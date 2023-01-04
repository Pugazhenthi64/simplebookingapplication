package com.te.simplebookingsystem.exception;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;


public class RegistrationNotSuccessfullException  extends RuntimeException{

	public RegistrationNotSuccessfullException(String message) {
		super(message);
	}
	
	

}
