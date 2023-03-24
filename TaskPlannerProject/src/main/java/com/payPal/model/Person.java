package com.payPal.model;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import lombok.Data;

@Entity
@Data
public class Person {

	@Id
	private Integer personId;
	private String name;
	private String email;
	private String password;
}
