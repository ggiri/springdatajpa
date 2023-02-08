package com.giri.springdatajpa.multipleds;

import java.math.BigDecimal;
import java.util.List;
import java.util.Optional;
import java.util.function.Function;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.domain.Example;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.repository.query.FluentQuery.FetchableFluentQuery;

import com.giri.springdatajpa.multipleds.coupon.entities.Coupon;
import com.giri.springdatajpa.multipleds.coupon.repos.CouponRepository;
import com.giri.springdatajpa.multipleds.product.entities.Product;
import com.giri.springdatajpa.multipleds.product.repos.ProductRepository;

@SpringBootTest
class MultipleDataSourcesApplicationTests {
	
	@Autowired
	CouponRepository couponRepo;

	@Autowired
	ProductRepository productRepo;
	
	

	@Test
	void testCouponSave() {
		Coupon coupon = new Coupon();
		coupon.setCode("FEB60");
		coupon.setDiscount(new BigDecimal(60));
		coupon.setExpDate("14/02/2023");
		couponRepo.save(coupon);
	}

	@Test
	void testProductSave() {
		Product product = new Product();
		product.setName("cricket kit");
		product.setDescription("Kit with all the cricketing gear");
		product.setPrice(new BigDecimal(100));
		product.setCouponCode("FEB60");
		Product savedProduct = productRepo.save(product);
		System.out.println(savedProduct);
		
	}

}
