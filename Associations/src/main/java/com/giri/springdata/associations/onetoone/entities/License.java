package com.giri.springdata.associations.onetoone.entities;

import java.util.Date;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.OneToOne;
import jakarta.persistence.Temporal;
import jakarta.persistence.TemporalType;

@Entity
public class License {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	private String type;
	@Temporal(TemporalType.DATE)
	private Date valid_from;
	@Temporal(TemporalType.DATE)
	private Date valid_to;

	@OneToOne(cascade = CascadeType.ALL)
	@JoinColumn(name = "person_id")
	private Person person;
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public String getType() {
		return type;
	}
	public void setType(String type) {
		this.type = type;
	}
	public Date getValid_from() {
		return valid_from;
	}
	public void setValid_from(Date valid_from) {
		this.valid_from = valid_from;
	}
	public Date getValid_to() {
		return valid_to;
	}
	public void setValid_to(Date valid_to) {
		this.valid_to = valid_to;
	}

	public Person getPerson() {
		return person;
	}

	public void setPerson(Person person) {
		this.person = person;
	}
	
}
