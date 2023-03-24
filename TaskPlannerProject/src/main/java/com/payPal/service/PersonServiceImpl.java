package com.payPal.service;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.payPal.exception.PersonException;
import com.payPal.model.Person;
import com.payPal.repository.PersonRepository;

@Service
public class PersonServiceImpl implements PersonService {

	@Autowired
	private PersonRepository personRepo;

	@Override
	public Person signUpPerson(Person person) {
		return personRepo.save(person);
	}

	@Override
	public Person getPersonById(Integer id) throws PersonException {
		Optional<Person> opt = personRepo.findById(id);

		opt.orElseThrow(() -> new PersonException("No Person Found!"));

		return opt.get();
	}

	@Override
	public String deltePerson(Integer id) throws PersonException {
		Optional<Person> opt = personRepo.findById(id);

		opt.orElseThrow(() -> new PersonException("No Person Found!"));
		
		personRepo.deleteById(id);
		
		return "Account deleted Successfully !";
	}

}
