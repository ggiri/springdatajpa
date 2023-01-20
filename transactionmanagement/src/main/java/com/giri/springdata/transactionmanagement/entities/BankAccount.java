package com.giri.springdata.transactionmanagement.entities;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name="bankaccount")
public class BankAccount {
	
	@Id
	@Column(name = "accno")
	private int accNo;
	@Column(name="firstname")
	private String firstName;
	@Column(name="lastname")
	private String LastName;
	private int bal;
	public int getAccNo() {
		return accNo;
	}
	public void setAccNo(int accNo) {
		this.accNo = accNo;
	}
	public String getFirstName() {
		return firstName;
	}
	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}
	public String getLastName() {
		return LastName;
	}
	public void setLastName(String lastName) {
		LastName = lastName;
	}
	public int getBal() {
		return bal;
	}
	public void setBal(int bal) {
		this.bal = bal;
	}
	@Override
	public String toString() {
		return "BankAccount [accNo=" + accNo + ", firstName=" + firstName + ", LastName=" + LastName + ", bal=" + bal
				+ "]";
	}

}
