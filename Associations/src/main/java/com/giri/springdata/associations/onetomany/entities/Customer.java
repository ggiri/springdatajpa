package com.giri.springdata.associations.onetomany.entities;

import java.util.HashSet;
import java.util.Set;

import jakarta.persistence.*;

@Entity
public class Customer {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long id;
	private String name;
	@OneToMany(mappedBy="customer", cascade = CascadeType.ALL, fetch = FetchType.EAGER)
	private Set<PhoneNumber> phoneNumbers;
	public long getId() {
		return id;
	}
	public void setId(long id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public Set<PhoneNumber> getPhoneNumbers() {
		return phoneNumbers;
	}
	public void setPhoneNumbers(Set<PhoneNumber> phoneNumbers) {
		this.phoneNumbers = phoneNumbers;
	}

	@Override
	public String toString() {
		return "Customer{" +
				"id=" + id +
				", name='" + name + '\'' +
				", phoneNumbers=" + phoneNumbers +
				'}';
	}

	public void addPhoneNumber(PhoneNumber number){
		if(number != null){
			if(phoneNumbers == null){
				phoneNumbers = new HashSet<>();
			}
			number.setCustomer(this);
			phoneNumbers.add(number);
		}
	}
}
