package com.giri.springdatajpa.compositekey.entities;

import javax.persistence.EmbeddedId;
import javax.persistence.Entity;

@Entity
public class Customer {

	@EmbeddedId
	private CustomerId id;
	private String name;

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public CustomerId getId() {
		return id;
	}

	public void setId(CustomerId id) {
		this.id = id;
	}

}
