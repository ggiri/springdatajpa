package com.giri.springdata.hibernateinheritance.entities;

import jakarta.persistence.*;

@Entity
//@DiscriminatorValue("cc")
@Table(name="card")
@PrimaryKeyJoinColumn(name="id")
public class CreditCard extends Payment {
    @Column(name = "cardnumber")
    private String creditCardNumber;

    public String getCreditCardNumber() {
        return creditCardNumber;
    }

    public void setCreditCardNumber(String creditCardNumber) {
        this.creditCardNumber = creditCardNumber;
    }
}
