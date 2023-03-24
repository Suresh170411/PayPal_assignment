package com.payPal.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.payPal.model.Person;
import com.payPal.repository.PersonRepository;

@Service
public class CustomUserDetailsService implements UserDetailsService {

	@Autowired
	private PersonRepository personRepo;
	
	
	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		
		Optional<Person> opt= personRepo.findByEmail(username);

		if(opt.isPresent()) {
			
			Person person = opt.get();
			
			List<GrantedAuthority> authorities= new ArrayList<>();
			
			
			return new User(person.getEmail(), person.getPassword(), authorities);
			
			
			
		}else {
			throw new BadCredentialsException("Details not found with this username: "+username);
		}
		
	}
	
}
