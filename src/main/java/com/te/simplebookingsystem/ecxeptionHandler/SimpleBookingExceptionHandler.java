package com.te.simplebookingsystem.ecxeptionHandler;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestController;

import com.te.simplebookingsystem.exception.RegistrationNotSuccessfullException;
import com.te.simplebookingsystem.response.ResponsePage;

@RestController
public class SimpleBookingExceptionHandler {

	@Autowired
	private ResponsePage page;

	@ExceptionHandler(RegistrationNotSuccessfullException.class)
	ResponseEntity<ResponsePage> exception(RegistrationNotSuccessfullException notSuccessfullException) {
		page.setMessage(notSuccessfullException.getMessage());
		return new ResponseEntity<ResponsePage>(page, HttpStatus.BAD_REQUEST);
	}

}
