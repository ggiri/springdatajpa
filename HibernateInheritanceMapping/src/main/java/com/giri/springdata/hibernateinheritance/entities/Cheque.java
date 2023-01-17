package com.giri.springdata.hibernateinheritance.entities;

import jakarta.persistence.*;

@Entity
//@DiscriminatorValue("ch")
@Table(name="bankcheck")
@PrimaryKeyJoinColumn(name="id")
public class Cheque extends Payment{

	@Column(name="checknumber")
	private String chequeNumber;

	public String getChequeNumber() {
		return chequeNumber;
	}

	public void setChequeNumber(String chequeNumber) {
		this.chequeNumber = chequeNumber;
	}

}
