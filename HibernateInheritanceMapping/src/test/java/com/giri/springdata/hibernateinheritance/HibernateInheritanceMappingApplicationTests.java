package com.giri.springdata.hibernateinheritance;

import com.giri.springdata.hibernateinheritance.entities.Cheque;
import com.giri.springdata.hibernateinheritance.entities.CreditCard;
import com.giri.springdata.hibernateinheritance.repos.PaymentRepository;
import org.antlr.v4.runtime.misc.LogManager;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
class HibernateInheritanceMappingApplicationTests {

	@Autowired
	private PaymentRepository repository;

	@Test
	void contextLoads() {
	}

	@Test
	void testCreateCardPayment(){
		CreditCard cc = new CreditCard();
		cc.setId(111);
		cc.setAmount(1000.00);
		cc.setCreditCardNumber("1234567890");
		repository.save(cc);
	}

	@Test
	void testCreateChequePayment(){
		Cheque ch = new Cheque();
		ch.setId(123);
		ch.setAmount(1000.00);
		ch.setChequeNumber("1234567890");
		repository.save(ch);
	}

}
