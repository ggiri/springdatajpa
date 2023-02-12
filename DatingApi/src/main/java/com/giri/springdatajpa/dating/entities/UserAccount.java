package com.giri.springdatajpa.dating.entities;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToOne;

import lombok.Data;

@Data
@Entity
public class UserAccount {
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int Id;
	private String userName;
	private String password;
	private int age;
	private String email;
	private String phoneNumber;
	private String gender;
	private String city;
	private String country;
	@OneToOne(mappedBy="userAccount")
	private Interest interest;

}
