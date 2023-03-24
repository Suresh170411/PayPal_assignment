package com.payPal.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.payPal.model.Person;
import com.payPal.service.PersonService;

@RestController
public class PersonController {

	@Autowired
	private PersonService personService;
	
	@Autowired
	private PasswordEncoder passwordEncoder;
	
	@PostMapping("/person/signUp")
	public ResponseEntity<Person> signUpPersonHandler(@RequestBody Person person){
		
		person.setPassword(passwordEncoder.encode(person.getPassword()));
		
		return new ResponseEntity<Person>(personService.signUpPerson(person),HttpStatus.CREATED);
	}
}
