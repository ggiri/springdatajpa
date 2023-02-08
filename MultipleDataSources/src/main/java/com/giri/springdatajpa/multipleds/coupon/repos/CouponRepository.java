package com.giri.springdatajpa.multipleds.coupon.repos;

import org.springframework.data.jpa.repository.JpaRepository;

import com.giri.springdatajpa.multipleds.coupon.entities.Coupon;

public interface CouponRepository extends JpaRepository<Coupon, Long> {

}
