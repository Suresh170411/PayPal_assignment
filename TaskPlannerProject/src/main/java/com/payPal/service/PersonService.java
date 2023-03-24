package com.payPal.service;

import com.payPal.exception.PersonException;
import com.payPal.model.Person;

public interface PersonService {

	public Person signUpPerson(Person person);
	
	public Person getPersonById(Integer id) throws PersonException;
	
	public String deltePerson(Integer id) throws PersonException;
}
