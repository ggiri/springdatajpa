package com.giri.springdata.idgenerators.entities;

import org.hibernate.annotations.GenericGenerator;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;

@Entity
public class Employee {
	

	@GenericGenerator(name="emp_id", strategy = "com.giri.springdata.idgenerators.CustomRandomIdGenerator")
	@GeneratedValue(generator="emp_id")
//	@TableGenerator(name="employee_g", table="id_gen", pkColumnName = "gen_name", valueColumnName = "gen_value")
	@Id
//	@GeneratedValue(strategy = GenerationType.TABLE, generator = "employee_g")
	private Long id;
	private String name;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

}
