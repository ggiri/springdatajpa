package com.giri.springdata.idgenerators;

import java.util.Random;

import org.hibernate.HibernateException;
import org.hibernate.engine.spi.SharedSessionContractImplementor;
import org.hibernate.id.IdentifierGenerator;

public class CustomRandomIdGenerator implements IdentifierGenerator {

	@Override
	public Object generate(SharedSessionContractImplementor session, Object object) throws HibernateException {

		Random random = new Random();
		int id=0;
		id = random.nextInt(1000);
		return Long.valueOf(id);
	}

}
