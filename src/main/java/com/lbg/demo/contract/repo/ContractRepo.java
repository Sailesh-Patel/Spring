package com.lbg.demo.contract.repo;

import org.springframework.data.jpa.repository.JpaRepository;

import com.lbg.demo.contract.domain.Contract;

public interface ContractRepo extends JpaRepository<Contract, Integer> {

}
