package com.lbg.demo.phone.repos;

import org.springframework.data.jpa.repository.JpaRepository;

import com.lbg.demo.phone.domain.Phone;

public interface PhoneRepo extends JpaRepository<Phone, Integer> {

}
