package com.payPal.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.core.Authentication;
import org.springframework.web.bind.annotation.GetMapping;

import com.payPal.model.Person;
import com.payPal.repository.PersonRepository;

@RestController
public class LoginController {

	@Autowired
	private PersonRepository personRepo;
	
	@GetMapping("/signIn")
	public ResponseEntity<Person> getLoggedInCustomerDetailsHandler(Authentication auth){
		
		
		Person person = personRepo.findByEmail(auth.getName()).orElseThrow(() -> new BadCredentialsException("Invalid Username or password"));
		
		 //to get the token in body, pass HttpServletResponse inside this method parameter 
		// System.out.println(response.getHeaders(SecurityConstants.JWT_HEADER));
		 
		 
		 return new ResponseEntity<>(person, HttpStatus.ACCEPTED);
	}
}
